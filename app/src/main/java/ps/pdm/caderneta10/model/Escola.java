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
@DatabaseTable(tableName = "ESCOLA")
public class Escola implements Serializable, Parcelable {

    private static final long serialVersionUID = 0L;

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @ForeignCollectionField(eager = false)
    private Collection<Turma> turmas = new HashSet<Turma>();

    public Escola() {

    }

    public Escola(Parcel source) {

        this.id = source.readLong();
        this.nome = source.readString();
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(id);
        dest.writeString(nome);
    }

    public static final Creator<Escola> CREATOR = new Creator<Escola>() {

        public Escola createFromParcel(Parcel source) {
            return new Escola(source);
        }


        public Escola[] newArray(int size) {
            return new Escola[size];
        }
    };
}