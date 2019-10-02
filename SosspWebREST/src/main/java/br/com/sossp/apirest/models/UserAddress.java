package br.com.sossp.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_SOS_USER_ADDRESS")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@IdClass(UserAddressPK.class)
//@SequenceGenerator(name = "userAddress", sequenceName = "SQ_USER_ADDRESS", allocationSize = 1)
public class UserAddress {

//    @Id
//    @Column(name = "USER_ADDRESS_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userAddress")
//    private Long id;

    @Id
    @Column(name = "NR_ADDRESS")
    private Integer numberAddress;

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Id
    @ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ZIPCODE_ID", referencedColumnName = "ZIPCODE_ID")
    private Address address;

    @Column(name = "DS_COMPLEMENT")
    private String addressComplement;

}
