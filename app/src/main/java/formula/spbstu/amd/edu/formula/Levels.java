package formula.spbstu.amd.edu.formula;

import java.util.ArrayList;

public class Levels {
    private static int[] X;
    private static int[] Y;
    static String[] numbers;

    public static ArrayList<Rectangle> getAnswers(int curLevel, int w, int h, int size) {
        int oneString = 5;

        ArrayList<Rectangle> answers = new ArrayList<>();
        switch (curLevel) {
            case (-1):
                numbers = new String[]{"4"};
                //answers.add(new Rectangle(h, w, (w / 2), (19 * h / 20), "4"));
                break;
            case (0):
                numbers = new String[]{"3", "5"};
                break;
            case (1):
                numbers = new String[]{"9", "12"};
                break;
            case (2):
                numbers = new String[]{"=", "12", "+", "7", "=", "-", "2"};
                break;
            case (3):
                numbers = new String[]{"8", "=", "=", "10", "-", "*", "16"};
                break;
            case (4):
                numbers = new String[]{"17", "+", "4", "-", "=", "+"};
                break;
            case (5):
                numbers = new String[]{"+", "1", "=", "=", "8", "*", "1", "9"};
                break;
            case (6):
                numbers = new String[]{"6", "1", "+", "4", "-", "-", "=", "7"};
                break;
            case (7):
                numbers = new String[]{"11", "=", "2", "5", "4", "*", "2"};
                break;
            case (8):
                numbers = new String[]{"3", "=", "4", "+", "=", "*", "-", "=", "8", "-"};
                break;
            case (9):
                numbers = new String[]{"2", "+", "8", "=", "-", "=", "*", "6", "=", "*"};
                break;
            case (10):
                numbers = new String[]{"6", "=", "14", "+", "=", "2", "=", "8", "+", "10"};
                break;
            case (11):
                numbers = new String[]{"13", "=", "2", "=", "+", "7", "-", "=", "-"};
                break;
            case (12):
                numbers = new String[]{"4", "20", "3", "=", "-", "+", "=", "2", "+"};
                break;
            case (13):
                numbers = new String[]{"+", "=", "9", "+", "+", "*", "2", "=", "=", "10"};
                break;
            case (14):
                numbers = new String[]{"-", "9", "=", "+", "-", "=", "2", "=", "7", "-"};
                break;
            case (15):
                numbers = new String[]{"5", "5", "+", "=", "+", "-", "=", "+", "=", "15"};
                break;
            case (16):
                numbers = new String[]{"=", "=", "2", "*", "+", "+", "8", "=", "15", "="};
                break;
            case (17):
                numbers = new String[]{"16", "2", "=", "-", "9", "*", "7", "=", "-"};
                break;
            case (18):
                numbers = new String[]{"=", "=", "+", "1", "+", "=", "7", "14", "=", "+"};
                break;
            case (19):
                numbers = new String[]{"=", "+", "5", "-", "6", "*", "=", "4"};
                break;
        }
        for (int i = 0; i < numbers.length; i++) {
            int k = i % oneString;
            if (i < oneString)
                answers.add(new Rectangle(h, w, (w / 20) + (k * (3 * size / 2)) + size / 2, (8 * h / 10) + size, numbers[i]));
            else
                answers.add(new Rectangle(h, w, (w / 20) + (k * (3 * size / 2)) + size / 2, (44 * h / 50) + size, numbers[i]));
        }
        return answers;
    }

