package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "TURMA")
public class Turma {

    @DatabaseField(id = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String descricao;

    @DatabaseField(canBeNull = false)
    private String turno;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER)
    private Integer ano;

    @DatabaseField(canBeNull = false, foreign = true)
    private Escola escola;

    @ForeignCollectionField(eager = false)
    private Collection<Aluno> alunos = new HashSet<Aluno>();

    @ForeignCollectionField(eager = false)
    private Collection<Tuplina> tuplinas = new HashSet<Tuplina>();

    public Turma() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Collection<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Collection<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Collection<Tuplina> getTuplinas() {
        return tuplinas;
    }

    public void setTuplinas(Collection<Tuplina> tuplinas) {
        this.tuplinas = tuplinas;
    }
}