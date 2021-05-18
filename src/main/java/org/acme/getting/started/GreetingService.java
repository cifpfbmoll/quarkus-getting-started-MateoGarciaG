package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/* 
* Similar a SINGLETON, nos permite tener un solo objeto durante todo el ciclo de vida de la aplicación
*/
@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name = "greetings.message")
    String msg;

    public String toUpperCase() {
        return this.msg.toUpperCase();
    }

    
}
