package formula.spbstu.amd.edu.formula;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import static android.graphics.Color.GREEN;

public class ViewInstruction extends View {

    MainActivity m_app;
    private int m_screenW, m_screenH;
    int size;
    private boolean m_active;

    ArrayList<Rectangle> answers, crossWord, crossWord_e;

    boolean border = false;
    int indexEmptySquare;


    private RectF m_rectBtnBack;

    boolean drag = false;
    int Xc = 0;
    int Yc = 0;

    int k = 0;

    int[] X0;
    int[] Y0;

    public ViewInstruction(MainActivity app, int m_screenW, int m_screenH) {
        super(app);
        m_app = app;
        m_active = false;
        setOnTouchListener(m_app);

        this.m_screenW = m_screenW;
        this.m_screenH = m_screenH;
        size = m_screenW / 10;

        X0 = Levels.getPositionForAnswersX(MainActivity.currentLevel, m_screenW, m_screenH, size);
        Y0 = Levels.getPositionForAnswersY(MainActivity.currentLevel, m_screenW, m_screenH, size);

        m_rectBtnBack = new RectF(m_screenW / 20, 3 * m_screenH / 20, 6 * m_screenW / 20, 4 * m_screenH / 20);

    }

    public void start() {
        m_active = true;

        answers = new ArrayList<>(Levels.getAnswers(MainActivity.currentLevel, m_screenW, m_screenH, size));
        crossWord = new ArrayList<>(Levels.getCrossWord(MainActivity.currentLevel, m_screenW, m_screenH, size));
        crossWord_e = new ArrayList<>(Levels.getCrossWord_e(MainActivity.currentLevel, m_screenW, m_screenH, size));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(102, 204, 255);
        for (int i = 0; i < crossWord.size(); i++)
            crossWord.get(i).onDrawRect(canvas);
        for (int i = 0; i < crossWord_e.size(); i++)
            crossWord_e.get(i).onDrawRect(canvas);
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).onDrawRect(canvas);
        }
        if (border)
            crossWord_e.get(indexEmptySquare).onDrawBorder(canvas);

        Paint p = new Paint();
        p.setStrokeWidth(10.0f);
        p.setColor(Color.BLACK);
        canvas.drawLine(0, 8 * m_screenH / 10, m_screenW, 8 * m_screenH / 10, p);

        float rectRad = m_screenW * 0.04f;
        p.setColor(Color.rgb(229, 148, 66));
        canvas.drawRoundRect(m_rectBtnBack, rectRad, rectRad, p);

        Resources res = m_app.getResources();
        String strPackage = m_app.getPackageName();
        String m_Back = res.getString(res.getIdentifier("back", "string", strPackage));
        String m_Name = res.getString(res.getIdentifier("main_menu_name", "string", strPackage));
        String m_Instr1 = res.getString(res.getIdentifier("instruction_part1", "string", strPackage));
        String m_Instr2 = res.getString(res.getIdentifier("instruction_part2", "string", strPackage));
        String m_Instr3 = res.getString(res.getIdentifier("instruction_part3", "string", strPackage));

        p.setColor(Color.BLACK);
        // рисуем текст
        int size = m_screenW / 10;
        p.setTextSize(size);
        canvas.drawText(m_Name, 5 * m_screenW / 20, 2 * m_screenH / 20, p);

        size = m_screenW / 22;
        p.setTextSize(size);
        canvas.drawText(m_Instr1, m_screenW / 25, 5 * m_screenH / 20, p);
        canvas.drawText(m_Instr2, m_screenW / 25, 6 * m_screenH / 20, p);
        canvas.drawText(m_Instr3, m_screenW / 25, 7 * m_screenH / 20, p);
        if(m_app.language == AppIntro.LANGUAGE_RUS){
            String rus = "знак должны составлять верное равенство.";
            canvas.drawText(rus, m_screenW / 25, 8 * m_screenH / 20, p);
        }

        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        size = m_screenW / 14;
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        Rect rText = new Rect();
        p.getTextBounds(m_Back, 0, m_Back.length(), rText);
        float h = rText.height();
        float cx = m_rectBtnBack.centerX();
        float cy = m_rectBtnBack.centerY();
        canvas.drawText(m_Back, cx, cy + h * 0.5f, p);


    }

    public boolean onTouch(int x, int y, int touchType) {
        int evX = x;
        int evY = y;
        if (touchType == AppIntro.TOUCH_DOWN) {
            if (m_rectBtnBack.contains(x, y)) {
                m_app.setView(MainActivity.VIEW_MAIN_MENU);
                return false;
            }
        }
        switch (touchType) {
            // касание началось
            case MotionEvent.ACTION_DOWN:
                // если касание было начато в пределах квадрата
                //Log.i("ACTION", "DOWN");
                //номер квадрата, в который ткнули
                for (int i = 0; i < answers.size(); i++) {
                    // проверяем в какой квадрат(пустой) ткнули
                    if (crossWord_e.get(i).r.contains(evX, evY)) {
                        //запоминаем куда вставлять ответ
                        Xc = evX;
                        Yc = evY;
                        if (!crossWord_e.get(i).stand) {
                            border = true;
                            indexEmptySquare = i;
                        }
                    }
                    //если в ответ ткнули(перетащить)
                    drag = answers.get(i).r.contains(evX, evY);
                    if (drag) {
                        k = i;
                        break;
                    }
                }
                invalidate();
                break;
            // тащим
            case MotionEvent.ACTION_MOVE:
                // если режим перетаскивания включен
                //Log.i("ACTION", "MOVE");
                if (drag) {
                    for (int i = 0; i < crossWord_e.size(); i++) {
                        if (crossWord_e.get(i).r.contains(Xc, Yc) && !(crossWord_e.get(i).stand)) {
                            answers.get(k).r.left = crossWord_e.get(i).r.left;
                            answers.get(k).r.top = crossWord_e.get(i).r.top;
                            answers.get(k).r.right = crossWord_e.get(i).r.right;
                            answers.get(k).r.bottom = crossWord_e.get(i).r.bottom;
                            answers.get(k).x = crossWord_e.get(i).x;
                            answers.get(k).y = crossWord_e.get(i).y;
                            answers.get(k).stand = true;
                            crossWord_e.get(i).stand = true;
                            drag = false;
                            border = false;

                            break;
                        }
                    }
                    invalidate();

                    int sum = 0;
                    for (int i = 0; i < crossWord_e.size(); i++) {
                        if (answers.get(i).r.contains(crossWord_e.get(i).r) && answers.get(i).stand == true)
                            sum++;
                    }
                    if (crossWord_e.size() == sum) {
                        ++MainActivity.currentLevel;
                        m_app.setView(MainActivity.VIEW_MAIN_MENU);
                        return false;
                    }

                    //клик для возвращения ответа
                }
                break;
            // касание завершено
            case MotionEvent.ACTION_UP:
                //Log.i("ACTION", "UP");
                // выключаем режим перетаскивания
                drag = false;
                break;
        }
        invalidate();
        return true;
    }

    public void onPause() {
        m_active = false;
    }

}

