package br.com.sossp.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TB_SOS_ADDRESS")
public class Address {

    @Id
    @Column(name = "ZIPCODE_ID")
    private Long zipcode;

    @Column(name = "DS_ADDRESS")
    private String addressName;

    @Column(name = "DS_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "DS_CITY")
    private String city;

    @Column(name = "DS_STATE")
    @Enumerated(EnumType.STRING)
    private State state;

    // Relationships
    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<UserAddress> userAddresses = new ArrayList<UserAddress>();

}
