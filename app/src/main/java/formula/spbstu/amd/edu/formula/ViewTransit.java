package formula.spbstu.amd.edu.formula;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import static android.graphics.Color.YELLOW;

public class ViewTransit extends View{
    MainActivity m_app;
    private int m_screenW, m_screenH;
    private boolean m_active;
    private RectF m_rectBtnRestart;
    private RectF m_rectBtnNextLevel;
    private RectF m_rectBtnMainMenu;

    public ViewTransit(MainActivity app, int m_screenW, int m_screenH) {
        super(app);
        m_app = app;
        m_active = false;
        setOnTouchListener(m_app);
        this.m_screenW = m_screenW;
        this.m_screenH = m_screenH;
        m_rectBtnRestart = new RectF(m_screenW / 20, 15 * m_screenH/ 20, 6 * m_screenW / 20, 17 * m_screenH / 20);
        m_rectBtnNextLevel = new RectF(7 * m_screenW / 20, 15 * m_screenH/ 20, 13 * m_screenW / 20, 17 * m_screenH / 20);
        m_rectBtnMainMenu = new RectF(14 * m_screenW / 20, 15 * m_screenH/ 20, 19 * m_screenW / 20, 17 * m_screenH / 20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(102, 204, 255);
        Paint p = new Paint();
        p.setStrokeWidth(10.0f);
        p.setColor(Color.BLACK);
        Resources res = m_app.getResources();
        String strPackage = m_app.getPackageName();
        String m_Success = res.getString(res.getIdentifier("success", "string", strPackage));
        String m_Restart = res.getString(res.getIdentifier("restart", "string", strPackage));
        String m_NextLevel = res.getString(res.getIdentifier("next_level", "string", strPackage));
        String m_MainMenu = res.getString(res.getIdentifier("main_menu", "string", strPackage));
        int size = m_screenW / 10;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(m_Success, m_screenW / 2, 2 * m_screenH / 5, p);

        String text = String.valueOf(MainActivity.currentLevel) + "/" + String.valueOf(MainActivity.ALL_LEVELS);
        size = m_screenW / 11;
        p.setTextSize(size);
        canvas.drawText(text, m_screenW / 2,  m_screenH / 2, p);
        //рисуем кнопки
        float rectRad = m_screenW * 0.04f;
        p.setColor(Color.rgb(229, 148, 66));
        canvas.drawRoundRect(m_rectBtnRestart, rectRad, rectRad, p);
        canvas.drawRoundRect(m_rectBtnNextLevel, rectRad, rectRad, p);
        canvas.drawRoundRect(m_rectBtnMainMenu, rectRad, rectRad, p);

        // рисуем текст
        Rect rText = new Rect();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        size = m_screenW / 20;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        p.getTextBounds(m_Restart, 0, m_Restart.length(), rText);
        float h = rText.height();
        float cx = m_rectBtnRestart.centerX();
        float cy = m_rectBtnRestart.centerY();
        canvas.drawText(m_Restart, cx, cy + h * 0.5f, p);


        p.getTextBounds(m_NextLevel, 0, m_NextLevel.length(), rText);
        h = rText.height();
        cx = m_rectBtnNextLevel.centerX();
        cy = m_rectBtnNextLevel.centerY();
        canvas.drawText(m_NextLevel, cx, cy + h * 0.5f, p);

        p.getTextBounds(m_MainMenu, 0, m_MainMenu.length(), rText);
        h = rText.height();
        cx = m_rectBtnMainMenu.centerX();
        cy = m_rectBtnMainMenu.centerY();
        canvas.drawText(m_MainMenu, cx, cy + h * 0.5f, p);

    }
    public boolean onTouch(int x, int y, int touchType) {
        if (touchType != AppIntro.TOUCH_DOWN)
            return false;

        if (m_rectBtnRestart.contains(x, y)) {
            --MainActivity.currentLevel;
            m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtnNextLevel.contains(x, y)) {
            if(MainActivity.currentLevel == MainActivity.ALL_LEVELS)
                m_app.setView(MainActivity.VIEW_MENU);
            else
                m_app.setView(MainActivity.VIEW_GAME);
            return false;
        }
        if (m_rectBtnMainMenu.contains(x, y)) {
            m_app.setView(MainActivity.VIEW_MAIN_MENU);
            return false;
        }
        return true;
    }

    public void start() {
        m_active = true;
    }

    public void onPause() {
        m_active = false;
    }
}
