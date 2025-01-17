package com.fabbarbosa.memonote.domain.categoria;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo_categoria;

    private String descricao_categoria;

    private Boolean ativo;


    public Categoria(DadosCadastroCategoria dadosCadastroCategoria){
        this.ativo = true;
        this.titulo_categoria = dadosCadastroCategoria.titulo_categoria();
        this.descricao_categoria = dadosCadastroCategoria.descricao_categoria();
    }

    public void atualizarCategoria(DadosAtualizarCategoria dadosAtualizarCategoria){
        if(dadosAtualizarCategoria.titulo_categoria() != null){
            this.titulo_categoria = dadosAtualizarCategoria.titulo_categoria();
        }
        if(dadosAtualizarCategoria.descricao_categoria() != null){
            this.descricao_categoria = dadosAtualizarCategoria.descricao_categoria();
        }

    }

    public void desativarCategoria(){
        this.ativo = false;
    }
}
