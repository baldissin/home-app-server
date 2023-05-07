package br.com.baldissystem.homeapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Admin {

    @Id
    private Integer id;
    private String login;
    private String password;
    private String name;
    private Instant creationDate;
    private Instant updatedAt;

    public void merge(Admin newAdmin){
        if(StringUtils.hasLength(newAdmin.getLogin())){
            this.setLogin(newAdmin.getLogin());
        }
        if (StringUtils.hasLength(newAdmin.getPassword())){
            this.setPassword(newAdmin.getPassword());
        }
        if(StringUtils.hasLength(newAdmin.getName())){
            this.setName(newAdmin.getName());
        }
        this.setUpdatedAt(Instant.now());
    }

}
