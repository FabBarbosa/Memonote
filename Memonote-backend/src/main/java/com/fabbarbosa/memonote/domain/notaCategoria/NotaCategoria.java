package com.fabbarbosa.memonote.domain.notaCategoria;

import jakarta.persistence.ManyToOne;

import com.fabbarbosa.memonote.domain.categoria.Categoria;
import com.fabbarbosa.memonote.domain.nota.Nota;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "nota_categoria")
@Entity(name = "nota_categoria")
public class NotaCategoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "id_nota")
    private Nota id_nota;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;
    
    public NotaCategoria(DadosCadastroNotaCategoria dadosCadastroNotaCategoria){
        this.id_nota = dadosCadastroNotaCategoria.id_nota();
        this.id_categoria = dadosCadastroNotaCategoria.id_categoria();
    }

    public void atualizarNotaCategoria(DadosAtualizarNotaCategoria dadosAtualizarNotaCategoria){
        if(dadosAtualizarNotaCategoria.id_nota() != null){
            this.id_nota = dadosAtualizarNotaCategoria.id_nota();
        }
        if(dadosAtualizarNotaCategoria.id_categoria() != null){
            this.id_categoria = dadosAtualizarNotaCategoria.id_categoria();
        }
    }    

}
