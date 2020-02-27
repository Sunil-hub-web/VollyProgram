package com.example.vollyprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class ViewPage extends AppCompatActivity {

    ViewSwitcher switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        (findViewById(R.id.switcher)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewSwitcher switcher = (ViewSwitcher) v;

                if (switcher.getDisplayedChild() == 0) {
                    switcher.showNext();
                } else {
                    switcher.showPrevious();
                }
            }
        });
    }
}
