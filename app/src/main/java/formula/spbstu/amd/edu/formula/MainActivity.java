package formula.spbstu.amd.edu.formula;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;

public class MainActivity extends Activity implements MediaPlayer.OnCompletionListener, View.OnTouchListener {

    public static final int VIEW_INTRO = 0;
    public static final int VIEW_GAME = 1;
    public static final int VIEW_TRANSIT = 2;
    public static final int VIEW_MAIN_MENU = 3;
    public static final int VIEW_MENU = 4;
    public static final int VIEW_INSTRUCTION = 5;
    public static final String PREFS_NAME = "prefs_file";

    SharedPreferences sPref;
    SharedPreferences.Editor editor;

    public static final int ALL_LEVELS = 20;
    public static int currentLevel = 0;

    int m_viewCur = -1;

    AppIntro m_app;
    ViewIntro m_viewIntro;
    ViewGame m_viewGame;
    ViewTransit m_viewTransit;
    ViewMainMenu m_viewMainMenu;
    ViewMenu m_viewMenu;
    ViewInstruction m_viewInstruction;

    // screen dim
    int m_screenW;
    int m_screenH;
    int language;

    public static int levelNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No Status bar
        final Window win = getWindow();
        win.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Application is never sleeps
        win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        m_screenW = point.x;
        m_screenH = point.y;

        Log.d("THREE", "Screen size is " + String.valueOf(m_screenW) + " * " + String.valueOf(m_screenH));

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = prefs.edit();
        levelNumber = prefs.getInt("level", -1);
        //editor.apply();
        if (levelNumber == -1){
            editor.putInt("level", 0);
            levelNumber = 0;
            editor.apply();

        }


        // Detect language
        String strLang = Locale.getDefault().getDisplayLanguage();

