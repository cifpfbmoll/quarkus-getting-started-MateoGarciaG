package org.acme.getting.started;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    // Consumes: Consume los recursos provenientes del endpoint. Esto es simplemente para indicarle que este método es para consumir los recursos que se insertan en este Recurso Endpoint
    // CURL POST: curl -d '{"name":"Alhambra", "capacity":500}' -H "Content-Type: application/json" -X POST http://localhost:8080/hello
    // MediaType
    // @Valid: Nos permite indicarle que el objeto que entrá dentro del método a travez de los datos/recursos que vienen del endpoint sean VALIDOS, como por ejemplo que sus tipos sean los correctos. Si no es valida, enviará una Bad Request, incluso @Valid chequeará que dentro de la Clase Beer tenga @anotaciones de validación como por ejemplo @Min(100)

    // @NotExpired Add. Use Now: 
    // Beer Not Expired: curl -d '{"name":"Alhambra", "capacity":500, "expired":"2022-10-01"}' -H "Content-Type: application/json" -X POST http://localhost:8080/hello
    // Beer Expired: curl -d '{"name":"Alhambra", "capacity":500, "expired":"2019-07-01"}' -H "Content-Type: application/json" -X POST http://localhost:8080/hello

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeer(@Valid Beer beer) {
        System.out.println(beer);
        // Status Code 200: ok().build()
        return Response.ok().build();
    }


    // Produces: Produce an Response which it's an Serializable Object from the Endpoint resource
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beer hello() {
        /**
         * Al enviar el objeto Beer() al endpoint este necesita ser serializado para poder ser mostrado en el Endpoint, pero necesitamos del pluging de Quarkus llamado: resteasy-jsonb // El cual nos permite facilitar el proceso de serialización del objeto a JSON hacía el endpoint
         */
        return new Beer("Alhambra", 500);
    }

}