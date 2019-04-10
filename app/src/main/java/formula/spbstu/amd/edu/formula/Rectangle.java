package formula.spbstu.amd.edu.formula;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


public class Rectangle {
    Rect r;
    String text;
    public boolean stand;
    int x, y;
    int size, savePosition;

    Rectangle(int h, int w, int startX, int startY, String str) {
        this.text = str;
        this.size = w / 10;
        this.x = startX - size / 2;
        this.y = startY - size / 2;
        boolean stand = false;
        this.r = new Rect(x, y, x + size, y + size);
        this.savePosition = -1;

    }

    Rectangle(Rectangle rectangle) {
        this.text = rectangle.text;
        this.size = rectangle.size;
        this.x = rectangle.x;
        this.y = rectangle.y;
        boolean stand = rectangle.stand;
        this.r = new Rect(rectangle.r);

    }

    void onDrawRect(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.GRAY);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(r, p);

        Rect rText = new Rect();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize(2 * size / 3);
        p.setTextAlign(Paint.Align.CENTER);
        p.getTextBounds(text, 0, text.length(), rText);
        float h = rText.height();
        float cx = r.centerX();
        float cy = r.centerY();
        canvas.drawText(text, cx, cy + h * 0.5f, p);

        p.setStrokeWidth(5.0f);
        canvas.drawLine(x, y, x, y + size, p);
        canvas.drawLine(x + size, y, x + size, y + size, p);
        canvas.drawLine(x, y, x + size, y, p);
        canvas.drawLine(x, y + size, x + size, y + size, p);
    }

    void onDrawBorder(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(5.0f);
        canvas.drawLine(x, y, x, y + size, p);
        canvas.drawLine(x + size, y, x + size, y + size, p);
        canvas.drawLine(x, y, x + size, y, p);
        canvas.drawLine(x, y + size, x + size, y + size, p);
    }

    void onDrawBorderForNotMoving(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(5.0f);
        canvas.drawLine(x, y, x, y + size, p);
        canvas.drawLine(x + size, y, x + size, y + size, p);
        canvas.drawLine(x, y, x + size, y, p);
        canvas.drawLine(x, y + size, x + size, y + size, p);
    }


    String getText(){
        return text;
    }

    public void setText(String str) {
        this.text = str;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}
