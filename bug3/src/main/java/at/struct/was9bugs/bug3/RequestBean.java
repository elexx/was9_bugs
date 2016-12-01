package at.struct.was9bugs.bug3;

import at.struct.was9bugs.bug3.entities.ParentEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@RequestScoped
@Named
public class RequestBean {

    private @Inject MyService service;
    private @Inject EntityManager em;

    private ParentEntity parentEntity;
    private ParentEntity reloadedParent;

    @PostConstruct
    public void constructParent() {
        service.cleanDB();

        // to emulate multiple requests - clear the em cache
        em.clear();

        // Create a parent with 3 children
        long parentId = service.fillDB(3);

        // to emulate multiple requests - clear the em cache
        em.clear();

        // The the Id of one of the children. This child will be removed.
        ParentEntity parentEntity = service.loadParent(parentId);
        Long childToBeRemovedId = parentEntity.getChildren().get(0).getId();

        // Now remove a child and load the parent within the same transaction. The child will be part of the parent.
        this.parentEntity = service.removeChildrenAndGetParent(childToBeRemovedId, parentId);

        // to emulate multiple requests - clear the em cache
        em.clear();

        // Load the parent in a seperate transaction. The child will NOT be part of it.
        this.reloadedParent = service.loadParent(parentId);
    }

    public ParentEntity getParentEntity() {
        return parentEntity;
    }

    public ParentEntity getReloadedParent() {
        return reloadedParent;
    }
}
