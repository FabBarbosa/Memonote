package com.fabbarbosa.notebook.domain.nota;

import com.fabbarbosa.notebook.domain.Enums.Status_nota;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nota")
public class Nota {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String texto_nota;

    @Enumerated(EnumType.STRING)
    private Status_nota status_nota;

    private Boolean ativo;


    public Nota(DadosCadastroNota dadosCadastrarNota){
        this.ativo = true;
        this.titulo = dadosCadastrarNota.titulo();
        this.texto_nota = dadosCadastrarNota.texto_nota();
        this.status_nota = dadosCadastrarNota.status_nota();
    }

    public void atualizarNota(DadosAtualizarNota dadosAtualizarNota){
        if(dadosAtualizarNota.titulo() != null){
            this.titulo = dadosAtualizarNota.titulo();
        }
        if(dadosAtualizarNota.texto_nota() != null){
            this.texto_nota = dadosAtualizarNota.texto_nota();
        }
        if(dadosAtualizarNota.status_nota() != null){
            this.status_nota = dadosAtualizarNota.status_nota();
        }

    }


    public void desativarNota(){
        this.ativo = false;
    }

    

}