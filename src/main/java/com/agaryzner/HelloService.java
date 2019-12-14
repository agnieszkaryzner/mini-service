package com.agaryzner;

import java.util.Optional;

public class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANGUAGE = new Language(1L,"Hello","en");

    private LanguageRepository repository;

    HelloService(){
        this(new LanguageRepository());
    }
    HelloService (LanguageRepository repository){
        this.repository = repository;
    }

    String prepareGreeting(String name) {
        return prepareGreeting(name, FALLBACK_LANGUAGE.getId());
    }

    String prepareGreeting (String name, Long languageId) {
        var welcomeMessage = repository.findById(languageId).orElse(FALLBACK_LANGUAGE).getWelcomeMessage();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMessage + " " + nameToWelcome + "!";
    }
}
