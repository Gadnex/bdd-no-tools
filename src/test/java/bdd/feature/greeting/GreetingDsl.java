package bdd.feature.greeting;

public interface GreetingDsl {

    GreetingDsl givenInformalSetting();

    GreetingDsl givenFormalSetting();

    GreetingDsl givenItIsMorning();

    GreetingDsl givenItIsAfternoon();

    GreetingDsl givenItIsEvening();

    GreetingDsl givenItIsAtNight();

    GreetingDsl whenIGreet(String personName);

    GreetingDsl thenIGetGreetingMessage(String expectedGreetingMessage);

}