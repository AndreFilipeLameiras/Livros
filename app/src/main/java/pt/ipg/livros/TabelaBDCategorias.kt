package pt.ipg.livros

import android.database.sqlite.SQLiteDatabase

class TabelaBDCategorias(val db: SQLiteDatabase) {
    fun cria(){
        db.execSQL("CREATE TABLE $NOME ()")
    }

    companion object{
        const val NOME = "categorias"
    }
}