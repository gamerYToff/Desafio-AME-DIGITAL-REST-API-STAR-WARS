package com.br.star.domain.model;

import com.br.star.Utils;
import com.br.star.domain.planeta.DadosAtualizacaoPlaneta;
import com.br.star.domain.planeta.DadosCadastroPlaneta;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planetas")
@NoArgsConstructor
public class Planeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String clima;

    @JoinColumn(name = "quantidade_aparicoes_em_filmes")
    private Integer QuantidadeDeAparicoesEmFilmes;
    private String terreno;

    public Integer getQuantidadeDeAparicoesEmFilmes() {
        return QuantidadeDeAparicoesEmFilmes;
    }

    public void setQuantidadeDeAparicoesEmFilmes(Integer quantidadeDeAparicoesEmFilmes) {
        QuantidadeDeAparicoesEmFilmes = quantidadeDeAparicoesEmFilmes;
    }

    public Planeta(DadosCadastroPlaneta dadosCadastroPlaneta) {
        this.nome = dadosCadastroPlaneta.nome();
        this.clima = dadosCadastroPlaneta.clima();
        this.terreno = dadosCadastroPlaneta.terreno();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getClima() {
        return clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void atualiza(DadosAtualizacaoPlaneta dados) {
        String nome = dados.nome();
        String clima = dados.clima();
        String terreno = dados.terreno();
        this.nome = Utils.isNull(nome) ? this.nome : nome;
        this.clima = Utils.isNull(clima) ? this.clima : clima;
        this.terreno = Utils.isNull(terreno) ? this.terreno : terreno;
    }
}
