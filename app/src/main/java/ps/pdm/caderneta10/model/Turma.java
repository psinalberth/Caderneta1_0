package ps.pdm.caderneta10.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "TURMA")
public class Turma implements Serializable, Parcelable {

    private static final long serialVersionUID = 0L;

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String descricao;

    @DatabaseField(canBeNull = false)
    private String turno;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER)
    private int ano;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Escola escola;

    @ForeignCollectionField(eager = false)
    private Collection<Aluno> alunos = new HashSet<Aluno>();

    @ForeignCollectionField(eager = false)
    private Collection<Tuplina> tuplinas = new HashSet<Tuplina>();

    public Turma() {

    }

    public Turma(Parcel source) {

        this.id = source.readLong();
        this.descricao = source.readString();
        this.turno = source.readString();
        this.ano = source.readInt();
        this.escola = source.readParcelable(Escola.class.getClassLoader());
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
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

    public String toString() {
        return this.descricao + " " + this.turno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(id);
        dest.writeString(descricao);
        dest.writeString(turno);
        dest.writeInt(ano);
        dest.writeParcelable(escola, flags);
    }

    public static final Creator<Turma> CREATOR = new Creator<Turma>() {
        @Override
        public Turma createFromParcel(Parcel source) {
            return new Turma(source);
        }

        @Override
        public Turma[] newArray(int size) {
            return new Turma[size];
        }
    };
}