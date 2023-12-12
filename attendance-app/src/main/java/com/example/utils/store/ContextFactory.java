package utils.store;

public class ContextFactory {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        if (context == null) context = new ApplicationContext();

        return context;
    }
}
