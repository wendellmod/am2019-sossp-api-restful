package br.com.sossp.apirest.dto;

import br.com.sossp.apirest.models.Genre;
import br.com.sossp.apirest.models.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO {

    private String name;
    private String lastName;
    private String tag;
    private LocalDate dateOfbirth;
    private Genre genre;
    private String cpf;
    private String tel;
    private String email;
    private String password;
    private String imgAvatar;
    private List<AddressDTO> addresses;

    public User buildUser(){

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setTag(tag);
        user.setDateOfbirth(dateOfbirth);
        user.setGenre(genre);
        user.setCpf(cpf);
        user.setTel(tel);
        user.setEmail(email);
        user.setPassword(password);
        user.setImgAvatar(imgAvatar);

        return  user;
    }

}
