package com.br.star.Service;

import com.br.star.domain.model.Planeta;
import com.br.star.domain.planeta.DadosCadastroPlaneta;
import com.br.star.domain.planeta.DadosPlaneta;
import com.br.star.repository.PlanetaRepository;
import com.br.swapiapi.SwapiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository repository;

    public ResponseEntity savePlanet(DadosCadastroPlaneta dados, UriComponentsBuilder uri){
        Planeta planeta = new Planeta(dados);
        repository.save(planeta);
        new Thread(() -> planeta.setQuantidadeDeAparicoesEmFilmes(SwapiUtil.getPlanetByName(planeta.getNome()))).run();
        return ResponseEntity.created(uri.path("/medicos/{id}").buildAndExpand(planeta.getId()).toUri()).body(new DadosPlaneta(planeta));
    }
}
