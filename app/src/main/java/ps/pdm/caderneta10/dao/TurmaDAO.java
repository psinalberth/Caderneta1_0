package ps.pdm.caderneta10.dao;

import android.content.Context;

import com.j256.ormlite.support.ConnectionSource;

import ps.pdm.caderneta10.model.Turma;

/**
 * Created by inalberth on 27/05/15.
 */
public class TurmaDAO extends GenericDAO<Turma> {
    /**
     * Construtor da classe
     *
     * @param connectionSource Canal de comunicação (database) a ser utilizado.
     * @param context          Contexto da aplicação ao qual será aplicado.
     */
    public TurmaDAO(ConnectionSource connectionSource, Context context) {
        super(connectionSource, context);
    }
}
