package com.fabbarbosa.memonote.domain.notaCategoria;

import com.fabbarbosa.memonote.domain.categoria.Categoria;
import com.fabbarbosa.memonote.domain.nota.Nota;

public record DadosCadastroNotaCategoria (
    Nota id_nota,
    Categoria id_categoria 
) {
    
}
