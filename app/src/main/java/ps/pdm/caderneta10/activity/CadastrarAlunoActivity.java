package ps.pdm.caderneta10.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.dao.AlunoDAO;
import ps.pdm.caderneta10.dao.TurmaDAO;
import ps.pdm.caderneta10.model.Aluno;
import ps.pdm.caderneta10.model.Turma;
import ps.pdm.caderneta10.util.DatabaseUtils;

public class CadastrarAlunoActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText txtNome;
    private Spinner cbTurma;

    private Button btSalvar, btCancelar;

    private AlunoDAO alunoDAO;
    private Aluno aluno;

    private TextView lbTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_aluno);

        txtNome = (EditText) findViewById(R.id.txtNome);
        cbTurma = (Spinner) findViewById(R.id.cbTurma);

        btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(this);

        btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);

        lbTitulo = (TextView) findViewById(R.id.lbTitulo);

        ArrayAdapter turmaAdapter = new ArrayAdapter(this, R.layout.caderneta_spinner_item,
                new TurmaDAO(DatabaseUtils.getInstance(this).getConnectionSource(), this).findAll());

        cbTurma.setAdapter(turmaAdapter);

        alunoDAO = new AlunoDAO(DatabaseUtils.getInstance(this).getConnectionSource(), this);

        if (isEditando()) {

            aluno = getIntent().getExtras().getParcelable("aluno");

            lbTitulo.setText("Editar Aluno");
            txtNome.setText(aluno.getNome(), TextView.BufferType.EDITABLE);
            cbTurma.setSelection(Integer.parseInt(aluno.getTurma().getId().toString())-1);
        }
    }

    /**
     * Verifica se a <code>Activity</code> está sendo utilizada para salvar um novo <code>Aluno</code> ou editar um existente.
     *
     * @return Retorna <code>true</code> a <code>Activity</code> esteja sendo utilizada para editar um <code>Aluno</code>
     * ou <code>false</code> caso seja para criar um novo registro.
     */
    private boolean isEditando() {

        if (getIntent().getExtras() != null) {

            return true;

        } else {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastrar_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btSalvar: {

                String nome = txtNome.getText().toString();
                Turma turma = (Turma) cbTurma.getSelectedItem();

                if (!isEditando()) {

                    aluno = new Aluno();
                }

                aluno.setNome(nome);
                aluno.setTurma(turma);

                alunoDAO.salvar(aluno);

                finish();

                break;
            }

            case R.id.btCancelar: {

                aluno = null;
                finish();

                break;
            }
        }
    }
}
