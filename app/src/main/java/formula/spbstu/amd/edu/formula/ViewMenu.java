package formula.spbstu.amd.edu.formula;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;

import static android.graphics.Color.GREEN;

public class ViewMenu extends View {


    MainActivity m_app;
    private int m_screenW, m_screenH;
    int size;
    private boolean m_active;

    private RectF m_rectBtnBack;
   /* private RectF m_rectBtn1;
    private RectF m_rectBtn2;
    private RectF m_rectBtn3;
    private RectF m_rectBtn4;
    private RectF m_rectBtn5;
    private RectF m_rectBtn6;
    private RectF m_rectBtn7;
    private RectF m_rectBtn8;
    private RectF m_rectBtn9;
    private RectF m_rectBtn10;
    private RectF m_rectBtn11;
    private RectF m_rectBtn12;
    private RectF m_rectBtn13;
    private RectF m_rectBtn14;
    private RectF m_rectBtn15;
    private RectF m_rectBtn16;
    private RectF m_rectBtn17;
    private RectF m_rectBtn18;
    private RectF m_rectBtn19;
    private RectF m_rectBtn20;*/

    int lvl[];
    private ArrayList<RectF> buttons;


    public ViewMenu(MainActivity app, int m_screenW, int m_screenH) {
        super(app);
        m_app = app;
        m_active = false;
        setOnTouchListener(m_app);
        buttons = new ArrayList<>();
        lvl = new int[MainActivity.ALL_LEVELS];
        for (int i = 0; i < lvl.length; i++) {
            lvl[i] = i + 1;
        }

        this.m_screenW = m_screenW;
        this.m_screenH = m_screenH;


        buttons.add(new RectF(3 * m_screenW / 20, 6 * m_screenH / 20, 5 * m_screenW / 20, 7 * m_screenH / 20));
        buttons.add(new RectF(6 * m_screenW / 20, 6 * m_screenH / 20, 8 * m_screenW / 20, 7 * m_screenH / 20));
        buttons.add(new RectF(9 * m_screenW / 20, 6 * m_screenH / 20, 11 * m_screenW / 20, 7 * m_screenH / 20));
        buttons.add(new RectF(12 * m_screenW / 20, 6 * m_screenH / 20, 14 * m_screenW / 20, 7 * m_screenH / 20));
        buttons.add(new RectF(15 * m_screenW / 20, 6 * m_screenH / 20, 17 * m_screenW / 20, 7 * m_screenH / 20));
        buttons.add(new RectF(3 * m_screenW / 20, 8 * m_screenH / 20, 5 * m_screenW / 20, 9 * m_screenH / 20));
        buttons.add(new RectF(6 * m_screenW / 20, 8 * m_screenH / 20, 8 * m_screenW / 20, 9 * m_screenH / 20));
        buttons.add(new RectF(9 * m_screenW / 20, 8 * m_screenH / 20, 11 * m_screenW / 20, 9 * m_screenH / 20));
        buttons.add(new RectF(12 * m_screenW / 20, 8 * m_screenH / 20, 14 * m_screenW / 20, 9 * m_screenH / 20));
        buttons.add(new RectF(15 * m_screenW / 20, 8 * m_screenH / 20, 17 * m_screenW / 20, 9 * m_screenH / 20));
        buttons.add(new RectF(3 * m_screenW / 20, 10 * m_screenH / 20, 5 * m_screenW / 20, 11 * m_screenH / 20));
        buttons.add(new RectF(6 * m_screenW / 20, 10 * m_screenH / 20, 8 * m_screenW / 20, 11 * m_screenH / 20));
        buttons.add(new RectF(9 * m_screenW / 20, 10 * m_screenH / 20, 11 * m_screenW / 20, 11 * m_screenH / 20));
        buttons.add(new RectF(12 * m_screenW / 20, 10 * m_screenH / 20, 14 * m_screenW / 20, 11 * m_screenH / 20));
        buttons.add(new RectF(15 * m_screenW / 20, 10 * m_screenH / 20, 17 * m_screenW / 20, 11 * m_screenH / 20));
        buttons.add(new RectF(3 * m_screenW / 20, 12 * m_screenH / 20, 5 * m_screenW / 20, 13 * m_screenH / 20));
        buttons.add(new RectF(6 * m_screenW / 20, 12 * m_screenH / 20, 8 * m_screenW / 20, 13 * m_screenH / 20));
        buttons.add(new RectF(9 * m_screenW / 20, 12 * m_screenH / 20, 11 * m_screenW / 20, 13 * m_screenH / 20));
        buttons.add(new RectF(12 * m_screenW / 20, 12 * m_screenH / 20, 14 * m_screenW / 20, 13 * m_screenH / 20));
        buttons.add(new RectF(15 * m_screenW / 20, 12 * m_screenH / 20, 17 * m_screenW / 20, 13 * m_screenH / 20));

        m_rectBtnBack = new RectF(m_screenW / 20, m_screenH / 20, 6 * m_screenW / 20, 2 * m_screenH / 20);
    }

