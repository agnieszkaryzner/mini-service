package com.agaryzner;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private final static String WELCOME = "Hello";

    @Test
    public void test_prepareGreeting_nullName_returnsGreetingWithFallbackName() {
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        // when
        var result = SUT.prepareGreeting(null, "-1");
        //then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }


    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
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
