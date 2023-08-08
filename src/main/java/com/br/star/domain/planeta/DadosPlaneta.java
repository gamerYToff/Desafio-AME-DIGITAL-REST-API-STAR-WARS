package com.br.star.domain.planeta;

import com.br.star.domain.model.Planeta;

public record DadosPlaneta(Long id, String nome, String Clima, String terreno, Integer QuantidadeDeAparicoesEmFilmes) {
    public DadosPlaneta(Planeta dados) {
        this(dados.getId(), dados.getNome(), dados.getClima(), dados.getTerreno(), dados.getQuantidadeDeAparicoesEmFilmes());
    }
}
