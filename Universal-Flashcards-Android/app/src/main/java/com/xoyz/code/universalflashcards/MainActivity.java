package com.xoyz.code.universalflashcards;

import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.material.tabs.TabLayout;
import com.muddzdev.styleabletoast.StyleableToast;
import com.xoyz.code.universalflashcards.R;

public class MainActivity extends AppCompatActivity {

    private Point size = new Point();

    public MainActivity() throws NoSuchAlgorithmException {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText_user_email = (EditText) findViewById(R.id.editText_main_user_email);
        final EditText editText_user_password = (EditText) findViewById(R.id.editText_main_user_password);
        final Button btn_register = (Button) findViewById(R.id.button_main_register);
        final Button btn_login = (Button) findViewById(R.id.button_main_login);

        final LinearLayout LL_register = (LinearLayout) findViewById(R.id.linearlayout_register);
        final LinearLayout LL_login = (LinearLayout) findViewById(R.id.linearlayout_login);

        final TextView textView_to_login = (TextView) findViewById(R.id.textView_switch_to_login);
        final TextView textView_to_register = (TextView) findViewById(R.id.textView_switch_to_register);

//        LL_login.setVisibility(View.GONE);

        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(size);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, "Feature currently not implemented", "snackbar");
                // System.out.println(String.valueOf(login(editText_user_email.getText().toString(), editText_user_password.getText().toString())));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, "Feature currently not implemented", "snackbar");
            }
        });

        textView_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL_login.setVisibility(View.VISIBLE);
                LL_register.setVisibility(View.GONE);
            }
        });

        textView_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL_login.setVisibility(View.GONE);
                LL_register.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showToast(View v, final String message, String type) {
        switch(type) {
            case "toast":
                StyleableToast stToast = StyleableToast.makeText(this, message, Toast.LENGTH_LONG, R.style.toast_custom_basic);
                //stToast.setGravity(Gravity.BOTTOM);
                stToast.show();
                break;

            case "snackbar":
                final Snackbar snacki = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
                snacki.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                snacki.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
                snacki.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // showToast(v, "Snackbar was pressed", "toast");
                        snacki.dismiss();
                    }
                });
                snacki.addCallback(new Snackbar.Callback());
                snacki.show();
                break;

            case "snackbar_autohide":
                final Snackbar snacki_autohide = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
                snacki_autohide.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                snacki_autohide.setDuration(BaseTransientBottomBar.LENGTH_LONG);
                snacki_autohide.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // showToast(v, "Snackbar was pressed", "toast");
                        snacki_autohide.dismiss();
                    }
                });
                snacki_autohide.addCallback(new Snackbar.Callback());
                snacki_autohide.show();
                break;
        }
    }

    private boolean login(String user_email, String user_password) {
        if(user_email.equals("xoyz.productions@gmail.com") && user_password.equals("123456")) { return true; }
        return false;
    }
}
