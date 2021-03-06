package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class advertise extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String kind = getIntent().getStringExtra("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertise);
        makeDescription(kind);
    }

    private void makeDescription(String type)
    {
        TextView userDesc = findViewById(R.id.user_desc);
        TextView username = findViewById(R.id.username);

        if (type.equals("senior"))
        {
            username.setText("senior");
            /*pull senior aid people
             *for <member> in <task>
             *    add to array
             * end for
             * start putting people into queue
             */
        }
        else if (type.equals("child"))
        {
            username.setText("child");
            /*pull child care people
             *for <member> in <task>
             *    add to array
             * end for
             * start putting people into queue
             */
        }
        else if (type.equals("pet"))
        {
            username.setText("pet");
            /*pull pet people
             *for <member> in <task>
             *    add to array
             * end for
             * start putting people into queue
             */
        }

    }

}
