/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.api;

import com.douxsystem.siat.domain.entities.Brand;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Santiago
 */
@Path("/Brands")
public class BrandApplication {

    private static final String PERSISTENCE_UNIT_NAME = "SIAT_PersistanceUnit";
    private static EntityManagerFactory factory;

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject ReturnAllBrands() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        JsonObject jsonb;
        try {
            List<Brand> brands = em.createQuery("SELECT b FROM Brand b").getResultList();
            if (brands.size() > 0) {
                JsonArrayBuilder jsonab = Json.createArrayBuilder();
                for (Brand brand : brands) {
                    JsonObjectBuilder jsonob = Json.createObjectBuilder();
                    jsonob.add("ID", brand.getId());
                    jsonob.add("NombreMarca", brand.getNombreMarca());
                    jsonob.add("Origen", brand.getOrigen());
                    jsonab.add(jsonob);
                }
                jsonb = Json.createObjectBuilder().add("Marcas", jsonab).add("Status", true).build();
            } else {
                jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", "No hay elementos en 'Marcas'").build();
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
    public JsonObject CreateNewBrand(JsonObject jsonbrand) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        JsonObject jsonb;
        try {
            Brand brand = new Brand();
            brand.setNombreMarca(jsonbrand.getString("NombreMarca"));
            brand.setOrigen(jsonbrand.getString("Origen"));
            em.getTransaction().begin();
            em.persist(brand);
            em.getTransaction().commit();
            jsonb = Json.createObjectBuilder().add("Status", true).add("Mensaje", "Se ha guardado la nueva marca").build();
        } catch (Exception ex) {
            jsonb = Json.createObjectBuilder().add("Status", false).add("Mensaje", ex.getMessage()).build();
        } finally {
            em.close();
        }
        return jsonb;
    }

    @Path("/Search/{name}")
    public JsonObject ReturnSpecificBrand(@PathParam("name") String nombre) {
        return null;
    }
}
