package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "TUPLINA")
public class Tuplina implements Serializable {

    private static final long serialVersionUID = 0L;

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Disciplina disciplina;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Turma turma;

    @ForeignCollectionField(eager = false)
    private Collection<Aula> aulas = new HashSet<Aula>();

    public Tuplina() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Collection<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Collection<Aula> aulas) {
        this.aulas = aulas;
    }
}