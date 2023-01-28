package mx.qbits.publisher.access.api.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.qbits.publisher.access.api.model.domain.Response;
import mx.qbits.publisher.access.api.model.exceptions.ControllerException;
import mx.qbits.publisher.access.api.utils.Generator;

@Slf4j
@Service
public class SaludaSrvImpl implements SaludaSrv {
    private String uid = Generator.getRandomString(10);

    @Override
    public Response hello(String nombre) throws ControllerException {
        log.info("Mandando respuesta desde el seervicio");
        Response respuesta = new Response();
        respuesta.setUser(nombre);
        respuesta.setPassword(Generator.getRandomString(10));
        return respuesta;
    }
    
    @Override
    public String getId() {
        String result = "{'uid':'"+this.uid+"'}";
        return result.replace('\'', '\"');
    }

}
