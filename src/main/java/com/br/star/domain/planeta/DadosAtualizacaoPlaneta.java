package com.br.star.domain.planeta;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlaneta(@NotNull Long id, @NotEmpty String nome, String clima, String terreno) {
}
