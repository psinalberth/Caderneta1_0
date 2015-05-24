package ps.pdm.caderneta10.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.sql.SQLException;

import ps.pdm.caderneta10.model.Aluno;
import ps.pdm.caderneta10.model.Aula;
import ps.pdm.caderneta10.model.Disciplina;
import ps.pdm.caderneta10.model.Escola;
import ps.pdm.caderneta10.model.Frequencia;
import ps.pdm.caderneta10.model.Tuplina;
import ps.pdm.caderneta10.model.Turma;

/**
 * Created by inalberth on 23/05/15.
 */
public class DatabaseUtils extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "CadernetaDB.db";
    private static final int DATABASE_VERSION = 1;

    protected static DatabaseUtils databaseUtils;

    Class<?> classes[] = {Escola.class, Turma.class, Aluno.class, Disciplina.class, Aula.class, Frequencia.class, Tuplina.class};

    public static DatabaseUtils getInstance(Context context) {

        if (databaseUtils == null) {

            databaseUtils = new DatabaseUtils(context);
        }

        return databaseUtils;
    }

    public DatabaseUtils(Context context) {
        super(context, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath() + File.separator +  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        Log.i(DatabaseUtils.class.getSimpleName(), "Criando database " + DATABASE_NAME);

        try {

            for (Class<?> classe : classes) {

                Log.d(DatabaseUtils.class.getSimpleName(), "Tabela " + classe.getSimpleName());
                TableUtils.createTable(connectionSource, classe);
                Log.d(DatabaseUtils.class.getSimpleName(), "Tabela " + classe.getSimpleName()  + " criada");
            }

        } catch (SQLException e) {

            Log.e("Error", "Erro ao criar tabela.", e);
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {

            TableUtils.dropTable(connectionSource, getClass(), false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
