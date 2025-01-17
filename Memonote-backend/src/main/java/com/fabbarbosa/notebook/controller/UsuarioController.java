package com.fabbarbosa.notebook.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fabbarbosa.notebook.domain.usuario.UsuarioRepository;
import com.fabbarbosa.notebook.domain.topicoNota.DadosListagemTopicoNota;
import com.fabbarbosa.notebook.domain.usuario.DadosCadastroUsuario;
import com.fabbarbosa.notebook.domain.usuario.DadosListagemUsuario;
import com.fabbarbosa.notebook.domain.usuario.Usuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    
    @PostMapping
    @Transactional
    public void CadastrarUsuario(@Valid @RequestBody DadosCadastroUsuario dadosCadastrarUsuario){
        repository.save(new Usuario(dadosCadastrarUsuario));
    }

    @GetMapping
    @Transactional
    public List<DadosListagemUsuario> listarUsuario(){
        return repository.findAll()
                .stream()
                .map(DadosListagemUsuario::new)
                .collect(Collectors.toList());
    }
}
