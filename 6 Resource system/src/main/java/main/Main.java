package main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


import resourceServer.ResourceServer;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import resourceServer.ResourceServerI;
import servlets.ResourceServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        ResourceServerI resourceServer = new ResourceServer();
        ResourceServerControllerMBean serverStatistics = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);

        ResourceServlet resourceServlet = new ResourceServlet(resourceServer);
        context.addServlet(new ServletHolder(resourceServlet), resourceServlet.PAGE_URL);

        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        logger.info("Server started");
        server.join();

    }
}
