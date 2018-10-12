package com.example.jcconf2018.util;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import com.example.jcconf2018.model.Dialect;

public class Util {

	public static Message<? extends Dialect> getMessageObject(Dialect dialect) {
		return MessageBuilder.withPayload(dialect).build();
	}
	
}
