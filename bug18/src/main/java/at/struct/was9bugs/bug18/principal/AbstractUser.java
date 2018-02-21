package at.struct.was9bugs.bug18.principal;

public abstract class AbstractUser {

    private String username;

    protected AbstractUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
