package pt.ipg.livros

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BaseDadosTest {
    private fun appContext() = InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase? {
        val openHelper = BDLivrosOpenHelper(appContext())
        return openHelper.writableDatabase

    }
    private fun insereCategoria(db: SQLiteDatabase?, categoria: Categoria) {
        categoria.id = TabelaBDCategorias(db).insert(categoria.toContentValues())

        assertNotEquals(-1, categoria.id)
    }

    private fun insereLivro(db: SQLiteDatabase, livro: Livro){
        TabelaDBLivros(db).insert(livro.toContentValues())

        assertNotEquals(-1, livro.id)
    }


    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDLivrosOpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados(){
        val openHelper = BDLivrosOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirCategorias(){
        val db = getWritableDatabase()

        insereCategoria(db, Categoria("Drama"))


        db.close()

    }




    @Test
    fun consegueInserirLivros(){
        val db = getWritableDatabase()

        val categoria = Categoria("Drama")
        insereCategoria(db, categoria)

        val livro = Livro("O Leao que temos ca dentro", "Rachel Bright", categoria.id)

        insereLivro(db,livro)

        db.close()
    }


    @Test
    fun consegueAlterarCategoria(){
        val db = getWritableDatabase()

        val categoria = Categoria("TESTE")
        insereCategoria(db, categoria)


        categoria.nome = "Ficçao Cientifica"
        val registosAlterados = TabelaBDCategorias(db).update(
            categoria.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("$categoria.id")
            )

        assertNotEquals(1, registosAlterados)


        db.close()
    }



}