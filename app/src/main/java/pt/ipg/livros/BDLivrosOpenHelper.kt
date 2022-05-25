package pt.ipg.livros

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDLivrosOpenHelper(
    context: Context?
) : SQLiteOpenHelper(context, NOME, null, VERSAO) {


    override fun onCreate(db: SQLiteDatabase?) {
        requireNotNull(db)

        TabelaBDCategorias(db).cria()
        TabelaDBLivros(db).cria()


    }

    override fun onUpgrade(db: SQLiteDatabase? , p1: Int, p2: Int) {

    }


    companion object{
        private const val NOME = "livros.db"
        private const val VERSAO = 1
    }


}