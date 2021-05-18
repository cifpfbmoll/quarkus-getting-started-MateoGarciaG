package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

/* 
* Similar a SINGLETON, nos permite tener un solo objeto durante todo el ciclo de vida de la aplicación
*/
@ApplicationScoped
public class GreetingService {

    public String toUpperCase(String msg) {
        return msg.toUpperCase();
    }

    
}
