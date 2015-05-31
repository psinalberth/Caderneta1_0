package ps.pdm.caderneta10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.util.DatabaseUtils;


public class Principal extends ActionBarActivity implements View.OnClickListener {

    private ImageButton btListarAlunos, btNovoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        DatabaseUtils.getInstance(this).getWritableDatabase();

        btNovoAluno = (ImageButton) findViewById(R.id.btNovoAluno);
        btNovoAluno.setOnClickListener(this);

        btListarAlunos = (ImageButton) findViewById(R.id.btListarAlunos);
        btListarAlunos.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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

        Intent intent = null;

        switch (v.getId()) {

            case R.id.btNovoAluno:
                intent = new Intent(this, CadastrarAlunoActivity.class);
                break;

            case R.id.btListarAlunos:
                intent = new Intent(this, ListarAlunosActivity.class);
                break;
        }

        startActivity(intent);
    }
}
