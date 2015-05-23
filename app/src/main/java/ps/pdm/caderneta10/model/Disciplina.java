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
@DatabaseTable(tableName = "DISCIPLINA")
public class Disciplina {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER)
    private int cargaHoraria;

    @ForeignCollectionField(eager = false)
    private Collection<Tuplina> tuplinas = new HashSet<Tuplina>();

    public Disciplina() {

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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Collection<Tuplina> getTuplinas() {
        return tuplinas;
    }

    public void setTuplinas(Collection<Tuplina> tuplinas) {
        this.tuplinas = tuplinas;
    }
}