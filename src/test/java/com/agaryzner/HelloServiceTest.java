package com.agaryzner;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceTest {

    private HelloService System_Under_Test = new HelloService();

    @Test
    @DisplayName("test prepare greeting null, returns greeting with fallback value")

    public void testPrepareGreetingWithoutName() {
        var result = System_Under_Test.prepareGreeting(null);
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    @DisplayName("test prepare greeting with name, returns greeting with value")
    public void testPrepareGreetingWithName() {
        var name = "test";
        var result = System_Under_Test.prepareGreeting(name);
        assertEquals("Hello " + name + "!", result);
    }
}
