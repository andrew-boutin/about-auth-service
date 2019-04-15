package bakingbitsstudios.persistence;

import bakingbitsstudios.domain.Entitlement;
import bakingbitsstudios.exception.EntityType;
import bakingbitsstudios.exception.ExistingEntity;
import bakingbitsstudios.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Component
public class EntitlementDao {

    // For now use an in memory store.
    private Map<String, Entitlement> entitlements;

    public EntitlementDao() {
        entitlements = new HashMap<>();
    }

    public Collection<Entitlement> listEntitlements() {
        return entitlements.values();
    }

    public Entitlement getEntitlement(final String entitlementId) {
        Entitlement e = entitlements.get(entitlementId);

        if (e == null) {
            throw new NotFoundException(entitlementId, EntityType.Entitlement);
        }

        return e;
    }

    public Entitlement createEntitlement(final Entitlement inputEntitlement) {
        String id = generateUUID();

        Entitlement newEntitlement = Entitlement.builder().id(id).name(inputEntitlement.getName()).build();

        enforceNameUniqueness(inputEntitlement.getName());

        entitlements.put(id, newEntitlement);

        return entitlements.get(id);
    }

    public Entitlement updateEntitlement(final String id, final Entitlement inputEntitlement) {
        Entitlement existingEntitlement = entitlements.get(id);

        if (existingEntitlement == null) {
            throw new NotFoundException(id, EntityType.Entitlement);
        }

        enforceNameUniqueness(inputEntitlement.getName());

        Entitlement updatedEntitlement = Entitlement.builder().id(existingEntitlement.getId())
                .name(inputEntitlement.getName()).build();

        entitlements.put(id, updatedEntitlement);

        return entitlements.get(id);
    }

    public void deleteEntitlement(final String id) {
        if(entitlements.remove(id) == null) {
            throw new NotFoundException(id, EntityType.Entitlement);
        }
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    private void enforceNameUniqueness(final String name) {
        entitlements.values().forEach(e -> {
            if (Objects.equals(e.getName(), name)) {
                throw new ExistingEntity(EntityType.Entitlement);
            }
        });
    }
}
