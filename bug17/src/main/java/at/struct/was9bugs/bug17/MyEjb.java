package at.struct.was9bugs.bug17;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Singleton
@Lock(LockType.READ)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MyEjb {

    public void doSomething() {
        System.out.println("EJB working!");
    }
}
