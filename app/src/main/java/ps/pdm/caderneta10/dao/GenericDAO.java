package ps.pdm.caderneta10.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by inalberth on 23/05/15.
 *
 * Classe genérica que implementa os métodos CRUD do projeto.
 */
public class GenericDAO<T> {

    private Dao<T, Long> dao;

    /**
     * Construtor da classe
     *
     * @param connectionSource Canal de comunicação (database) a ser utilizado.
     * @param context Contexto da aplicação ao qual será aplicado.
     */
    public GenericDAO(ConnectionSource connectionSource, Context context) {

        try {

            dao = DaoManager.createDao(connectionSource,
                    (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Persiste um novo objeto na database.
     *
     * @param type Objeto a ser persistido.
     */
    public void salvar(T type) {

        try {

            dao.createOrUpdate(type);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um objeto na database passando como argumento o identificador primário.
     *
     * @param id Identificador primário do objeto a ser buscado.
     * @return Retorna o <code>objeto</code> caso encontre o <code>id</code> ou <code>null</code> caso não exista
     * na database o <code>id</code> procurado.
     */
    public T findById(Long id) {

        try {

            return dao.queryForId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Obtém todos os objetos armazenados em uma coleção na database.
     *
     * @return Coleção de objetos armazenados em uma coleção na database.
     */
    public List<T> findAll() {

        try {

            return dao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Modifica um objeto presente na database.
     *
     * @param type Objeto a ser modificado.
     */
    public void alterar(T type) {

        try {

            dao.update(type);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove um objeto da database.
     *
     * @param type Objeto a ser removido.
     */
    public void excluir(T type) {

        try {

            dao.delete(type);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
