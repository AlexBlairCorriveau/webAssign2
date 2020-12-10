/**
 * Class name: ApplicationConfig.java
 * Description: auto-generated
 * 
 * @author alexb
 * @version 1
 * @since 2020/11/17
 */

package service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 *
 * @author alexb
 */

// This checks the appuser table for the user id, the groupname and the password
@DatabaseIdentityStoreDefinition (
   dataSourceLookup = "${'java:comp/DefaultDataSource'}",
   callerQuery = "#{'select password from app.appuser1 where userid = ?'}",
   groupsQuery = "select groupname from app.appuser1 where userid = ?",
   hashAlgorithm = PasswordHash.class,
   priority = 10
   )

//This generates the basic authentication when app first opens up. Will require the userid and passowrd

//If we have to demo, uncomment everything below line 44, and comment out line 44

//@BasicAuthenticationMechanismDefinition
@FormAuthenticationMechanismDefinition(
  loginToContinue = @LoginToContinue(
     loginPage = "/index.xhtml",
     errorPage = "/index.xhtml"))

@Named
@ApplicationScoped
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.SpriteFacadeREST.class);
    }
}
