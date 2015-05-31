package ps.pdm.caderneta10.listener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by inalberth on 31/05/15.
 *
 * Implementação dos <code>listeners</code> responsáveis pela interação do usuário com a <code>ListView</code> de <code>Aluno</code>.
 */
public class SwipeListViewListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    private ListView listView;
    private GestureDetector gestureDetector;
    private Context context;

    private static final int MIN_DISTANCE = 50;
    private static final int VELOCITY = 50;

    public SwipeListViewListener() {
        super();
    }

    public SwipeListViewListener(Context context, ListView listView) {

        gestureDetector = new GestureDetector(context, this);
        this.context = context;
        this.listView = listView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    public void onSwipeLeft(int position) {

    }

    public void onSwipeRight(int position) {

    }

    public int getPosition(MotionEvent e) {
        return listView.pointToPosition((int) e.getX(), (int) e.getY());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float deltaX = e2.getX() - e1.getX();
        float deltaY = e2.getY() - e1.getY();

        if (Math.abs(deltaX) > Math.abs(deltaY) && Math.abs(deltaX) > MIN_DISTANCE && Math.abs(velocityX) > VELOCITY) {

            if (deltaX > 0)
                onSwipeRight(getPosition(e1));
             else
                onSwipeLeft(getPosition(e1));

            return true;
        }

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

}
