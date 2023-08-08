package com.br.star.controller;

import com.br.swapiapi.SwapiUtil;
import com.br.star.Utils;
import com.br.star.domain.planeta.DadosAtualizacaoPlaneta;
import com.br.star.domain.planeta.DadosCadastroPlaneta;
import com.br.star.domain.planeta.DadosPlaneta;
import com.br.star.domain.model.Planeta;
import com.br.star.exception.ValidacaoException;
import com.br.star.repository.PlanetaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarPlaneta(@RequestBody @Valid DadosCadastroPlaneta dados, UriComponentsBuilder uri) throws IOException {
        Planeta planeta = new Planeta(dados);
        if (repository.existsByNome(planeta.getNome()))
            throw new ValidacaoException("Erro, já existe um Planeta com esse nome");
        planeta.setQuantidadeDeAparicoesEmFilmes(SwapiUtil.getPlanetByName(planeta.getNome()));
        repository.save(planeta);
        return ResponseEntity.created(uri.path("/medicos/{id}").buildAndExpand(planeta.getId()).toUri()).body(new DadosPlaneta(planeta));

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPlaneta(@RequestBody @Valid DadosAtualizacaoPlaneta dados) {
        Planeta planeta = repository.getReferenceById(dados.id());
        planeta.atualiza(dados);
        return ResponseEntity.ok(new DadosPlaneta(planeta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPlaneta(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<DadosPlaneta> listarPlanetas(@PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return repository.findAll(pageable).map(dados -> new DadosPlaneta(dados));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity buscarPlanetaPeloNome(@PathVariable String nome) {
        Planeta planeta = repository.findByNome(nome);
        if (Utils.isNull(planeta))
            throw new EntityNotFoundException();
        return ResponseEntity.ok(new DadosPlaneta(planeta));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity buscarPlanetaPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(new DadosPlaneta(repository.getReferenceById(id)));
    }
}
