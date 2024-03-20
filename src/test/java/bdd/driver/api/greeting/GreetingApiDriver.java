package bdd.driver.api.greeting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import bdd.feature.greeting.GreetingDsl;

@Component
@ConditionalOnProperty(prefix = "bdd", name = "driver", havingValue = "api")
public class GreetingApiDriver implements GreetingDsl {

    @Override
    public GreetingDsl givenInformalSetting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenInformalSetting'");
        // return this;
    }

    @Override
    public GreetingDsl whenIGreet(String personName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'whenIGreet'");
        // return this;
    }

    @Override
    public GreetingDsl thenIGetGreetingMessage(String expectedGreetingMessage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'thenIGetGreetingMessage'");
        // return this;
    }

    @Override
    public GreetingDsl givenFormalSetting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenFormalSetting'");
    }

    @Override
    public GreetingDsl givenItIsMorning() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenItIsMorning'");
        // return this;
    }

    @Override
    public GreetingDsl givenItIsAfternoon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenItIsAfternoon'");
        // return this;
    }

    @Override
    public GreetingDsl givenItIsEvening() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenItIsEvening'");
        // return this;
    }

    @Override
    public GreetingDsl givenItIsAtNight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'givenItIsAtNight'");
        // return this;
    }

}
