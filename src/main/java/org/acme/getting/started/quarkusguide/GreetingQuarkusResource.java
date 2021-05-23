package org.acme.getting.started.quarkusguide;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.GreetingService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

class GreetingQuarkusResource {

    @Inject
    GreetingQuarkusService service;

    // curl -w "\n" http://localhost:8080/hello/greeting/quarkus
    //hello quarkus
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}