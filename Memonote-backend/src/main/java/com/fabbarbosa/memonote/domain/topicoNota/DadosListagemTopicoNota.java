package com.fabbarbosa.memonote.domain.topicoNota;

import com.fabbarbosa.memonote.domain.nota.Nota;

public record DadosListagemTopicoNota(
    Long id,
    String topico,
    Long paragrafo,
    Nota id_nota
){

    public DadosListagemTopicoNota(TopicoNota topicoNota){
        this(
            topicoNota.getId(),
            topicoNota.getTopico(),
            topicoNota.getParagrafo(),
            topicoNota.getId_nota()
        );
    }

}