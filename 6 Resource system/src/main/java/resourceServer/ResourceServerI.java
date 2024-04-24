package resourceServer;

import resources.Resource;

public interface ResourceServerI {
    void addNewResource(String path);
    void removeResource();
    Resource getResource();
    String getResourceName();
    int getResourceAge();

}
