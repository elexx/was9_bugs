package at.struct.was9bugs.bug17;

import javax.ejb.Stateless;

@Stateless
public class MyEjb {

    public void doSomething(String msg) {
        System.out.println("EJB working! Msg = " + msg);
    }
}
