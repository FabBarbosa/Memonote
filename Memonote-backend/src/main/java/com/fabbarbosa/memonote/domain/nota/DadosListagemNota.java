package com.fabbarbosa.memonote.domain.nota;

import com.fabbarbosa.memonote.domain.Enums.Status_nota;

public record DadosListagemNota(
        Long id,
        String titulo,
        String textoNota,
        Status_nota statusNota
) {
    public DadosListagemNota(Nota nota) {
        this(
                nota.getId(),
                nota.getTitulo(),
                nota.getTexto_nota(),
                nota.getStatus_nota()
        );
    }
}
