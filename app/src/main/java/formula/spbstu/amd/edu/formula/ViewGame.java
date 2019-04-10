package formula.spbstu.amd.edu.formula;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.graphics.Color.WHITE;

public class ViewGame extends View {

    MainActivity m_app;
    private int m_screenW, m_screenH;
    ArrayList<Rectangle> answers, crossWord, crossWord_e;
    int size;

    //для запоминания позиции ответа после нажатия на пустое и для запоминания индекса для убирания
    int k = 0;

    private RectF m_rectBtnBack;

    //для отрисовки
    boolean border = false;
    int indexEmptySquare;

    // переменные для перетаскивания
    boolean drag = false;
    int Xc = 0;
    int Yc = 0;

    private boolean m_active;

    int[] X;
    int[] Y;

    public ViewGame(MainActivity app, int m_screenW, int m_screenH) {
        super(app);
        m_app = app;
        setOnTouchListener(m_app);
        m_active = false;
        this.m_screenW = m_screenW;
        this.m_screenH = m_screenH;
        size = m_screenW / 10;

        //позиции где хранятся ответы
        X = Levels.getPositionForAnswersX(MainActivity.currentLevel, m_screenW, m_screenH, size);
        Y = Levels.getPositionForAnswersY(MainActivity.currentLevel, m_screenW, m_screenH, size);

        m_rectBtnBack = new RectF(m_screenW / 20, m_screenH / 20, 6 * m_screenW / 20, 2 * m_screenH / 20);
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
        canvas.drawRGB(102, 204, 255); //backround
        for (int i = 0; i < crossWord.size(); i++) {
            crossWord.get(i).onDrawRect(canvas);
            //crossWord.get(i).onDrawBorderForNotMoving(canvas);
        }
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

        Resources res = m_app.getResources();
        String strPackage = m_app.getPackageName();
        String m_Back = res.getString(res.getIdentifier("back", "string", strPackage));


        float rectRad = m_screenW * 0.04f;
        p.setColor(Color.rgb(229, 148, 66));
        canvas.drawRoundRect(m_rectBtnBack, rectRad, rectRad, p);

        Rect rText = new Rect();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        int sizeText = m_screenW / 14;
        p.setTextSize(sizeText);
        p.setTextAlign(Paint.Align.CENTER);
        p.getTextBounds(m_Back, 0, m_Back.length(), rText);
        float h = rText.height();
        float cx = m_rectBtnBack.centerX();
        float cy = m_rectBtnBack.centerY();
        canvas.drawText(m_Back, cx, cy + h * 0.5f, p);

        //вывод уровня
        String level = (MainActivity.currentLevel + 1) + "/" + MainActivity.ALL_LEVELS;
        p.getTextBounds(level, 0, level.length(), rText);
        canvas.drawText(level, 18 * m_screenW / 20, 2 * m_screenH / 22, p);

    }

