package com.xoyz.code.universalflashcards;

import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
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
import com.xoyz.code.universalflashcards.global_classes.ufc_system;

public class MainActivity extends AppCompatActivity {

    private Point size = new Point();
    private int last_screen = 0;

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
                if(ufc_system.login(editText_user_email.getText().toString(), editText_user_password.getText().toString())) {
                    goToMainMenu();
                } else {
                    ufc_system.showToast(this, v, "Please check your login information and try again", ufc_system.Toast_Snackbar_autohide);
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ufc_system.showToast(this, v, "Feature currently not implemented. If you have any questions please contact the support", ufc_system.Toast_Snackbar_autohide);
            }
        });

        textView_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL_register.animate().setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        textView_to_login.setEnabled(false);
                        textView_to_register.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        textView_to_login.setEnabled(true);
                        textView_to_register.setEnabled(true);
                        if(last_screen == 0) {
                            LL_register.setVisibility(View.GONE);
                            LL_login.setVisibility(View.VISIBLE);
                            LL_login.animate().alpha(1f).start();
                        }
                    }
                });
                last_screen = 0;
                LL_register.animate().alpha(0f).start();
            }
        });

        textView_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL_login.animate().setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        textView_to_login.setEnabled(false);
                        textView_to_register.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if(last_screen == 1) {
                            LL_login.setVisibility(View.GONE);
                            LL_register.setVisibility(View.VISIBLE);
                            LL_register.animate().alpha(1f).start();
                        }
                        textView_to_login.setEnabled(true);
                        textView_to_register.setEnabled(true);
                    }
                });
                last_screen = 1;
                LL_login.animate().alpha(0f).start();
            }
        });
    }

    private void goToMainMenu() {
        Intent intent = new Intent(this, Universal_Flashcard_menu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
