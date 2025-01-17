package com.fabbarbosa.notebook.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabbarbosa.notebook.domain.notaCategoria.DadosAtualizarNotaCategoria;
import com.fabbarbosa.notebook.domain.notaCategoria.DadosCadastroNotaCategoria;
import com.fabbarbosa.notebook.domain.notaCategoria.DadosListagemNotaCategoria;
import com.fabbarbosa.notebook.domain.notaCategoria.NotaCategoriaRepository;
import com.fabbarbosa.notebook.domain.notaCategoria.NotaCategoria;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("notaCategoria")
public class NotaCategoriaController {
    
    @Autowired
    private NotaCategoriaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarNotaCategoria(@Valid @RequestBody DadosCadastroNotaCategoria dadosCadastroNotaCategoria){
        repository.save(new NotaCategoria(dadosCadastroNotaCategoria));
    }

    @GetMapping
    public List<DadosListagemNotaCategoria> ListarNotaCategoria(){
        return repository.findAll()
                .stream()
                .map(DadosListagemNotaCategoria::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarNotaCategoria(@PathVariable Long id, @RequestBody DadosAtualizarNotaCategoria dadosAtualizarNotaCategoria) {
        NotaCategoria notaCategoria = repository.findById(id).orElseThrow(() -> new RuntimeException("NotaCategoria not found"));
        notaCategoria.atualizarNotaCategoria(dadosAtualizarNotaCategoria);
        repository.save(notaCategoria);
        return ResponseEntity.ok(notaCategoria);
    
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ExcluirNotaCategoria(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}