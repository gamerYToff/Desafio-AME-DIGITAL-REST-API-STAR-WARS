package com.br.star.domain.planeta;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlaneta(@NotNull Long id, String nome, String clima, String terreno) {
}
