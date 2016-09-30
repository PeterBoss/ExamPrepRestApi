/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boss.rest_apis;

import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("world")
public class GenericResource {

    Facade fac;

    @Context
    private UriInfo context;

    public GenericResource() {
        fac = new Facade();
        fac.addEntityManagerFactory(Persistence.createEntityManagerFactory("Boss_REST_APIs_war_1.0PU"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries() {
        return JSONConverter.getJSONfromCountry(fac.getCountries());
    }

    @GET
    @Path("{pop}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries(@PathParam("pop") int pop) {
        return JSONConverter.getJSONfromCountry(fac.getCountries(pop));
    }

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCities(@PathParam("id") String code) {
        return JSONConverter.getJSONfromCity(fac.getCities(code));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createCity(String content) {
        return JSONConverter.getJSONfromCity(fac.createCity(JSONConverter.getCityFromJSON(content)));
    }

}
