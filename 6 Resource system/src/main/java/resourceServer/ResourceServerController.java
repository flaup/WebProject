package resourceServer;

public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerI resourceServer;

    public ResourceServerController(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }


    @Override
    public String getname() {
        return resourceServer.getResourceName();
    }

    @Override
    public int getage() {
        return resourceServer.getResourceAge();
    }
}
