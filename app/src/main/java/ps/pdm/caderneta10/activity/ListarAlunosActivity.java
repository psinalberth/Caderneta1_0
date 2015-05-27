package ps.pdm.caderneta10.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.adapter.AlunosAdapter;
import ps.pdm.caderneta10.dao.AlunoDAO;
import ps.pdm.caderneta10.util.DatabaseUtils;

public class ListarAlunosActivity extends ActionBarActivity {

    private ListView listView;
    private AlunosAdapter adapter;
    private AlunoDAO alunoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        listView = (ListView) findViewById(android.R.id.list);
        alunoDAO = new AlunoDAO(DatabaseUtils.getInstance(this).getConnectionSource(), this);

        adapter = new AlunosAdapter(this, R.layout.aluno_list_item, alunoDAO.findAll());
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listar_alunos, menu);
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
}
