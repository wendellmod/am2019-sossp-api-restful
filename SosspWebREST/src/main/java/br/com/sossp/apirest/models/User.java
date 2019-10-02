package br.com.sossp.apirest.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "TB_SOS_USER")
@SequenceGenerator(name = "user", sequenceName = "SQ_USER", allocationSize = 1)
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_TAG")
    private String tag;

    @Column(name = "DT_BIRTH")
    private LocalDate dateOfbirth;

    @Column(name = "DS_GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "DS_CPF")
    private String cpf;

    @Column(name = "DS_TEL")
    private String tel;

    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "DS_PASS")
    private String password;

    @Column(name = "DS_IMG")
    @Lob
    private String imgAvatar;

    // Relationships
    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddresses;

    @OneToMany(mappedBy = "user")
    private List<Occurrence> occurrences;

}
