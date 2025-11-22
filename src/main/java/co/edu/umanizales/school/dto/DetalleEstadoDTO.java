package co.edu.umanizales.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleEstadoDTO {
    private String estado;
    private int cantidad;
}
