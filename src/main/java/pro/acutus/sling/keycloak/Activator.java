package pro.acutus.sling.keycloak;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    public void start(BundleContext context) throws Exception {
        LOG.fine("pro.acutus.sling.keycloak.Activator::start");
    }

    public void stop(BundleContext context) throws Exception {
        LOG.fine("pro.acutus.sling.keycloak.Activator::stop");
    }

}
