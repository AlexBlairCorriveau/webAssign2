/**
 * Class name: SpriteFacadeREST.java
 * Description: Performs all the API request operations
 * 
 * @author alexb
 * @version 1
 * @since 2020/11/17
 */
package service;

import cst8218.blai0274.entity.Sprite;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless

//Only allow
@DeclareRoles({"Admin", "RestGroup"})
@RolesAllowed({"Admin", "RestGroup"})
@Path("cst8218.blai0274.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteAlex-ejbPU")
    private EntityManager em;

    /** 
     * Default constructor
     * Calls upon the parent Abstract Facade class
     */
    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    /** 
     * Create function used to call upon the parent class create function and pass in a sprite object
     * @param entity: sprite object used to be passed through the parent class create function
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }

    /**
     * Edit function calls upon the parent edit function to edit an entity object
     * @param id: the id of the entity object
     * @param entity: sprite object used to be passed through the parent class edit function
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Sprite entity) {
        super.edit(entity);
    }

    /**
     * Remove function calls upon the parent remove function to delete an entity object by id
     * @param id: the id of the entity object to be deleted
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * Find function will return an entity object by id
     * @param id: the id of the related entity object
     * @return the parent class's findall() function
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Findall will return the list of sprites
     * @return the parent class's findall() function
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    /**
     * Findrange will return the list of sprites within a specific range of integer values
     * @param from: the designated start value
     * @param to: the designated end value
     * @return the parent class's findrange() function
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * CountREST will count the number of existing sprites
     * @return a string value of the parent class's count() function
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     * GetEntityManager will return the em object 
     * @return em 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