        if (strLang.equalsIgnoreCase("english")) {
            Log.d("THREE", "LOCALE: English");
            language = AppIntro.LANGUAGE_ENG;
        } else if (strLang.equalsIgnoreCase("русский")) {
            Log.d("THREE", "LOCALE: Russian");
            language = AppIntro.LANGUAGE_RUS;
        } else {
            Log.d("THREE", "LOCALE unknown: " + strLang);
            language = AppIntro.LANGUAGE_UNKNOWN;
        }
        // Create application
        m_app = new AppIntro(this, language);
        // Create view
        setView(VIEW_INTRO);
    }

    public void setView(int viewID) {
        if (m_viewCur == viewID) {
            Log.d("THREE", "setView: already set");
            return;
        }

        m_viewCur = viewID;
        if (m_viewCur == VIEW_INTRO) {
            m_viewIntro = new ViewIntro(this);
            setContentView(m_viewIntro);
        }
        if (m_viewCur == VIEW_GAME) {
            m_viewGame = new ViewGame(this, m_screenW, m_screenH);
            //Log.d("THREE", "Switch to m_viewGame" );
            setContentView(m_viewGame);
            m_viewGame.start();
        }
        if (m_viewCur == VIEW_TRANSIT) {
            m_viewTransit = new ViewTransit(this, m_screenW, m_screenH);
            //Log.d("THREE", "Switch to m_viewGame" );
            setContentView(m_viewTransit);
            m_viewTransit.start();
        }
        if (m_viewCur == VIEW_MAIN_MENU) {
            m_viewMainMenu = new ViewMainMenu(this, m_screenW, m_screenH);
            //Log.d("THREE", "Switch to m_viewGame" );
            setContentView(m_viewMainMenu);
            m_viewMainMenu.start();
        }
        if (m_viewCur == VIEW_MENU) {
            m_viewMenu = new ViewMenu(this, m_screenW, m_screenH);
            //Log.d("THREE", "Switch to m_viewGame" );
            setContentView(m_viewMenu);
            m_viewMenu.start();
        }
        if (m_viewCur == VIEW_INSTRUCTION) {
            m_viewInstruction = new ViewInstruction(this, m_screenW, m_screenH);
            //Log.d("THREE", "Switch to m_viewGame" );
            setContentView(m_viewInstruction);
            m_viewInstruction.start();
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.

        // delayedHide(100);
    }

    public void onCompletion(MediaPlayer mp) {
        Log.d("THREE", "onCompletion: Video play is completed");
        //switchToGame();
    }


    public boolean onTouch(View v, MotionEvent evt) {
        int x = (int) evt.getX();
        int y = (int) evt.getY();
        int touchType = AppIntro.TOUCH_DOWN;

        //if (evt.getAction() == MotionEvent.ACTION_DOWN)
        //  Log.d("THREE", "Touch pressed (ACTION_DOWN) at (" + String.valueOf(x) + "," + String.valueOf(y) +  ")"  );

        if (evt.getAction() == MotionEvent.ACTION_MOVE)
            touchType = AppIntro.TOUCH_MOVE;
        if (evt.getAction() == MotionEvent.ACTION_UP)
            touchType = AppIntro.TOUCH_UP;

        if (m_viewCur == VIEW_INTRO)
            return m_viewIntro.onTouch(x, y, touchType);
        if (m_viewCur == VIEW_GAME)
            return m_viewGame.onTouch(x, y, touchType);
        if (m_viewCur == VIEW_TRANSIT)
            return m_viewTransit.onTouch(x, y, touchType);
        if (m_viewCur == VIEW_MAIN_MENU)
            return m_viewMainMenu.onTouch(x, y, touchType);
        if (m_viewCur == VIEW_MENU)
            return m_viewMenu.onTouch(x, y, touchType);
        if (m_viewCur == VIEW_INSTRUCTION)
            return m_viewInstruction.onTouch(x, y, touchType);
        return true;

    }

    @Override
    public void onBackPressed() {

        if (m_viewCur == VIEW_MENU || m_viewCur == VIEW_INSTRUCTION){
            setView(VIEW_MAIN_MENU);
            //m_viewCur = VIEW_MAIN_MENU;
        }
        else if(m_viewCur == VIEW_GAME || m_viewCur == VIEW_TRANSIT){
            setView(VIEW_MENU);
            //m_viewCur = VIEW_MAIN_MENU;
        }
        else{
            super.onBackPressed();
        }

    }

    public boolean onKeyDown(int keyCode, KeyEvent evt) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            //Log.d("THREE", "Back key pressed");
            //boolean wantKill = m_app.onKey(Application.KEY_BACK);
            //if (wantKill)
            //		finish();
            //return true;
        }
        boolean ret = super.onKeyDown(keyCode, evt);
        return ret;
    }

    public AppIntro getApp() {
        return m_app;
    }

    protected void onResume() {
        super.onResume();
        if (m_viewCur == VIEW_INTRO)
            m_viewIntro.start();
        if (m_viewCur == VIEW_GAME)
            m_viewGame.start();
        if (m_viewCur == VIEW_TRANSIT)
            m_viewTransit.start();
        if (m_viewCur == VIEW_MAIN_MENU)
            m_viewMainMenu.start();
        if (m_viewCur == VIEW_MENU)
            m_viewMenu.start();
        if (m_viewCur == VIEW_INSTRUCTION)
            m_viewInstruction.start();
        Log.d("THREE", "App onResume");
    }

    protected void onPause() {
        // stop anims
        if (m_viewCur == VIEW_INTRO)
            m_viewIntro.stop();
        if (m_viewCur == VIEW_GAME)
            m_viewGame.onPause();
        if (m_viewCur == VIEW_TRANSIT)
            m_viewTransit.onPause();
        if (m_viewCur == VIEW_MAIN_MENU)
            m_viewMainMenu.onPause();
        if (m_viewCur == VIEW_MENU)
            m_viewMenu.onPause();
        if (m_viewCur == VIEW_INSTRUCTION)
            m_viewInstruction.onPause();

        // complete system
        super.onPause();
        //Log.d("THREE", "App onPause");
    }

    protected void onDestroy() {
        // if (m_viewCur == VIEW_GAME)
        //     m_viewGame.onDestroy();
        super.onDestroy();
        //Log.d("THREE", "App onDestroy");
    }

    public void onConfigurationChanged(Configuration confNew) {
        super.onConfigurationChanged(confNew);
        m_viewIntro.onConfigurationChanged(confNew);
    }


}

