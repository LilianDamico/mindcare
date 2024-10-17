package com.backend.mindcare.domain.cadastro;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record RequestCadastro(
        UUID id,
        @NotEmpty String name,
        @NotNull String cpf,
        String email,
        String regis,
        String adress,
        String fone,
        String prof,
        String especialidade,
        String password,
        String coments
) {}
