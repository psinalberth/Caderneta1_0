package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "ESCOLA")
public class Escola {

    @DatabaseField(id = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @ForeignCollectionField(eager = false)
    private Collection<Turma> turmas = new HashSet<Turma>();

    public Escola() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Collection<Turma> turmas) {
        this.turmas = turmas;
    }
}