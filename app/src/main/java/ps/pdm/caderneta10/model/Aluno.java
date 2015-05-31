package ps.pdm.caderneta10.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "ALUNO")
public class Aluno implements Serializable, Parcelable {

    private static final long serialVersionUID = 0L;

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Turma turma;

    @ForeignCollectionField(eager = false)
    private Collection<Frequencia> frequencias = new HashSet<Frequencia>();

    public Aluno() {

    }

    private Aluno(Parcel source) {

        this.id = source.readLong();
        this.nome = source.readString();
        this.turma = source.readParcelable(Turma.class.getClassLoader());
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


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(this.id);
        dest.writeString(this.nome);
        dest.writeParcelable(turma, flags);
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {

        public Aluno createFromParcel(Parcel source) {
            return new Aluno(source);
        }


        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };
}