package at.struct.was9bugs.bug19;

@FunctionalInterface
public interface MyFunctionalInterfaceString {

    String method(String event);

    static String defaultMethod(String event) {
        return event == null ? "" : event;
    }
}
