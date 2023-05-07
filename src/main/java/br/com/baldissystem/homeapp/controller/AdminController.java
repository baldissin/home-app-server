package br.com.baldissystem.homeapp.controller;

import br.com.baldissystem.homeapp.model.Admin;
import br.com.baldissystem.homeapp.repository.AdminRepository;
import br.com.baldissystem.homeapp.viewmodels.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.reflect.Parameter;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Admin admin){
        admin.setCreationDate(Instant.now());
        adminRepository.save(admin);
        return ResponseEntity.ok("Saved successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modify(@PathVariable Integer id, @RequestBody Admin admin){
        Optional<Admin> optionalCurrent = adminRepository.findById(id);
        if(optionalCurrent.isPresent()){
            Admin current = optionalCurrent.get();
            current.merge(admin);
            adminRepository.save(current);
            return ResponseEntity.ok("Saved successfully");
        }

        return ResponseEntity.badRequest().body("Person not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        if(adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return ResponseEntity.ok("Saved successfully");
        }

        return ResponseEntity.badRequest().body("Person not found.");
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request){
        Admin admin = adminRepository.findByLogin(request.getLogin());

        if(admin != null){
            if(admin.getPassword().equals(request.getPassword())){
                return ResponseEntity.ok("Auth completed.");
            }
            return ResponseEntity.badRequest().body("Wrong password.");
        }
        return ResponseEntity.badRequest().body("Person not found.");
    }

}
