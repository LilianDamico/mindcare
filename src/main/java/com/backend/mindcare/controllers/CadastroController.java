package com.backend.mindcare.controllers;

import com.backend.mindcare.domain.cadastro.Cadastro;
import com.backend.mindcare.domain.cadastro.CadastroRepository;
import com.backend.mindcare.domain.cadastro.RequestCadastro;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://mindcare-frontend.vercel.app/")
@RestController
@RequestMapping("/mindcare")
public class CadastroController {

    private final CadastroRepository repository;


    public CadastroController(CadastroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> getAllCadastro() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> getCadastroById(@PathVariable UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> registerCadastro(@RequestBody @Valid RequestCadastro data) {
        System.out.println("Dados recebidos do front-end: " + data.toString());
        Cadastro newCadastro = new Cadastro(data);
        repository.save(newCadastro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> updateCadastro(@PathVariable UUID id, @RequestBody @Valid RequestCadastro data) {
        return repository.findById(id)
                .map(cadastro -> {
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
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadastro(@PathVariable UUID id) {
        return repository.findById(id)
                .map(cadastro -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
