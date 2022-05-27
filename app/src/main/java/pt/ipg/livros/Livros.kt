package pt.ipg.livros

import android.content.ContentValues

data class Livros(var id: Long, var titulo: String, var autor: String, var cateforiaId: Long) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaDBLivros.CAMPO_TITULO,titulo)
        valores.put(TabelaDBLivros.CAMPO_AUTOR,autor)
        valores.put(TabelaDBLivros.CAMPO_CATEGORIA_ID, cateforiaId)


        return valores
    }

}