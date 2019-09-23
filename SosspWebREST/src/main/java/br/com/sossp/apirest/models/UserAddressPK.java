package br.com.sossp.apirest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode

public class UserAddressPK implements Serializable {

    private long user;

    private long address;

}
