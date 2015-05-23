package ps.pdm.caderneta10.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by inalberth on 23/05/15.
 */
@DatabaseTable(tableName = "FREQUENCIA")
public class Frequencia {

    @DatabaseField(id = true, foreign = true, uniqueCombo = true)
    private Aluno aluno;

    @DatabaseField(id = true, foreign = true, uniqueCombo = true)
    private Aula aula;

    @DatabaseField(dataType = DataType.INTEGER)
    private Integer falta;

    public Frequencia() {

    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
    }
}
