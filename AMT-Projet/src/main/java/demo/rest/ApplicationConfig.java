package demo.rest;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Marco Monzione - Simon Baehler
 */
@javax.ws.rs.ApplicationPath("/api")
public class ApplicationConfig extends Application {

    /**
     *
     * @return
     */
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
        resources.add(demo.rest.UsersManagerRest.class);
    }
    
}
