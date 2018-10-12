package com.example.jcconf2018.processor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.jcconf2018.binding.WildAnimalTalk;
import com.example.jcconf2018.model.Dialect;
import com.example.jcconf2018.util.Util;

/**
 * Periodically produce howl and roar messages
 * @author ccshih
 *
 */

@EnableBinding(WildAnimalTalk.class)
public class WildTalk {
	private static final Logger logger = LoggerFactory.getLogger(WildTalk.class);
	
	@Autowired
	private WildAnimalTalk wildAnimalSpeak;
	
    @Scheduled(fixedRate = 10000)
	void howl() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	String message = "I am angry @ " + new Date();
    	Message<? extends Dialect> howlMessage = getMessageObject(message, "Howl");
		wildAnimalSpeak.wolfTalk().send(howlMessage);
		logger.info(howlMessage.getPayload().toWords());
	}
    
    @Scheduled(fixedRate = 30000)
	void roar() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	String message = "I am hungry @ " + new Date();
    	Message<? extends Dialect> roarMessage = getMessageObject(message, "Roar");
		wildAnimalSpeak.lionTalk().send(roarMessage);
		logger.info(roarMessage.getPayload().toWords());
	}
    
    private Message<? extends Dialect> getMessageObject(String message, String dialectName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	Dialect dialect = createDialectObjectByName(dialectName);
    	dialect.setMessage(message);
    	return Util.getMessageObject(dialect); 
    }    
    
    private Dialect createDialectObjectByName(String dialect) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	String className = getModelPackageName() + "." + dialect;
    	return (Dialect) Class.forName(className).newInstance();
    }
    
    private String getModelPackageName() {
    	return this.getClass().getPackage().getName().replaceAll("processor", "model");   // quick workaround
    }
    
}
