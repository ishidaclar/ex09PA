package com.clara.ex09.controller;


import com.clara.ex09.models.ProjetoModel;
import com.clara.ex09.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> projetoModels = projetoService.findAll();
        return ResponseEntity.ok().body(projetoModels);
    }

    @PostMapping
    ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projeto) {
        ProjetoModel requeste = projetoService.criarProjeto(projeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto (@PathVariable Long id){
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> buscarId(@PathVariable Long id) {
        return projetoService.findById(id);
    }
}