    //@Override
    public boolean onTouch(int x, int y, int touchType) {
        // координаты Touch-события
        int evX = x;
        int evY = y;
        if (touchType == AppIntro.TOUCH_DOWN) {
            if (m_rectBtnBack.contains(x, y)) {
                m_app.setView(MainActivity.VIEW_MENU);
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
                        if (answers.get(i).stand) {
                            drag = false;
                        }
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
                        if (crossWord_e.get(i).r.contains(Xc, Yc) && !(crossWord_e.get(i).stand) && border) {
                            answers.get(k).r.left = crossWord_e.get(i).r.left;
                            answers.get(k).r.top = crossWord_e.get(i).r.top;
                            answers.get(k).r.right = crossWord_e.get(i).r.right;
                            answers.get(k).r.bottom = crossWord_e.get(i).r.bottom;
                            answers.get(k).x = crossWord_e.get(i).x;
                            answers.get(k).y = crossWord_e.get(i).y;
                            answers.get(k).stand = true;
                            answers.get(k).savePosition = i;
                            crossWord_e.get(i).stand = true;//здесь был баг
                            drag = false;
                            border = false;
                            break;
                        }
                    }
                    invalidate();
                    //проверка на правильность
                    boolean check = true;
                    for (int i = 0; i < answers.size(); i++) {
                        check = check & answers.get(i).stand;
                    }
                    //if (sum == answers.size()) {
                    if (check)
                        if (checkResults()) {
                            if(MainActivity.currentLevel==MainActivity.levelNumber)
                                ++MainActivity.levelNumber;
                            ++MainActivity.currentLevel;

                            m_app.editor.putInt("level", MainActivity.currentLevel);
                            m_app.editor.apply();
                            m_app.setView(MainActivity.VIEW_TRANSIT);
                            return false;
                        }
                    // перерисовываем экран
                    //invalidate();
                    //клик для возвращения ответа
                } else if (answers.get(k).stand && answers.get(k).r.contains(evX, evY)) {
                    answers.get(k).r.left = X[k] - size / 2;
                    answers.get(k).r.top = Y[k] - size / 2;
                    answers.get(k).r.right = X[k] + size / 2;
                    answers.get(k).r.bottom = Y[k] + size / 2;
                    answers.get(k).x = X[k] - size / 2;
                    answers.get(k).y = Y[k] - size / 2;
                    answers.get(k).stand = false;
                    crossWord_e.get(answers.get(k).savePosition).stand = false;
                    border = false;
                    invalidate();
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


    private void showMessage(@StringRes int string) {
        Toast.makeText(m_app, string, Toast.LENGTH_SHORT).show();
    }

    public void onPause() {
        m_active = false;
    }

    public boolean checkResults() {
        boolean result = true;
        Rectangle tmp = null;
        for (int j = 0; j < crossWord_e.size(); j++) {
            for (int i = 0; i < answers.size(); i++) {
                if ((crossWord_e.get(j).r.contains(answers.get(i).r) && answers.get(i).stand)) {
                    tmp = new Rectangle(crossWord_e.get(j));
                    tmp.setText(answers.get(i).getText());
                    int xTmp = tmp.getX();
                    int yTmp = tmp.getY();
                    StringBuilder vertical = new StringBuilder();
                    StringBuilder horizontal = new StringBuilder();
                    for (int n = -4; n <= 4; n++) {
                        if (n == 0) {
                            horizontal.append(tmp.getText());
                            vertical.append(tmp.getText());
                            continue;
                        }
                        for (int m = 0; m < crossWord.size(); m++) {
                            if (crossWord.get(m).r.contains(xTmp + n * size, yTmp)) {
                                horizontal.append(crossWord.get(m).getText());
                            } else if ((crossWord.get(m).r.contains(xTmp, yTmp + n * size))) {
                                vertical.append(crossWord.get(m).getText());
                            }
                        }
                        for (int l = 0; l < crossWord_e.size(); l++) {
                            if (crossWord_e.get(l).r.contains(xTmp + n * size, yTmp)) {
                                for (int t = 0; t < answers.size(); t++) {
                                    if ((crossWord_e.get(l).r.contains(answers.get(t).r) && answers.get(t).stand))
                                        horizontal.append(answers.get(t).getText());
                                }
                            } else if (crossWord_e.get(l).r.contains(xTmp, yTmp + n * size)) {
                                for (int t = 0; t < answers.size(); t++) {
                                    if ((crossWord_e.get(l).r.contains(answers.get(t).r) && answers.get(t).stand))
                                        vertical.append(answers.get(t).getText());
                                }
                            }
                        }
                    }
                    String horizontalStr = horizontal.toString();
                    String verticalStr = vertical.toString();
                    if (horizontalStr.length() > 4) {
                        char sign = 0;
                        int indexEqual = 0, indexSign = 0;
                        indexEqual = horizontalStr.indexOf("=");
                        indexSign = horizontalStr.indexOf("+");
                        if (indexSign == -1)
                            indexSign = horizontalStr.indexOf("-");
                        if (indexSign == -1)
                            indexSign = horizontalStr.indexOf("*");
                        sign = horizontalStr.charAt(indexSign);
                        if (indexEqual < indexSign){
                            horizontalStr = reverseStr(horizontalStr);
                            indexEqual = horizontalStr.indexOf("=");
                            indexSign = horizontalStr.indexOf(sign);
                        }
                        String firstNumber = horizontalStr.substring(0, indexSign);
                        String secondNumber = horizontalStr.substring(indexSign + 1, indexEqual);
                        String thirdNumber = horizontalStr.substring(indexEqual + 1);
                        switch (sign) {
                            case ('+'):
                                if (!(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber))) {
                                    result = false;
                                }
                                break;
                            case ('-'):
                                if (!(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber))) {
                                    result = false;
                                }
                                break;
                            case ('*'):
                                if (!(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber))) {
                                    result = false;
                                }
                                break;
                        }
                    }
                    if (verticalStr.length() > 4) {
                        char sign = 0;
                        int indexEqual = 0, indexSign = 0;
                        indexEqual = verticalStr.indexOf("=");
                        indexSign = verticalStr.indexOf("+");
                        if (indexSign == -1)
                            indexSign = verticalStr.indexOf("-");
                        if (indexSign == -1)
                            indexSign = verticalStr.indexOf("*");
                        sign = verticalStr.charAt(indexSign);
                        if (indexEqual < indexSign) {
                            verticalStr = reverseStr(verticalStr);
                            indexSign = verticalStr.indexOf(sign);
                            indexEqual = verticalStr.indexOf("=");
                        }

                        String firstNumber = verticalStr.substring(0, indexSign);
                        String secondNumber = verticalStr.substring(indexSign + 1, indexEqual);
                        String thirdNumber = verticalStr.substring(indexEqual + 1);
                        switch (sign) {
                            case ('+'):
                                if (!(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber)))
                                    result = false;
                                break;
                            case ('-'):
                                if (!(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber)))
                                    result = false;
                                break;
                            case ('*'):
                                if (!(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber) == Integer.parseInt(thirdNumber)))
                                    result = false;
                                break;
                        }
                    }
                    break;
                }

            }

        }

        return result;
    }

    String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();

        char sign = 0;
        int indexEqual = 0, indexSign = 0;
        indexEqual = str.indexOf("=");
        indexSign = str.indexOf("+");
        if (indexSign == -1)
            indexSign = str.indexOf("-");
        if (indexSign == -1)
            indexSign = str.indexOf("*");
        sign = str.charAt(indexSign);
        String firstNumber = str.substring(0, indexEqual);
        String secondNumber = str.substring(indexEqual + 1, indexSign);
        String thirdNumber = str.substring(indexSign + 1);

        sb.append(secondNumber);
        sb.append(sign);
        sb.append(thirdNumber);
        sb.append("=");
        sb.append(firstNumber);

        return sb.toString();
    }

}
