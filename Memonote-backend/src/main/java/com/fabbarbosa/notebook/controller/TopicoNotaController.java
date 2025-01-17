package com.fabbarbosa.notebook.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabbarbosa.notebook.domain.topicoNota.DadosAtualizarTopicoNota;
import com.fabbarbosa.notebook.domain.topicoNota.DadosCadastrarTopicoNota;
import com.fabbarbosa.notebook.domain.topicoNota.DadosListagemTopicoNota;
import com.fabbarbosa.notebook.domain.topicoNota.TopicoNota;
import com.fabbarbosa.notebook.domain.topicoNota.TopicoNotaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("topicoNota")
public class TopicoNotaController {
    
    @Autowired
    private TopicoNotaRepository repository;

    @PostMapping
    @Transactional
    public void CadastrarTopicoNota(@Valid @RequestBody DadosCadastrarTopicoNota dadosCadastrarTopicoNota){
        repository.save(new TopicoNota(dadosCadastrarTopicoNota));
    }

    @GetMapping
    public List<DadosListagemTopicoNota> ListarTopicoNota(){
        return repository.findAll()
                .stream()
                .map(DadosListagemTopicoNota::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> AtualizarTopicoNota(@PathVariable Long id, @RequestBody DadosAtualizarTopicoNota dadosAtualizarTopicoNota){
        TopicoNota topicoNota = repository.findById(id).orElseThrow(() -> new RuntimeException("Nota not found"));
        topicoNota.atualizarTopicoNota(dadosAtualizarTopicoNota);
        repository.save(topicoNota);
        return ResponseEntity.ok(topicoNota);
    } 

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ExcluirTopicoNota(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}