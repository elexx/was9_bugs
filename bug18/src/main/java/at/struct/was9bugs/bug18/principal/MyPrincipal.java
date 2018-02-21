package at.struct.was9bugs.bug18.principal;

import javax.enterprise.inject.Typed;
import java.io.Serializable;

@Typed()
public class MyPrincipal extends AbstractUser implements Serializable {
    private static final long serialVersionUID = -8815483141689479478L;

    public MyPrincipal() {
        this("xxx");
    }

    public MyPrincipal(String username) {
        super(username);
    }
}
