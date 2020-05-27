package com.xoyz.code.universalflashcards.global_classes;

import android.content.Context;
import android.util.JsonReader;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.muddzdev.styleabletoast.StyleableToast;
import com.xoyz.code.universalflashcards.R;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ufc_system {
    public static String Toast_Toast = "toast";
    public static String Toast_Snackbar = "snackbar";
    public static String Toast_Snackbar_autohide = "snackbar_autohide";

    public static JSONObject cards;

    public static boolean login(String user_email, String user_password) {
        if(user_email.equals("xoyz.productions@gmail.com") && user_password.equals("123456")) { return true; }
        return false;
    }

    public static void showToast(View.OnClickListener context, View v, final String message, String type) {
        switch(type) {
            case "toast":
                StyleableToast stToast = StyleableToast.makeText((Context) context, message, Toast.LENGTH_LONG, R.style.toast_custom_basic);
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

    public static String readAll(String filePath)
    {
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    private static void write_to_file(String path, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(content);
    }

    public static void t() throws IOException {
        write_to_file("/test.json", "[3,2]");
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/test.json"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            assert companyList != null;
            for (Object o : companyList) {
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
