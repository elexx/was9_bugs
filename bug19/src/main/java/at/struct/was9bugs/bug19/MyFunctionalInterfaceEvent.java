package at.struct.was9bugs.bug19;

@FunctionalInterface
public interface MyFunctionalInterfaceEvent {

    String method(MyEvent event);

    static String defaultMethod(MyEvent event) {
        return event == null ? "" : event.toString();
    }
}
