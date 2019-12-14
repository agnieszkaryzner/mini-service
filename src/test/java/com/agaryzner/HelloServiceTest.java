package com.agaryzner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloServiceTest {
    private final static String WELCOME = "Hello";

    @Test
    @DisplayName("test prepare greeting null, returns greeting with fallback value")
    public void testPrepareGreetingWithoutName() {
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        // when
        var result = SUT.prepareGreeting(null, "-1");
        //then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }


    @Test
    @DisplayName("test prepare greeting with name, returns greeting with value")
    public void testPrepareGreetingWithName() {
        //given
        var SUT = new HelloService();
        var name = "test";
        // when
        var result = SUT.prepareGreeting(name, "-1");
        //then
        assertEquals(WELCOME + " "+ name + "!", result);
    }

    private LanguageRepository alwaysReturningHelloRepository() {
        return new LanguageRepository(){
            Optional<Language> findById (Long id){
                return Optional.of(new Language(null, WELCOME, null));
            }
        };
    }
}
