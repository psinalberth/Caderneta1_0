package ps.pdm.caderneta10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ps.pdm.caderneta10.R;
import ps.pdm.caderneta10.model.Aluno;

/**
 * Created by inalberth on 27/05/15.
 *
 * Classe que faz a intermediação entre o <code>modelo de dados</code> de <code>Aluno</code> e a <code>ListView</code>.
 */
public class AlunosAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Context context;

    public AlunosAdapter(Context context, int resource, List<Aluno> alunos) {

        this.context = context;
        this.alunos = alunos;
    }

    public int getCount() {
        return alunos.size();
    }

    public Object getItem(int position) {
        return alunos.get(position);
    }

    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.aluno_list_item, null);

        Aluno aluno = alunos.get(position);

        if (aluno != null) {

            TextView lbNome = (TextView) view.findViewById(R.id.lbNome);
            TextView txtNome = (TextView) view.findViewById(R.id.lbTxtNome);
            TextView lbTurma = (TextView) view.findViewById(R.id.lbTurma);
            TextView txtTurma = (TextView) view.findViewById(R.id.lbTxtTurma);

            if (lbNome != null) {
                lbNome.setText("Nome: ");
            }

            if (txtNome != null) {
                txtNome.setText(aluno.getNome());
            }

            if (lbTurma != null) {
                lbTurma.setText("Turma: ");
            }

            if (txtTurma != null) {
                txtTurma.setText(aluno.getTurma().toString());
            }
        }

        return view;
    }
}