    public static ArrayList<Rectangle> getCrossWord(int curLevel, int w, int h, int size) {
        ArrayList<Rectangle> crossWord = new ArrayList<>();
        switch (curLevel) {
            case (-1):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), "="));
                break;
            case (0):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "-"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, "2"));
                break;
            case (1):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "5"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "="));
                break;
            case (2):
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 3 * size, "17"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "5"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "9"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, "13"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - 3 * size, (9 * h / 20) + 2 * size, "11"));
                break;
            case (3):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "*"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, "-"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "6"));
                break;
            case (4):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, "20"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "-"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, "16"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, "7"));
                break;
            case (5):
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "18"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, "-"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "6"));
                break;
            case (6):
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, "-"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, "1"));
                break;
            case (7):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "20"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "7"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, "*"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, "2"));
                break;
            case (8):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, "16"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "4"));
                break;
            case (9):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "4"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "16"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, "3"));
                break;
            case (10):
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, "18"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, "="));
                break;
            case (11):
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, "*"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "5"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, "2"));
                break;
            case (12):
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, "5"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "4"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 3 * size, (9 * h / 20) + 3 * size, "8"));
                break;
            case (13):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), "9"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "18"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, "10"));
                break;
            case (14):
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20), "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, "5"));
                break;
            case (15):
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, "12"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, "3"));
                break;
            case (16):
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 3 * size, "7"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "12"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "5"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, "14"));
                break;
            case (17):
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, "10"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, "1"));
                break;
            case (18):
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 3 * size, "8"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, "15"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, "1"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "6"));
                crossWord.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, "+"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, "9"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, "5"));
                break;
            case (19):
                crossWord.add(new Rectangle(h, w, (w / 2) - 3 * size, (9 * h / 20) - 2 * size, "17"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, "12"));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, "="));
                crossWord.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), "3"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), "3"));
                crossWord.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, "2"));
                crossWord.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, "12"));
                crossWord.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, "2"));
                break;

        }

        return crossWord;
    }

    public static ArrayList<Rectangle> getCrossWord_e(int curLevel, int w, int h, int size) {
        ArrayList<Rectangle> crossWord_e = new ArrayList<>();
        switch (curLevel) {
            case (-1):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//4
                break;
            case (0):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//3
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//5
                break;
            case (1):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//9
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, ""));//12
                break;
            case (2):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, ""));//12
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), ""));//7
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, ""));//2
                break;
            case (3):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 3 * size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//10
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, ""));//16
                break;
            case (4):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//17
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//+
                break;
            case (5):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 3 * size, (9 * h / 20) - 2 * size, ""));//1
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, ""));//1
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, ""));//9
                break;
            case (6):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 3 * size, ""));//6
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, ""));//1
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, ""));//7
                break;
            case (7):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, ""));//11
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, ""));//5
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 3 * size, (9 * h / 20) + 2 * size, ""));//2
                break;
            case (8):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 3 * size, ""));//3
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//-
                break;
            case (9):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 3 * size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, ""));//6
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, ""));//*
                break;
            case (10):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 3 * size, ""));//6
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - size, ""));//14
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, ""));//10
                break;
            case (11):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 3 * size, ""));//13
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 3 * size, (9 * h / 20) - 2 * size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//7
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//-
                break;
            case (12):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 3 * size, ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//20
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//3
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 3 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, ""));//+
                break;
            case (13):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, ""));//9
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//10
                break;
            case (14):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//9
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, ""));//7
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 2 * size, ""));//-
                break;
            case (15):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 3 * size, ""));//5
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, ""));//5
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 3 * size, ""));//15
                break;
            case (16):
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, ""));//8
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, ""));//15
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, ""));//=
                break;
            case (17):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - 2 * size, ""));//16
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - size, ""));//2
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) - size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20), ""));//9
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 3 * size, (9 * h / 20) + 2 * size, ""));//7
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) + 2 * size, ""));//-
                break;
            case (18):
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20), ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20), ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//1
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + 2 * size, (9 * h / 20) + size, ""));//7
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + 3 * size, ""));//4
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 3 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + 3 * size, ""));//*
                break;
            case (19):
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) - 2 * size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2), (9 * h / 20) - 2 * size, ""));//+
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - 2 * size, ""));//5
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) - size, ""));//-
                crossWord_e.add(new Rectangle(h, w, (w / 2) - 2 * size, (9 * h / 20) + size, ""));//6
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + size, ""));//*
                crossWord_e.add(new Rectangle(h, w, (w / 2) + size, (9 * h / 20) + size, ""));//=
                crossWord_e.add(new Rectangle(h, w, (w / 2) - size, (9 * h / 20) + 2 * size, ""));//4
                break;
        }

        return crossWord_e;
    }

    public static int[] getPositionForAnswersX(int curLevel, int w, int h, int size) {
        int oneString = 5;
        switch (curLevel) {
            case (-1):
                X = new int[1];
                break;
            case (0):
                X = new int[2];
                break;
            case (1):
                X = new int[2];
                break;
            case (2):
                X = new int[7];
                break;
            case (3):
                X = new int[7];
                break;
            case (4):
                X = new int[6];
                break;
            case (5):
                X = new int[8];
                break;
            case (6):
                X = new int[8];
                break;
            case (7):
                X = new int[7];
                break;
            case (8):
                X = new int[10];
                break;
            case (9):
                X = new int[10];
                break;
            case (10):
                X = new int[10];
                break;
            case (11):
                X = new int[9];
                break;
            case (12):
                X = new int[9];
                break;
            case (13):
                X = new int[10];
                break;
            case (14):
                X = new int[10];
                break;
            case (15):
                X = new int[10];
                break;
            case (16):
                X = new int[10];
                break;
            case (17):
                X = new int[9];
                break;
            case (18):
                X = new int[10];
                break;
            case (19):
                X = new int[8];
                break;
        }
        for (int i = 0; i < X.length; i++) {
            int k = i % oneString;
            X[i] = (w / 20) + (k * (3 * size / 2)) + size / 2;
        }
        return X;
    }

    public static int[] getPositionForAnswersY(int curLevel, int w, int h, int size) {
        int oneString = 5;
        switch (curLevel) {
            case (-1):
                Y = new int[1];
                break;
            case (0):
                Y = new int[2];
                break;
            case (1):
                Y = new int[2];
                break;
            case (2):
                Y = new int[7];
                break;
            case (3):
                Y = new int[7];
                break;
            case (4):
                Y = new int[6];
                break;
            case (5):
                Y = new int[8];
                break;
            case (6):
                Y = new int[8];
                break;
            case (7):
                Y = new int[7];
                break;
            case (8):
                Y = new int[10];
                break;
            case (9):
                Y = new int[10];
                break;
            case (10):
                Y = new int[10];
                break;
            case (11):
                Y = new int[9];
                break;
            case (12):
                Y = new int[9];
                break;
            case (13):
                Y = new int[10];
                break;
            case (14):
                Y = new int[10];
                break;
            case (15):
                Y = new int[10];
                break;
            case (16):
                Y = new int[10];
                break;
            case (17):
                Y = new int[9];
                break;
            case (18):
                Y = new int[10];
                break;
            case (19):
                Y = new int[8];
                break;
        }
        for (int i = 0; i < Y.length; i++) {
            if (i < oneString)
                Y[i] = (8 * h / 10) + size;
            else
                Y[i] = (44 * h / 50) + size;
        }
        return Y;
    }
}
