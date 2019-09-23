package br.com.sossp.apirest.models;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "TB_SOS_USER_ADDRESS")
@IdClass(UserAddressPK.class)
public class UserAddress {

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;

    @Column(name = "NR_ADDRESS")
    private int numberAddress;

    @Column(name = "DS_COMPLEMENT")
    private String addressComplement;

}
