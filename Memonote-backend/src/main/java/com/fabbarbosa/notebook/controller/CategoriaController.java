package com.fabbarbosa.notebook.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabbarbosa.notebook.domain.categoria.Categoria;
import com.fabbarbosa.notebook.domain.categoria.CategoriaRepository;
import com.fabbarbosa.notebook.domain.categoria.DadosAtualizarCategoria;
import com.fabbarbosa.notebook.domain.categoria.DadosCadastroCategoria;
import com.fabbarbosa.notebook.domain.categoria.DadosListagemCategoria;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@Valid @RequestBody DadosCadastroCategoria dadosCadastroCategoria){
        repository.save(new Categoria(dadosCadastroCategoria));
    }
    
    @GetMapping
    public List<DadosListagemCategoria> ListarCategoria(){
        return repository.findAll()
                .stream()
                .map(DadosListagemCategoria::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody DadosAtualizarCategoria dadosAtualizarCategoria) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new RuntimeException("Nota not found"));
        categoria.atualizarCategoria(dadosAtualizarCategoria);
        repository.save(categoria);
        return ResponseEntity.ok(categoria);

    }

    @DeleteMapping("/{id}")
    @Transactional
        public ResponseEntity ExcluirCategoria(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
