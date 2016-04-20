package com.pw.Bingo;

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


public class Search extends ActionBarActivity {

    TextView label;
    TextView aalabel;
    Firebase myFirebaseRef;
    Button button;
    TextView textView1;
    TextView textView2;
    TextView textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        button =(Button) findViewById(R.id.start);
        textView1 = (TextView) findViewById(R.id.player1);
        textView2 = (TextView) findViewById(R.id.player2);
        textView3 = (TextView) findViewById(R.id.player3);
        button.setEnabled(false);


        myFirebaseRef = new Firebase("https://glaring-fire-5485.firebaseio.com/ashish");

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext() ,main_game.class);
                Search.this.startActivity(i1);
            }
        });


        label = (TextView) findViewById(R.id.label);
        Intent intent = getIntent();
        String id = intent.getStringExtra(Play.EXTRA_MESSAGE2);
        label.setText(id);
        Application.setArenaID(id);

        lookIfPlayerAdded(id);


    }



    public void lookIfPlayerAdded(final String inputID){



        myFirebaseRef.child("arenas").child("arenaID: " + inputID).addListenerForSingleValueEvent( new ValueEventListener() {
            String assignID;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int childCount = (int) dataSnapshot.getChildrenCount();

                if(childCount == 1){
                    textView1.setText("Player 1 online");

                    assignID =  childCount + 1 + "";
                    myFirebaseRef.child("arenas").child("arenaID: " + inputID).child("player "+assignID ).setValue(assignID + "");
                    Application.setMyID(2);
                }

                if(childCount == 2){

                    textView1.setText("Player 1 online");
                    textView2.setText("Player 2 online");
                    assignID =  childCount + 1 + "";
                    myFirebaseRef.child("arenas").child("arenaID: " + inputID).child("player "+assignID ).setValue(assignID + "");
                    Application.setMyID(3);
                    button.setEnabled(true);
                    Toast.makeText(getApplicationContext() , "GET SET, GO!!",Toast.LENGTH_SHORT ).show();
                }

              }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        myFirebaseRef.child("arenas").child("arenaID: " + inputID).addValueEventListener(new ValueEventListener() {

            String assignID;

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
