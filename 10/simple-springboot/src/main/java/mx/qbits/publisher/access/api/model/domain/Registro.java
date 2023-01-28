package mx.qbits.publisher.access.api.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
    
    @ApiModelProperty(example = "Miguel Hidalgo y Costilla")
    @NotBlank(message = "Escribe tu nombre completo")    
    private String nombreCompleto;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "Llénalo, por favor")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "5543562126")
    @Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;
    
    private String linkedin;
    
    @Size(min = 10, max=19, message = "El CURP tiene una estructura inválida")
    private String curp;

    /** /
    @Override
    public String toString() {
        return "PreRegistroRequest ["+ 
                "  id=" + id + 
                ", nick=" + nick + 
                ", correo=" + correo + 
                ", claveHash=" + claveHash + 
                ", telefono=" + telefono + 
                ", fechaNacimiento=" + fechaNacimiento + 
                ", randomString=" + randomString + 
                ", instanteRegistro=" + instanteRegistro + 
                "]";
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((claveHash == null) ? 0 : claveHash.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + id;
        result = prime * result + (int) (instanteRegistro ^ (instanteRegistro >>> 32));
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((randomString == null) ? 0 : randomString.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registro)) return false;
        Registro that = (Registro) o;
        return 
            id == that.id && 
            instanteRegistro == that.instanteRegistro && 
            Objects.equals(nick, that.nick) &&
            Objects.equals(correo, that.correo) && 
            Objects.equals(claveHash, that.claveHash) &&
            Objects.equals(telefono, that.telefono) && 
            Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
            Objects.equals(randomString, that.randomString);
    }

    public int getHash() {
        return this.hashCode();
    }
    /**/
}
