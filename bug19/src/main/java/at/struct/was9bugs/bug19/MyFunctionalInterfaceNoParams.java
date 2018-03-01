package at.struct.was9bugs.bug19;

@FunctionalInterface
public interface MyFunctionalInterfaceNoParams {

    String method();

    static String defaultMethod() {
        return "DefaultValue";
    }
}
