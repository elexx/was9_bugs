package at.struct.was9bugs.bug21;

import javax.enterprise.inject.Typed;

@Typed()
public class MyPrincipal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
