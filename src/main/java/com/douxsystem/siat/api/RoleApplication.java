/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.api;

import com.douxsystem.siat.domain.entities.Role;
import java.math.BigDecimal;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Santiago
 */
@Path("/Roles")
public class RoleApplication {

    private static final String PERSISTENCE_UNIT_NAME = "SIAT_PersistanceUnit";
    private static EntityManagerFactory factory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject ReturnAllRoles() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        JsonObject jsonb;
        try {
            List<Role> roles = em.createQuery("SELECT r FROM Role r").getResultList();
            if (roles.size() > 0) {
                JsonArrayBuilder jsonab = Json.createArrayBuilder();
                for (Role role : roles) {
                    JsonObjectBuilder jsonob = Json.createObjectBuilder();
                    jsonob.add("ID", role.getId());
                    jsonob.add("Nombre", role.getNombreRol());
                    jsonob.add("NivelAccesso", role.getNivelAccesso());
                    jsonab.add(jsonob);
                }
                jsonb = Json.createObjectBuilder().add("Status", true).add("Roles", jsonab).build();
            }
            else{
                jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", "No hay elementos en 'Roles'").build();
            }
        } catch (Exception ex) {
            jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", ex.getMessage()).build();
        } finally {
            em.close();
        }
        return jsonb;
    }
}
