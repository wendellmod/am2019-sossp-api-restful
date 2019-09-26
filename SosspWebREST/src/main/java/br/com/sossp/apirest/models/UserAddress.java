package br.com.sossp.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "TB_SOS_USER_ADDRESS")
@IdClass(UserAddressPK.class)
public class UserAddress {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ZIPCODE_ID", referencedColumnName = "ZIPCODE_ID")
    private Address address;

    @Column(name = "NR_ADDRESS")
    private int numberAddress;

    @Column(name = "DS_COMPLEMENT")
    private String addressComplement;

}
