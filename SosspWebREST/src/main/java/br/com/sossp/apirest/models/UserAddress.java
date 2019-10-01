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
    @SequenceGenerator(name = "userAddress", sequenceName = "SQ_USER_ADDRESS", allocationSize = 1)
    @Column(name = "USER_ADDRESS_ID")
    @GeneratedValue(generator = "userAddress", strategy = GenerationType.SEQUENCE)
    private Long userAddressId;

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "ZIPCODE_ID", referencedColumnName = "ZIPCODE_ID")
    private Address address;

    @Column(name = "NR_ADDRESS")
    private int numberAddress;

    @Column(name = "DS_COMPLEMENT")
    private String addressComplement;

}
