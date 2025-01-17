package com.fabbarbosa.notebook.controller;

import com.fabbarbosa.notebook.domain.nota.DadosAtualizarNota;
import com.fabbarbosa.notebook.domain.nota.DadosCadastroNota;
import com.fabbarbosa.notebook.domain.nota.DadosListagemNota;
import com.fabbarbosa.notebook.domain.nota.Nota;
import com.fabbarbosa.notebook.domain.nota.NotaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("nota")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarNota(@Valid @RequestBody DadosCadastroNota dadosCadastroNota){
        repository.save(new Nota(dadosCadastroNota));
    }

    @GetMapping
    public List<DadosListagemNota> ListarNota(){
        return repository.findAll()
                .stream()
                .map(DadosListagemNota::new)
                .collect(Collectors.toList());

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarNota(@PathVariable Long id, @RequestBody DadosAtualizarNota dadosAtualizarNota) {
        Nota nota = repository.findById(id).orElseThrow(() -> new RuntimeException("Nota not found"));
        nota.atualizarNota(dadosAtualizarNota);
        repository.save(nota);
        return ResponseEntity.ok(nota);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ExcluirNota(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
} 