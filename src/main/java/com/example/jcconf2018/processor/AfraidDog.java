package com.example.jcconf2018.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.example.jcconf2018.binding.CuteAnimalListen;
import com.example.jcconf2018.model.Bark;

/**
 * Dog subscribed to CuteAnimalListen channels
 * @author ccshih
 *
 */

@EnableBinding(CuteAnimalListen.class)
public class AfraidDog {
	
	private static final Logger logger = LoggerFactory.getLogger(AfraidDog.class);

	@StreamListener("dogAlert")
	void process(Bark bark) {
		logger.info(bark.toWords());
	}
	
}
