package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "ALUNO")
public class Aluno {

    @DatabaseField(id = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false, foreign = true)
    private Turma turma;

    @ForeignCollectionField(eager = false)
    private Collection<Frequencia> frequencias = new HashSet<Frequencia>();

    public Aluno() {

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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Collection<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(Collection<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
}
