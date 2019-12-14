package com.agaryzner;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceTest {
    private static final String WELCOME = "Hello";

    @Test
    @DisplayName("test prepare greeting null, returns greeting with fallback value")

    public void testPrepareGreetingWithoutName() {

        var mockRepository = alwaysReturningHelloRepository();
        var System_Under_Test = new HelloService(mockRepository);
        var result = System_Under_Test.prepareGreeting(null,"-1");
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    @DisplayName("test prepare greeting with name, returns greeting with value")
    public void testPrepareGreetingWithName() {
        var mockRepository = alwaysReturningHelloRepository();
        var System_Under_Test = new HelloService(mockRepository);
        String name = "test";
        var result = System_Under_Test.prepareGreeting(name,"-1");
        assertEquals(WELCOME + " " + name + "!", result);
    }
    private LanguageRepository alwaysReturningHelloRepository(){
        return new LanguageRepository() {
            @Override
            Optional<Language> findById (Long id) {
                return Optional.of(new Language(null,WELCOME, null));
            }
        };
    }
}
