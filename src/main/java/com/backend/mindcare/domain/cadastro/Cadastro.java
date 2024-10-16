package com.backend.mindcare.domain.cadastro;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "cadastro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    private String cpf;
    private String email;
    private String regis;
    private String adress;
    private String fone;
    private String prof;
    private String especialidade;
    private String password;
    private String coments;

    public Cadastro(RequestCadastro requestCadastro){
        this.name = requestCadastro.name();
        this.cpf = requestCadastro.cpf();
        this.email = requestCadastro.email();
        this.regis = requestCadastro.regis();
        this.adress = requestCadastro.adress();
        this.fone = requestCadastro.fone();
        this.prof = requestCadastro.prof();
        this.especialidade = requestCadastro.especialidade();
        this.password = requestCadastro.password();
        this.coments = requestCadastro.coments();
    }
}
