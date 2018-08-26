package pro.acutus.sling.keycloak;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.sling.auth.core.spi.AuthenticationHandler;
import org.apache.sling.auth.core.spi.AuthenticationInfo;
import org.keycloak.KeycloakSecurityContext;
import org.osgi.service.component.annotations.Component;

@Component(
    name = "pro.acutus.sling.keycloak.KeycloakAuthenticationHandler",
    property = {
        AuthenticationHandler.PATH_PROPERTY + "=" + "/",
        AuthenticationHandler.TYPE_PROPERTY + "=" + "KEYCLOAK"
    },
    service = AuthenticationHandler.class, immediate = true
)
public class KeycloakAuthenticationHandler implements AuthenticationHandler {

    private static final Logger LOG = Logger.getLogger(KeycloakAuthenticationHandler.class.getName());

    public AuthenticationInfo extractCredentials(HttpServletRequest request, HttpServletResponse response) {

        LOG.fine("KeycloakAuthenticationHandler::extractCredentials");

        KeycloakSecurityContext ctx = (KeycloakSecurityContext) request.getSession().getAttribute("org.keycloak.KeycloakSecurityContext");
        LOG.log(Level.FINE, "KeycloakSecurityContext = {0}", ctx);
        
        if (ctx != null) {
            LOG.log(Level.FINE, "username = {0}", ctx.getToken().getPreferredUsername());
        }

        return new AuthenticationInfo("KEYCLOAK", "admin", "admin".toCharArray());

    }

    public boolean requestCredentials(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOG.fine("KeycloakAuthenticationHandler::requestCredentials");
        return true;
    }

    public void dropCredentials(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOG.fine("KeycloakAuthenticationHandler::dropCredentials");
    }

}
