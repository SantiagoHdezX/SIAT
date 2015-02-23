/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.api;

import com.douxsystem.siat.domain.entities.Address;
import com.douxsystem.siat.domain.entities.Role;
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
    public JsonObject Create(JsonObject user) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Role role = new Role();
        role.setId(Long.valueOf("1"));
        role.setNombreRol("Usuario");
        role.setNivelAccesso(Byte.parseByte("1"));
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        JsonObject _address = user.getJsonObject("Address");
        Address address = new Address();
        address.setCalle(_address.getString("Calle"));
        address.setColonia(_address.getString("Colonia"));
        address.setDelegacion(_address.getString("Delegacion"));
        address.setEstado(_address.getString("Estado"));
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        User cuser = new User();
        cuser.setNombre(user.getString("Nombre"));
        cuser.setApellidoPaterno(user.getString("ApellidoPaterno"));
        cuser.setApellidoMaterno(user.getString("ApellidoMaterno"));
        cuser.setCorreoElectronico(user.getString("CorreoElectronico"));
        cuser.setPasswd(user.getString("Passwd"));
        cuser.setAddress(address);
        cuser.setRole(role);
        em.getTransaction().begin();
        em.persist(cuser);
        em.getTransaction().commit();
        return Json.createObjectBuilder().add("Status", true).build();
    }
}
