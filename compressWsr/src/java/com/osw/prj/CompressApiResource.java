/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osw.prj;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import compressproject.CompressProject;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author oswal
 */
@Path("compressApi")
public class CompressApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompressApiResource
     */
    public CompressApiResource() {
    }

    /**
     * Retrieves representation of an instance of com.osw.prj.CompressApiResource
     * @return an instance of java.lang.String
     */
    @GET    
    @Produces("application/json")
    public Response getJson(@QueryParam("access")String access) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        JsonObjectBuilder jsonObjectBuilder =   Json.createObjectBuilder();
        jsonObjectBuilder.add("reply", "Oswaldo A. Morales");
        JsonObject jsonObject = jsonObjectBuilder.build();
        return Response.ok(jsonObject.toString())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
        .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postJson(String content) {
        JSONObject obj = new JSONObject(content);
        String value = obj.getString("value");
        String result = CompressProject.compress(value);
        
        JsonObjectBuilder jsonObjectBuilder =   Json.createObjectBuilder();
        jsonObjectBuilder.add("compressed", result);
        JsonObject jsonObject = jsonObjectBuilder.build();
        return Response.ok(jsonObject.toString())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
        .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
}
