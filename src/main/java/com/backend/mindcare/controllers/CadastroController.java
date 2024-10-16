package com.backend.mindcare.controllers;

import com.backend.mindcare.domain.cadastro.Cadastro;
import com.backend.mindcare.domain.cadastro.CadastroRepository;
import com.backend.mindcare.domain.cadastro.RequestCadastro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mindcare")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @GetMapping
    public ResponseEntity getAllCadastro() {
        var allCadastro = repository.findAll();
        return ResponseEntity.ok(allCadastro);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCadastroById(@PathVariable UUID id) {
        Optional<Cadastro> cadastro = repository.findById(id);
        if (cadastro.isPresent()) {
            return ResponseEntity.ok(cadastro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity registerCadastro(@RequestBody @Valid RequestCadastro data) {
        System.out.println("Dados recebidos do front-end: " + data.toString());
        Cadastro newCadastro = new Cadastro(data);
        repository.save(newCadastro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCadastro(@PathVariable UUID id, @RequestBody @Valid RequestCadastro data) {
        Optional<Cadastro> optionalCadastro = repository.findById(id);
        if (optionalCadastro.isPresent()) {
            Cadastro cadastro = optionalCadastro.get();
            cadastro.setName(data.name());
            cadastro.setCpf(data.cpf());
            cadastro.setEmail(data.email());
            cadastro.setRegis(data.regis());
            cadastro.setAdress(data.adress());
            cadastro.setFone(data.fone());
            cadastro.setProf(data.prof());
            cadastro.setEspecialidade(data.especialidade());
            cadastro.setPassword(data.password());
            cadastro.setComents(data.coments());
            repository.save(cadastro);
            return ResponseEntity.ok(cadastro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCadastro(@PathVariable UUID id) {
        Optional<Cadastro> optionalCadastro = repository.findById(id);
        if (optionalCadastro.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
