package com.araltiparmak.springbootjunitmockito.springcontexttestsample;

import org.springframework.stereotype.Component;

@Component
public class YannyWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Yanny";
    }
}
