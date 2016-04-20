package com.pw.Bingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ankit.Bingo.R;
import com.firebase.client.Firebase;


public class main_2 extends Activity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        b1=(Button) findViewById(R.id.joinArena);
        b2=(Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i1 = new Intent(main_2.this,Play.class);
                main_2.this.startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(main_2.this,abc2.class);
                main_2.this.startActivity(i2);
            }
        });

    }


}
