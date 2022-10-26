package com.yaprak.customviewwithjson;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
               CustomViews customViews = JsonReader.convertJsonToObject(MainActivity.this);


                LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                       RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                               RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                linearLayout.setLayoutParams(relativeParams);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setGravity(Gravity.RIGHT);
                relativeLayout.addView(linearLayout);
                       for (CustomViewList list : customViews.CustomViewList ){
                          if (list.CustomViewType.equals("text")){
                               EditText dene = new EditText(getApplicationContext());
                               dene.setText(list.Header);

                              linearLayout.addView(dene);
                           }
                           if (list.CustomViewType.equals("checkBox"))
                           {
                               CheckBox dene = new CheckBox(getApplicationContext());
                               dene.setText(list.Header);

                               linearLayout.addView(dene);
                           }

                            if (list.CustomViewType.equals("drd"))
                           {
                               Spinner dene = new Spinner(getApplicationContext());
                               dene.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list.Data));

                               linearLayout.addView(dene);
                           }

                       }

            }
        });
    }
}