package com.example.jcconf2018.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import com.example.jcconf2018.binding.*;
import com.example.jcconf2018.model.*;
import com.example.jcconf2018.util.Util;

/**
 * Subscribe WildAnimal channels, and publish to CuteAnimal channels
 * @author ccshih
 *
 */

@EnableBinding({ CuteAnimal.class, WildAnimal.class })
public class Alarm {

	@Autowired
	private CuteAnimal cuteAnimal;

	@StreamListener("listenToWolf")
	@SendTo("talkToDog")
	Bark dogAlarm(Howl howl) {
		return new Bark(howl);
	}

	@StreamListener("listenToLion")
	void dogAlarm(Roar roar) {
		cuteAnimal.talkToDog().send(Util.getMessageObject(new Bark(roar)));
		cuteAnimal.talkToCat().send(Util.getMessageObject(new Meow(roar)));
	}

}
