package bakingbitsstudios.service;

import bakingbitsstudios.domain.Entitlement;
import bakingbitsstudios.persistence.EntitlementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EntitlementService {

    private EntitlementDao entitlementDao;

    @Autowired
    public EntitlementService(EntitlementDao entitlementDao) {
        this.entitlementDao = entitlementDao;
    }

    public Collection<Entitlement> listEntitlements() {
        return entitlementDao.listEntitlements();
    }

    public Entitlement getEntitlement(final String entitlementId) {
        return entitlementDao.getEntitlement(entitlementId);
    }

    public Entitlement createEntitlement(final Entitlement e) {
        return entitlementDao.createEntitlement(e);
    }

    public Entitlement updateEntitlement(final String id, final Entitlement e) {
        return entitlementDao.updateEntitlement(id, e);
    }

    public void deleteEntitlement(final String id) {
        entitlementDao.deleteEntitlement(id);
    }
}
