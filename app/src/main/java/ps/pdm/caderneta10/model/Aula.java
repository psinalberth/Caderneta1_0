package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by inalberth on 23/05/15.
 */

@DatabaseTable(tableName = "AULA")
public class Aula {

    @DatabaseField(id = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String conteudo;

    @DatabaseField(canBeNull = false, dataType = DataType.DATE)
    private Date data;

    @DatabaseField(canBeNull = false, foreign = true)
    private Tuplina tuplina;

    @ForeignCollectionField(eager = false)
    private Collection<Frequencia> frequencias = new HashSet<Frequencia>();

    public Aula() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tuplina getTuplina() {
        return tuplina;
    }

    public void setTuplina(Tuplina tuplina) {
        this.tuplina = tuplina;
    }

    public Collection<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(Collection<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
}
