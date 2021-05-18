package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    

    /* 
    * Inyectamos el objeto GreetingsService
    */
    // @Inject
    // GreetingService service;


    // @GET
    // @Produces(MediaType.TEXT_PLAIN)
    // public String hello() {
    //     return service.toUpperCase();
    // }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Beer hello() {
        /**
         * Al enviar el objeto Beer() al endpoint este necesita ser serializado para poder ser mostrado en el Endpoint, pero necesitamos del pluging de Quarkus llamado: resteasy-jsonb // El cual nos permite facilitar el proceso de serialización del objeto a JSON hacía el endpoint
         */
        return new Beer("Alhambra", 500);
    }

}