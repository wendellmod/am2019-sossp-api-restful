package br.com.sossp.apirest.models;

import javax.persistence.*;

@Entity
@Table(name = "TB_SOS_ADDRESS")
@SequenceGenerator(name = "address", sequenceName = "SQ_ADDRESS")
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
    private String state;

    @Column(name = "DS_ZIPCODE")
    private String zipcode;

    // Gets and Sets

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
