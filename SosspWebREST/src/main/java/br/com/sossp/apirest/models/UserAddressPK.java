package br.com.sossp.apirest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@EqualsAndHashCode
public class UserAddressPK implements Serializable {

    private Integer numberAddress;
    private Long user;
    private Long address;

}
