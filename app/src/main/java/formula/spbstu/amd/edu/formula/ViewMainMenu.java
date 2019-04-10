package formula.spbstu.amd.edu.formula;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import static android.graphics.Color.GREEN;

public class ViewMainMenu extends View {

    MainActivity m_app;
    private int m_screenW, m_screenH;
    int size;
    private boolean m_active;
    private RectF m_rectBtnPlay;
    private RectF m_rectBtnInstruction;


    public ViewMainMenu(MainActivity app, int m_screenW, int m_screenH) {
        super(app);
        m_app = app;
        m_active = false;
        setOnTouchListener(m_app);

        this.m_screenW = m_screenW;
        this.m_screenH = m_screenH;

        m_rectBtnPlay = new RectF(7 * m_screenW / 20, 10 * m_screenH / 20, 13 * m_screenW / 20, 12 * m_screenH / 20);
        m_rectBtnInstruction = new RectF(7 * m_screenW / 20, 13 * m_screenH / 20, 13 * m_screenW / 20, 15 * m_screenH / 20);

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
        p.setColor(Color.rgb(229, 148, 66));
        //p.setARGB(1,42,167,43);
        canvas.drawRoundRect(m_rectBtnPlay, rectRad, rectRad, p);
        canvas.drawRoundRect(m_rectBtnInstruction, rectRad, rectRad, p);

        //достаем текст из ресурсов
        Resources res = m_app.getResources();
        String strPackage = m_app.getPackageName();
        String m_mainMenuName = res.getString(res.getIdentifier("main_menu_name", "string", strPackage));
        String m_mainMenuPlay = res.getString(res.getIdentifier("main_menu_play", "string", strPackage));
        String m_mainMenuRules = res.getString(res.getIdentifier("main_menu_rules", "string", strPackage));


        p.setColor(Color.BLACK);
        // рисуем текст
        Rect rText = new Rect();
        int size = m_screenW / 10;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(m_mainMenuName, m_screenW / 2, m_screenH / 4, p);


        p.setStyle(Paint.Style.FILL);
        size = m_screenW / 14;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        p.getTextBounds(m_mainMenuPlay, 0, m_mainMenuPlay.length(), rText);
        float h = rText.height();
        float cx = m_rectBtnPlay.centerX();
        float cy = m_rectBtnPlay.centerY();
        canvas.drawText(m_mainMenuPlay, cx, cy + h * 0.5f, p);

        p.getTextBounds(m_mainMenuRules, 0, m_mainMenuRules.length(), rText);
        h = rText.height();
        cx = m_rectBtnInstruction.centerX();
        cy = m_rectBtnInstruction.centerY();
        canvas.drawText(m_mainMenuRules, cx, cy + h * 0.5f, p);
    }

    public boolean onTouch(int x, int y, int touchType) {

        if (touchType != AppIntro.TOUCH_DOWN)
            return false;

        if (m_rectBtnPlay.contains(x, y)) {
            m_app.setView(MainActivity.VIEW_MENU);
            return false;
        }
        if (m_rectBtnInstruction.contains(x, y)) {
            MainActivity.currentLevel = -1;
            m_app.setView(MainActivity.VIEW_INSTRUCTION);
            return false;
        }
        return true;
    }

    public void onPause() {
        m_active = false;
    }

}

