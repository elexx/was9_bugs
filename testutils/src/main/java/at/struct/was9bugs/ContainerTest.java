package at.struct.was9bugs;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;

/** Heavily based on http://openwebbeans.apache.org/testing_cdictrl.html */
public abstract class ContainerTest {

    private static volatile CdiContainer cdiContainer;

    /** Fills all the InjectionPoints of the current test class. */
    @BeforeClass
    public final void beforeClass() throws Exception {
        if (cdiContainer == null) {
            cdiContainer = CdiContainerLoader.getCdiContainer();
            cdiContainer.boot();
            cdiContainer.getContextControl().startContexts();
        }

        BeanManager beanManager = cdiContainer.getBeanManager();

        CreationalContext creationalContext = beanManager.createCreationalContext(null);

        AnnotatedType annotatedType = beanManager.createAnnotatedType(getClass());
        InjectionTarget injectionTarget = beanManager.createInjectionTarget(annotatedType);
        injectionTarget.inject(this, creationalContext);
    }

    /** Get a fresh SessionScope and RequestScope for each test. */
    @BeforeMethod
    public final void cleanInstances() throws Exception {
        cdiContainer.getContextControl().stopContext(RequestScoped.class);
        cdiContainer.getContextControl().startContext(RequestScoped.class);
        cdiContainer.getContextControl().stopContext(SessionScoped.class);
        cdiContainer.getContextControl().startContext(SessionScoped.class);
    }

    /** Shut the Container down. Do this only once the Suite is done, to avoids unneccessary reboots of the container. */
    @AfterSuite
    public synchronized void shutdownContainer() throws Exception {
        if (cdiContainer != null) {
            cdiContainer.shutdown();
            cdiContainer = null;
        }
    }
}
