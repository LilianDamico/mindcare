package com.backend.mindcare.domain.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface CadastroRepository extends JpaRepository<Cadastro, UUID> {

    @Override
    @NonNull
    Cadastro getReferenceById(@NonNull UUID id);
}
