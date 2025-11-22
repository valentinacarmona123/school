package co.edu.umanizales.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaReporteDTO {
    private LocalDate fecha;
    private int total;
    private List<DetalleEstadoDTO> detalle;
}
