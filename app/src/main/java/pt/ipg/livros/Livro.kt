package pt.ipg.livros

import android.content.ContentValues

data class Livro(var titulo: String, var autor: String, var cateforiaId: Long, var id: Long = -1) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaDBLivros.CAMPO_TITULO,titulo)
        valores.put(TabelaDBLivros.CAMPO_AUTOR,autor)
        valores.put(TabelaDBLivros.CAMPO_CATEGORIA_ID, cateforiaId)


        return valores
    }

}