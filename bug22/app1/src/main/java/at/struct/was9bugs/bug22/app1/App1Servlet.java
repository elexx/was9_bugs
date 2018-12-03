package at.struct.was9bugs.bug22.app1;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.security.Security;
import java.util.Enumeration;
import java.util.logging.Logger;

public class App1Servlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(App1Servlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);


        PrintWriter writer = resp.getWriter();
        writer.println("Success!");

        printInfo(writer);

        writer.close();
    }

    @Override
    public void init() throws ServletException {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            logger.info("Starting Installing BC Provider...");
            Security.addProvider(new BouncyCastleProvider());
            logger.info("Done Installing BC Provider...");
        }
    }

    private void printInfo(PrintWriter pw) {
        pw.println(BouncyCastleProvider.class.getClassLoader().toString());

        String bcName = BouncyCastleProvider.class.getName().replace(".", "/") + ".class";
        try {
            pw.println("BC Classloader:");
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(bcName);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                pw.println("\t" + url.toExternalForm());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