    public void start() {
        m_active = true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(102, 204, 255);
        Paint p = new Paint();

        //рисуем кнопки
        float rectRad = m_screenW * 0.04f;


        for (int i = 0; i < buttons.size(); i++){
            if (i <= MainActivity.levelNumber)
                p.setColor(Color.rgb(229, 148, 66));
            else
                p.setColor(Color.GRAY);
            canvas.drawRoundRect(buttons.get(i), rectRad, rectRad, p);
        }


        p.setColor(Color.rgb(229, 148, 66));
        canvas.drawRoundRect(m_rectBtnBack, rectRad, rectRad, p);

        Resources res = m_app.getResources();
        String strPackage = m_app.getPackageName();
        String m_Back = res.getString(res.getIdentifier("back", "string", strPackage));
        String m_Choose = res.getString(res.getIdentifier("choose_level", "string", strPackage));


        p.setColor(Color.BLACK);
        // рисуем текст
        Rect rText = new Rect();

        int size = m_screenW / 12;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(m_Choose, m_screenW / 2, m_screenH / 4, p);


        String text;
        float h, cx, cy;

        p.setStyle(Paint.Style.FILL);
        p.setTextAlign(Paint.Align.CENTER);
        size = m_screenW / 14;
        for(int i = 0; i < buttons.size(); i++) {
            text = String.valueOf(lvl[i]);
            p.getTextBounds(text, 0, text.length(), rText);
            h = rText.height();
            p.setTextSize(size);
            cx = buttons.get(i).centerX();
            cy = buttons.get(i).centerY();
            canvas.drawText(text, cx, cy + h * 0.5f, p);
        }

        size = m_screenW / 14;
        p.setTextSize(size);
        p.getTextBounds(m_Back, 0, m_Back.length(), rText);
        h = rText.height();
        cx = m_rectBtnBack.centerX();
        cy = m_rectBtnBack.centerY();
        canvas.drawText(m_Back, cx, cy + h * 0.5f, p);
    }

    public boolean onTouch(int x, int y, int touchType) {

        if (touchType != AppIntro.TOUCH_DOWN)
            return false;

        for (int i = 0; i < buttons.size(); i++){
            if(buttons.get(i).contains(x,y) && i <= MainActivity.levelNumber){
                MainActivity.currentLevel = i;
                m_app.setView(MainActivity.VIEW_GAME);
                return false;
            }
        }

        /*if (m_rectBtn1.contains(x, y)) {
            MainActivity.currentLevel = 0;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn2.contains(x, y)) {
            MainActivity.currentLevel = 1;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn3.contains(x, y)) {
            MainActivity.currentLevel = 2;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn4.contains(x, y)) {
            MainActivity.currentLevel = 3;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn5.contains(x, y)) {
            MainActivity.currentLevel = 4;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn6.contains(x, y)) {
            MainActivity.currentLevel = 5;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn7.contains(x, y)) {
            MainActivity.currentLevel = 6;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn8.contains(x, y)) {
            MainActivity.currentLevel = 7;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn9.contains(x, y)) {
            MainActivity.currentLevel = 8;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn10.contains(x, y)) {
            MainActivity.currentLevel = 9;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn11.contains(x, y)) {
            MainActivity.currentLevel = 10;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn12.contains(x, y)) {
            MainActivity.currentLevel = 11;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn13.contains(x, y)) {
            MainActivity.currentLevel = 12;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn14.contains(x, y)) {
            MainActivity.currentLevel = 13;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn15.contains(x, y)) {
            MainActivity.currentLevel = 14;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn16.contains(x, y)) {
            MainActivity.currentLevel = 15;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }

        if (m_rectBtn17.contains(x, y)) {
            MainActivity.currentLevel = 16;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn18.contains(x, y)) {
            MainActivity.currentLevel = 17;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn19.contains(x, y)) {
            MainActivity.currentLevel = 18;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtn20.contains(x, y)) {
            MainActivity.currentLevel = 19;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }*/

        if (m_rectBtnBack.contains(x, y)) {
            m_app.setView(MainActivity.VIEW_MAIN_MENU);
            return false;
        }
        return true;
    }

    public void onPause() {
        m_active = false;
    }

}

