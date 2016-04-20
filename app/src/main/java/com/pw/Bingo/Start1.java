package com.pw.Bingo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ankit.Bingo.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class Start1 extends ActionBarActivity {

    Button button;
    Firebase myFirebaseRef;
    TextView textView1;
    TextView textView2;
    TextView textView3;


    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start1);
        textView = (TextView) findViewById(R.id.labelForId);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        button =(Button) findViewById(R.id.startGame);

        Intent intent = getIntent();
        String uniqueID = intent.getStringExtra(Play.EXTRA_MESSAGE1);

        textView.setText(uniqueID);
        String some = "Player 1 online";
        textView1.setText(some);

        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext() ,main_game.class);
                Start1.this.startActivity(i1);
            }
        });

        myFirebaseRef = new Firebase("https://glaring-fire-5485.firebaseio.com/ashish");

        lookIfPlayerAdded(uniqueID);



    }



    public void lookIfPlayerAdded(final String inputID){


        myFirebaseRef.child("arenas").child("arenaID: " + inputID).addValueEventListener(new ValueEventListener() {

            String assignID;

            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int childCount = (int) dataSnapshot.getChildrenCount();

                if(childCount == 2){
                    textView2.setText("Player 2 online");
                }

                if(childCount == 3){
                    textView3.setText("Player 3 online");
                    Toast.makeText(getApplicationContext() , "GET SET, GO!!",Toast.LENGTH_SHORT ).show();
                    button.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


}
