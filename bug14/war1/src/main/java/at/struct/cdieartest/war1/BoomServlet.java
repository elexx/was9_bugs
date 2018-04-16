package at.struct.cdieartest.war1;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/goboom")
public class BoomServlet extends HttpServlet {

    private @Inject War1Extension extension;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> classNames = extension.getClassNames();

        Set<Bean<?>> beans = CDI.current().getBeanManager().getBeans(Object.class);
        for (Bean<?> bean : beans) {
            System.out.println("War1 sees Bean: " + bean.toString());
        }

        for (String className : classNames) {
            try {
                Class.forName(className);
            }
            catch (ClassNotFoundException e) {
                throw new ServletException(e);
            }
        }

        resp.setContentType("text/html");
        resp.getWriter()
                .append("<html>")
                .append("<body>")
                .append("<OK")
                .append("</body")
                .append("</html");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
