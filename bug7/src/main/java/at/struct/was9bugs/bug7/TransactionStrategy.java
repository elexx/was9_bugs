package at.struct.was9bugs.bug7;

import org.apache.deltaspike.jpa.impl.transaction.BeanManagedUserTransactionStrategy;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
@Priority(1000)
public class TransactionStrategy extends BeanManagedUserTransactionStrategy {
}
