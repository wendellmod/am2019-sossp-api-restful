package br.com.sossp.apirest.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TB_SOS_ADDRESS")
@SequenceGenerator(name = "address", sequenceName = "SQ_ADDRESS", allocationSize = 1)
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    private long addressId;

    @Column(name = "DS_ADDRESS")
    private String addressName;

    @Column(name = "DS_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "DS_CITY")
    private String city;

    @Column(name = "DS_STATE")
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "DS_ZIPCODE")
    private String zipcode;

    // Relationships
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<UserAddress> userAddresses = new ArrayList<UserAddress>();

}
