package mx.qbits.publisher.access.api.service;

import mx.qbits.publisher.access.api.model.domain.Response;
import mx.qbits.publisher.access.api.model.exceptions.ControllerException;

public interface SaludaSrv {
    Response hello(String nombre)  throws ControllerException;
    String getId();
}
