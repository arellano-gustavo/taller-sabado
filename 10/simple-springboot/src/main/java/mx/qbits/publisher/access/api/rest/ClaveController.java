package mx.qbits.publisher.access.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.publisher.access.api.model.domain.Response;
import mx.qbits.publisher.access.api.model.exceptions.ControllerException;
import mx.qbits.publisher.access.api.service.SaludaSrv;

@RestController
@RequestMapping
public class ClaveController {
    private SaludaSrv saludaSrv;
    
    public ClaveController(SaludaSrv saludaSrv) {
        this.saludaSrv = saludaSrv;
    }
    
    @GetMapping(
            value = "/saluda/{nombre}",
            produces = "application/json; charset=utf-8")
    public Response reset(@PathVariable("nombre") String nombre) throws ControllerException {
        return saludaSrv.hello(nombre);
    }
    
    @GetMapping(
            value = "/id",
            produces = "application/json; charset=utf-8")
    public String getId() {
        return saludaSrv.getId();
    }
    
}
