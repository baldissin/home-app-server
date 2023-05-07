package br.com.baldissystem.homeapp.repository;

import br.com.baldissystem.homeapp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

    Admin findByLogin(String login);

}
