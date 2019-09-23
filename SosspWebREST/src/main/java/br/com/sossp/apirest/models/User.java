package br.com.sossp.apirest.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_SOS_USER")
@SequenceGenerator(name = "user", sequenceName = "SQ_USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    private long userId;

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

    //Gets and Sets
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }
}
