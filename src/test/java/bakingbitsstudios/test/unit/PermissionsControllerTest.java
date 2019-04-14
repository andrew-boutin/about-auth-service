package bakingbitsstudios.test.unit;

import bakingbitsstudios.controller.PermissionsController;
import bakingbitsstudios.domain.Permission;
import bakingbitsstudios.service.PermissionsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PermissionsControllerTest {

    @Mock
    private PermissionsService service;

    @Mock
    private HttpServletRequest request;

    private PermissionsController controller;

    @Before
    public void setUp() {
        controller = new PermissionsController(service);
    }

    // TODO: List permissions.
    // TODO: Get permission not found.

    @Test
    public void getGetPermission() {
        Permission expected = Permission.builder().id("1").name("name").self("/permissions/1").build();
        Permission fromService = Permission.builder().id("1").name("name").build();

        Mockito.when(service.getPermission("1")).thenReturn(fromService);
        Mockito.when(request.getRequestURI()).thenReturn("/permissions/1");

        ResponseEntity<Permission> response = controller.getPermission(request, "1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
        assertEquals("/permissions/1", response.getHeaders().getFirst("Location"));

        Mockito.verify(service, Mockito.times(1)).getPermission("1");
        Mockito.verify(request, Mockito.times(1)).getRequestURI();
        Mockito.verifyNoMoreInteractions(service);
        Mockito.verifyNoMoreInteractions(request);
    }
}
