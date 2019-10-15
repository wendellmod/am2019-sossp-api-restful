package br.com.sossp.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TB_SOS_OCCURRENCE")
@SequenceGenerator(name = "occurrence", sequenceName = "SQ_OCCURRENCE", allocationSize = 1)
public class Occurrence {

    @Id
    @Column(name = "OCCURRENCE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occurrence")
    private long occurrenceId;

    @Column(name = "DS_TYPE")
    private String typeOccurrence;

    @Column(name = "DT_OCCURRENCE")
    private LocalDate dateOccurrence;

    @Column(name = "DT_CURRENT")
    private LocalDate currentDate;

    @Column(name = "DS_STATUS")
    private boolean status;

    @Column(name = "N_LONGITUDE")
    private String longitude;

    @Column(name = "N_LATITUDE")
    private String latitude;

    // Relationships
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "USER_ID")
    private User user;

}
