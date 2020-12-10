/**
 * Class name: SpriteFacade.java
 * Description: Extends AbstractFacade and calls upon its functionality
 * 
 * @author tgk
 * @version 1
 * @since 2020/11/20
 */
package cst8218.blai0274.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteAlex-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
