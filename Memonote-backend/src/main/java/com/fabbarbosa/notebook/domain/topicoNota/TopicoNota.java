package com.fabbarbosa.notebook.domain.topicoNota;

import com.fabbarbosa.notebook.domain.nota.Nota;
import com.fabbarbosa.notebook.domain.notaCategoria.DadosAtualizarNotaCategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "topico_nota")
@Table(name = "topico_nota")
public class TopicoNota{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String topico;

  private Long paragrafo;

  @ManyToOne
  @JoinColumn(name = "id_nota")
  private Nota id_nota;

  public TopicoNota(DadosCadastrarTopicoNota dadosCadastrarNota){
    this.topico = dadosCadastrarNota.topico();
    this.paragrafo = dadosCadastrarNota.paragrafo();
    this.id_nota = dadosCadastrarNota.id_nota();
  }

  public void atualizarTopicoNota(DadosAtualizarTopicoNota dadosAtualizarTopicoNota){
    if(dadosAtualizarTopicoNota.topico() != null){
        this.topico = dadosAtualizarTopicoNota.topico();
    }
    if(dadosAtualizarTopicoNota.paragrafo() != null){
      this.paragrafo = dadosAtualizarTopicoNota.paragrafo();
    }
    if(dadosAtualizarTopicoNota.id_nota() != null){
      this.id_nota = dadosAtualizarTopicoNota.id_nota();
    }
  }
}