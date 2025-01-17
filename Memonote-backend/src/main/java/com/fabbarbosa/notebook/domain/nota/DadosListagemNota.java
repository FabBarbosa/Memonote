package com.fabbarbosa.notebook.domain.nota;

import com.fabbarbosa.notebook.domain.Enums.Status_nota;

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
