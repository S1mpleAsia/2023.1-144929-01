package utils.store;

public class RequestContext {
    private static ApplicationContext context;
    public static ApplicationContext getContext(){
        if(context == null) context = new ApplicationContext();
        return context;
    }
}
