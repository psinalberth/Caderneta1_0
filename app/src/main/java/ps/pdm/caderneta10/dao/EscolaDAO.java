package ps.pdm.caderneta10.dao;

import android.content.Context;

import com.j256.ormlite.support.ConnectionSource;

import ps.pdm.caderneta10.model.Escola;

/**
 * Created by inalberth on 23/05/15.
 */
public class EscolaDAO extends GenericDAO<Escola> {

    public EscolaDAO(ConnectionSource connectionSource, Context context) {
        super(connectionSource, context);
    }
}
