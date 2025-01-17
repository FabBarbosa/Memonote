package com.fabbarbosa.memonote.domain.topicoNota;

import com.fabbarbosa.memonote.domain.nota.Nota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopicoNota(

    @NotBlank
    String topico,

    @NotNull
    Long paragrafo,

    @NotNull
    Nota id_nota
) {
  
} 