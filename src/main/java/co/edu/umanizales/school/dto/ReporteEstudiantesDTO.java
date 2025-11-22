package co.edu.umanizales.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteEstudiantesDTO {
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private List<DiaReporteDTO> dias;
}
