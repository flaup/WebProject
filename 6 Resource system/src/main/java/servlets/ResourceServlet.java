package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resourceServer.ResourceServerI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(ResourceServlet.class.getName());
    public static final String PAGE_URL = "/resources";

    public ResourceServerI resourceServer;

    public ResourceServlet(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        resourceServer.addNewResource(path);
        logger.info("Path from request: " + path);
    }
}
