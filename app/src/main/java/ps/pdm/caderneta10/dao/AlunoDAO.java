package ps.pdm.caderneta10.dao;

import android.content.Context;

import com.j256.ormlite.support.ConnectionSource;

import ps.pdm.caderneta10.model.Aluno;

/**
 * Created by inalberth on 23/05/15.
 */
public class AlunoDAO extends GenericDAO<Aluno> {

    public AlunoDAO(ConnectionSource connectionSource, Context context) {

        super(connectionSource, context);
    }
}
