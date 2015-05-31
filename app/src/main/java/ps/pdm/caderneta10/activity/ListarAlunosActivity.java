package ps.pdm.caderneta10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.Toast;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.adapter.AlunosAdapter;
import ps.pdm.caderneta10.dao.AlunoDAO;
import ps.pdm.caderneta10.listener.SwipeListViewListener;
import ps.pdm.caderneta10.model.Aluno;
import ps.pdm.caderneta10.util.DatabaseUtils;

public class ListarAlunosActivity extends ActionBarActivity {

    private ListView listView;
    private AlunosAdapter adapter;
    private AlunoDAO alunoDAO;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        alunoDAO = new AlunoDAO(DatabaseUtils.getInstance(this).getConnectionSource(), this);

        adapter = new AlunosAdapter(this, R.layout.aluno_list_item, alunoDAO.findAll());

        listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        listView.setOnTouchListener(new SwipeListViewListener(this, listView) {

            public void onSwipeRight(int position) {

                mostrarAnimacaoOnSwipe(position);
            }

            public boolean onDoubleTap(MotionEvent e) {

                mostrarDetalhesAluno(getPosition(e));

                return true;
            }
        });
    }

    /**
     * Envia um aluno selecionado na ListView para a Intent de visualização detalhada/edição.
     *
     * @param position Posição do <code>aluno</code> selecionado na <code>ListView</code>.
     */
    private void mostrarDetalhesAluno(int position) {

        final View child = listView.getChildAt(position - listView.getFirstVisiblePosition());

        if (child != null) {

            Aluno aluno = ((Aluno) adapter.getItem(position));
            Intent intent = new Intent(getBaseContext(), CadastrarAlunoActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("aluno", aluno);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    /**
     * Exibe a animação de transição lateral ao mover um <code>aluno</code> da <code>ListView</code>.
     *
     * @param position Posição do <code>aluno</code> selecionado na <code>ListView</code>.
     * @return Retorna <code>true</code> caso a <code>posição</code> selecionada seja válida ou <code>false</code>
     * caso não seja.
     */
    private boolean mostrarAnimacaoOnSwipe(int position) {

       final View child = listView.getChildAt(position - listView.getFirstVisiblePosition());

        if (child != null) {

            final Aluno aluno = ((Aluno) adapter.getItem(position));

            Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

            animation.setAnimationListener(new Animation.AnimationListener() {

                public void onAnimationStart(Animation animation) {

                }


                public void onAnimationEnd(Animation animation) {

                    alunoDAO.excluir(aluno);
                    adapter.getAlunos().remove(aluno);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ListarAlunosActivity.this, "Aluno removido", Toast.LENGTH_SHORT).show();
                }


                public void onAnimationRepeat(Animation animation) {

                }
            });

            child.startAnimation(animation);

            return true;
        }

        return false;
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
