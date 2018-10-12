package com.example.jcconf2018.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CuteAnimalListen {
    @Input 
    SubscribableChannel dogAlert();
    
    @Input 
    SubscribableChannel catAlert();
}
