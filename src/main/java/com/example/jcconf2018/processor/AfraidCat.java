package com.example.jcconf2018.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.example.jcconf2018.binding.CuteAnimalListen;
import com.example.jcconf2018.model.Meow;

/**
 * Cat subscribed to CuteAnimalListen channels
 * @author ccshih
 *
 */

@EnableBinding(CuteAnimalListen.class)
public class AfraidCat {
	
	private static final Logger logger = LoggerFactory.getLogger(AfraidCat.class);

	@StreamListener("catAlert")
	void process(Meow meow) {
		logger.info(meow.toWords());
	}
	
}
