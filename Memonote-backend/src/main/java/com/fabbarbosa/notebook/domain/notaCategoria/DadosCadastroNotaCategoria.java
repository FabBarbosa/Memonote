package com.fabbarbosa.notebook.domain.notaCategoria;

import com.fabbarbosa.notebook.domain.categoria.Categoria;
import com.fabbarbosa.notebook.domain.nota.Nota;

public record DadosCadastroNotaCategoria (
    Nota id_nota,
    Categoria id_categoria 
) {
    
}
