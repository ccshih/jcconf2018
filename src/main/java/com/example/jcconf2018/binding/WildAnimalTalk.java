package com.example.jcconf2018.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WildAnimalTalk {
    @Output 
    MessageChannel wolfTalk();
    
    @Output 
    MessageChannel lionTalk();
}
