/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.api;

import com.douxsystem.siat.domain.entities.User;
import java.math.BigDecimal;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author santiago
 */
@Path("/Users")
public class UserApplication {

    private static final String PERSISTENCE_UNIT_NAME = "SIAT_PersistanceUnit";
    private static EntityManagerFactory factory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject ReturnAllUsers() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        JsonObject jsonb;
        try {
            List<User> users = em.createNamedQuery("User.ReturnAllUsers").getResultList();
            if (users.size() > 0) {
                JsonArrayBuilder jsonab = Json.createArrayBuilder();
                for (User user : users) {
                    JsonObjectBuilder jsonob = Json.createObjectBuilder();
                    jsonob.add("ID", user.getId());
                    jsonob.add("Nombre", user.getNombre());
                    jsonob.add("ApellidoPaterno", user.getApellidoPaterno());
                    jsonob.add("ApellidoMaterno", user.getApellidoMaterno());
                    jsonob.add("CorreoElectronico", user.getCorreoElectronico());
                    jsonab.add(jsonob);
                }
                jsonb = Json.createObjectBuilder().add("Status", true).add("Usuarios", jsonab).build();
            } else {
                jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", "No hay usuarios registrados").build();
            }

        } catch (Exception ex) {
            jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", ex.getMessage()).build();
        } finally {
            em.close();
        }

        return jsonb;
    }

    @POST
    @Path("/Create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject Create(UserApplication user) {
        return null;
    }
}
