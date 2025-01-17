package com.fabbarbosa.notebook.domain.topicoNota;

import com.fabbarbosa.notebook.domain.nota.Nota;

public record DadosAtualizarTopicoNota(
    Long id,
    String topico,
    Long paragrafo, 
    Nota id_nota
){
  
}