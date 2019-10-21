package br.com.sossp.apirest.dto;

import br.com.sossp.apirest.models.Occurrence;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class OccurrenceDTO {

    private long occurrenceId;
    private String typeOccurrence;
    private LocalDate dateOccurrence;
    private LocalDate currentDate;
    private boolean status;
    private String longitude;
    private String latitude;

    public OccurrenceDTO(Occurrence occurrence) {
        this.occurrenceId = occurrence.getOccurrenceId();
        this.typeOccurrence = occurrence.getTypeOccurrence();
        this.dateOccurrence = occurrence.getDateOccurrence();
        this.currentDate = occurrence.getCurrentDate();
        this.status = occurrence.isStatus();
        this.longitude = occurrence.getLongitude();
        this.latitude = occurrence.getLatitude();
    }

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
