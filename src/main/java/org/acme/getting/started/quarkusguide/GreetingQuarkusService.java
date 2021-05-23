package org.acme.getting.started.quarkusguide;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingQuarkusService {

    public String greeting(String name) {
        return "hello " + name;
    }

}