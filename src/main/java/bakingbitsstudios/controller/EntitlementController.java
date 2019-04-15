package bakingbitsstudios.controller;

import bakingbitsstudios.domain.Entitlement;
import bakingbitsstudios.service.EntitlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Collection;

// TODO: Requires `isSystemAdmin`.
@RestController
@RequestMapping("/entitlements")
public class EntitlementController {

    private EntitlementService entitlementService;

    @Autowired
    public EntitlementController(EntitlementService entitlementService) {
        this.entitlementService = entitlementService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<Entitlement>> getEntitlements(HttpServletRequest httpServletRequest) {
        Collection<Entitlement> existingEntitlements = entitlementService.listEntitlements();

        String self = httpServletRequest.getRequestURI();

        existingEntitlements.forEach(p -> p.setSelf(self + "/" + p.getId()));

        return ResponseEntity.ok().body(existingEntitlements);
    }

    // TODO: No input id. Here and spec.
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Entitlement> createEntitlement(HttpServletRequest httpServletRequest,
                                                         @NotNull @Valid @RequestBody Entitlement bodyEntitlement) {
        Entitlement createdEntitlement = entitlementService.createEntitlement(bodyEntitlement);

        String self = httpServletRequest.getRequestURI() + "/" + createdEntitlement.getId();

        createdEntitlement.setSelf(self);

        return ResponseEntity.created(URI.create(self)).body(createdEntitlement);
    }

    @GetMapping(value = "{entitlementId}", produces = "application/json")
    public ResponseEntity<Entitlement> getEntitlement(HttpServletRequest httpServletRequest,
                                                      @NotBlank @PathVariable("entitlementId") String entitlementId) {
        Entitlement existingEntitlement = entitlementService.getEntitlement(entitlementId);

        String self = httpServletRequest.getRequestURI();

        existingEntitlement.setSelf(self);

        return ResponseEntity.ok().header(HttpHeaders.LOCATION, self).body(existingEntitlement);
    }

    // TODO: Can't change input id. Here and spec.
    @PutMapping(value = "{entitlementId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Entitlement> updateEntitlement(HttpServletRequest httpServletRequest,
                                                         @NotBlank @PathVariable("entitlementId") String entitlementId,
                                                         @NotNull @Valid @RequestBody Entitlement bodyEntitlement) {
        Entitlement updatedEntitlement = entitlementService.updateEntitlement(entitlementId, bodyEntitlement);

        String self = httpServletRequest.getRequestURI() + "/" + updatedEntitlement.getId();

        updatedEntitlement.setSelf(self);

        return ResponseEntity.ok().header(HttpHeaders.LOCATION, self).body(updatedEntitlement);
    }

    @DeleteMapping(value = "{entitlementId}")
    public ResponseEntity deleteEntitlement(@NotBlank @PathVariable("entitlementId") String entitlementId) {
        entitlementService.deleteEntitlement(entitlementId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
