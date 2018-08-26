package pro.acutus.sling.keycloak;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.keycloak.adapters.servlet.KeycloakOIDCFilter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(
    immediate = true,
    service = Filter.class,
    property = {
        KeycloakOIDCFilter.CONFIG_FILE_PARAM + "=" + "keycloak.json",
        HttpWhiteboardConstants.HTTP_WHITEBOARD_FILTER_PATTERN + "=" +"/*",
        HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT + "=" + "(osgi.http.whiteboard.context.name=org.apache.sling)"
    }
)
public class KeycloakFilter extends KeycloakOIDCFilter {

    private static final Logger LOG = Logger.getLogger(KeycloakFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        LOG.fine("KeycloakFilter()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
        LOG.fine("KeycloakFilter::doFilter");
    }

}
