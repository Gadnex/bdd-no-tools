package bdd.feature.greeting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bdd.TestConfig;

/**
 * Feature: Generate greeting message
 */
@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@TestPropertySource(locations = "classpath:application-bdd.properties")
@DisplayName("Generate Greeting Message")
class GenerateGreetingMessageFeature {

    @Autowired
    private GreetingDsl greeter;

    @Test
    @DisplayName("Should greet normally")
    void shouldGreetNormally() {
        greeter.givenInformalSetting()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Hello John");
    }

    @Test
    @DisplayName("Should greet normally in the morning")
    void shouldGreetNormallyInTheMorning() {
        greeter.givenInformalSetting()
                .givenItIsMorning()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Hello John");
    }

    @Test
    @DisplayName("Should greet normally in the afternoon")
    void shouldGreetNormallyInTheAfternoon() {
        greeter.givenInformalSetting()
                .givenItIsAfternoon()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Hello John");
    }

    @Test
    @DisplayName("Should greet normally in the evening")
    void shouldGreetNormallyInTheEvening() {
        greeter.givenInformalSetting()
                .givenItIsEvening()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Hello John");
    }

    @Test
    @DisplayName("Should greet normally at night")
    void shouldGreetNormallyAtNight() {
        greeter.givenInformalSetting()
                .givenItIsAtNight()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Hello John");
    }

    @Test
    @DisplayName("Should greet formally")
    void shouldGreetFormally() {
        greeter.givenFormalSetting()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Good day John");
    }

    @Test
    @DisplayName("Should greet formally in the morning")
    void shouldGreetFormallyInTheMorning() {
        greeter.givenFormalSetting()
                .givenItIsMorning()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Good morning John");
    }

    @Test
    @DisplayName("Should greet formally in the afternoon")
    void shouldGreetFormallyInTheAfternoon() {
        greeter.givenInformalSetting()
                .givenItIsAfternoon()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Good afternoon John");
    }

    @Test
    @DisplayName("Should greet formally in the evening")
    void shouldGreetFormallyInTheEvening() {
        greeter.givenInformalSetting()
                .givenItIsEvening()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Good evening John");
    }

    @Test
    @DisplayName("Should greet formally at night")
    void shouldGreetFormallyAtNight() {
        greeter.givenInformalSetting()
                .givenItIsAtNight()
                .whenIGreet("John")
                .thenIGetGreetingMessage("Good night John");
    }

}