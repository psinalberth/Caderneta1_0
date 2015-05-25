package ps.pdm.caderneta10.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.dao.EscolaDAO;
import ps.pdm.caderneta10.model.Escola;
import ps.pdm.caderneta10.util.DatabaseUtils;


public class Principal extends ActionBarActivity {

    private EscolaDAO escolaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        DatabaseUtils.getInstance(this).getWritableDatabase();

        escolaDAO = new EscolaDAO(DatabaseUtils.getInstance(this).getConnectionSource(), this);

        Escola escola = new Escola();
        escola.setNome("Colégio Educator");

        escolaDAO.salvar(escola);

        /*Escola e = escolaDAO.findById(Long.valueOf(2));

        Log.i("Escola", e.getNome() + "-" + e.getId());*/

        /*List<Escola> escolas = escolaDAO.findAll();

        for (Escola e: escolas) {

            Log.i("Escola", e.getNome());
        }*/

        Log.i("HELLO", "HELLO WORLD!");
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
}
