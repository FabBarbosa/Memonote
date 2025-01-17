package com.fabbarbosa.memonote.domain.topicoNota;

import com.fabbarbosa.memonote.domain.nota.Nota;

public record DadosAtualizarTopicoNota(
    Long id,
    String topico,
    Long paragrafo, 
    Nota id_nota
){
  
}