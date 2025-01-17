package com.fabbarbosa.memonote.domain.notaCategoria;

import com.fabbarbosa.memonote.domain.categoria.Categoria;
import com.fabbarbosa.memonote.domain.nota.Nota;

public record DadosListagemNotaCategoria(
    Long id,
    Nota id_nota,
    Categoria id_categoria
) {
    public DadosListagemNotaCategoria(NotaCategoria notaCategoria){
        this(
            notaCategoria.getId(),
            notaCategoria.getId_nota(),
            notaCategoria.getId_categoria()
        );
    }

}