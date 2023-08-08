package com.br.star.domain.planeta;

import jakarta.validation.constraints.NotEmpty;

public record DadosCadastroPlaneta(@NotEmpty String nome, String clima, String terreno) {
    public DadosCadastroPlaneta {
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }
}
