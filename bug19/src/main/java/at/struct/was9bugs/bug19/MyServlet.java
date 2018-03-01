package at.struct.was9bugs.bug19;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 4450293693761251848L;

    private static final Logger logger = Logger.getLogger(MyServlet.class.getName());

    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();
        writer.println("Success!");
        writer.println(message);
        writer.close();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        logger.info("\n===================\n===================\n===================\n===================" +
                    "\n===================\n===================\n===================\n===================");

        // Works every try
        MyFunctionalInterfaceNoParams implNoParams = MyFunctionalInterfaceNoParams::defaultMethod;
        logger.info("MyFunctionalInterfaceNoParams initialized: " + implNoParams.method());

        // Works every try
        MyFunctionalInterfaceString implWithString = MyFunctionalInterfaceString::defaultMethod;
        logger.info("MyFunctionalInterfaceString initialized: " + implWithString.method("event"));

        // Only works first try
        MyFunctionalInterfaceEvent implWithEvent = MyFunctionalInterfaceEvent::defaultMethod;
        logger.info("MyFunctionalInterfaceEvent initialized: " + implWithEvent.method(new MyEvent()));

        message = "Servlet-Initialization finished.";
    }
}
