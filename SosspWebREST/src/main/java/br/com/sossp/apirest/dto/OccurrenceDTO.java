package br.com.sossp.apirest.dto;

import br.com.sossp.apirest.models.Occurrence;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OccurrenceDTO {

    private String typeOccurrence;
    private LocalDate dateOccurrence;
    private LocalDate currentDate;
    private boolean status;
    private String longitude;
    private String latitude;

    public Occurrence buildOccurrence(){

        Occurrence occurrence = new Occurrence();
        occurrence.setTypeOccurrence(typeOccurrence);
        occurrence.setDateOccurrence(dateOccurrence);
        occurrence.setCurrentDate(currentDate);
        occurrence.setStatus(status);
        occurrence.setLongitude(longitude);
        occurrence.setLatitude(latitude);

        return occurrence;
    }


}
