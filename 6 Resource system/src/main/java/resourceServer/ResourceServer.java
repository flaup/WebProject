package resourceServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.Resource;
import resources.TestResource;
import sax.ReadXMLFileSAX;
import servlets.ResourceServlet;

public class ResourceServer implements ResourceServerI {
    static final Logger logger = LogManager.getLogger(ResourceServer.class.getName());
    Resource resource;

    @Override
    public void addNewResource(String path) {
        logger.info("Add new resource");
        resource = (TestResource) ReadXMLFileSAX.readXML(path);
    }

    @Override
    public void removeResource() {
        logger.info("Remove resource");
        resource = null;
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    public String getResourceName() {
        logger.info("Resource get name");
        return resource.getName();
    }
    public int getResourceAge() {
        logger.info("Resource get age");
        return resource.getAge();
    }
}
