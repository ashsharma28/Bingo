package com.pw.Bingo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ankit.Bingo.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.UUID;


public class Play extends ActionBarActivity {



    public final static String EXTRA_MESSAGE1 = "these things dont matter largely..at this stage thus are ignorable";
    public final static String EXTRA_MESSAGE2 = "ignorable";


    //TODO exit button
    //TODO 2 player game start
    //TODO Bingo! cut


    Button b1,b2;
    EditText idText;
    Firebase myFirebaseRef;
    boolean[][] matrix = new boolean[][]
            {
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false}
            }
            ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myFirebaseRef = new Firebase("https://glaring-fire-5485.firebaseio.com/ashish");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);





        b1=(Button) findViewById(R.id.joinArena);
        b2=(Button) findViewById(R.id.newArena);
        idText = (EditText)findViewById(R.id.idText);


        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String uniqueID = UUID.randomUUID().toString().substring(1, 5);
                myFirebaseRef.child("arenas").child("arenaID: " + uniqueID).child("player 1").setValue(1 + "");
                myFirebaseRef.child("arenas").child("VarForArenaID: " + uniqueID).child("turnOfPlayerWithId").setValue(1 + "");
                myFirebaseRef.child("arenas").child("VarForArenaID: " + uniqueID).child("valueSelectedByPlayer").setValue(1 + "");

                Application.setArenaID(uniqueID);
                Application.setMyID(1);

                Intent i2 = new Intent(Play.this,Start1.class);
                i2.putExtra(EXTRA_MESSAGE1 , uniqueID);
                Play.this.startActivity(i2);

            }
        });





        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                final String inputID = idText.getText() + "";

                final Intent intent = new Intent(Play.this,Search.class);
                intent.putExtra(EXTRA_MESSAGE2 , inputID);


                    myFirebaseRef.child("arenas").child("arenaID: " + inputID).addListenerForSingleValueEvent( new ValueEventListener() {
                        String assignID;

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            int childCount = (int) dataSnapshot.getChildrenCount();



                            if(!dataSnapshot.exists()){
                                Toast.makeText(getApplicationContext() , "INVALID ID",Toast.LENGTH_SHORT ).show();
                                //TODO don't let this activity opwen
                            }

                            else {

                                if(childCount>2){
                                    Toast.makeText(getApplicationContext() , "ARENA FULL",Toast.LENGTH_SHORT ).show();
                                }
                                else
                                    Play.this.startActivity(intent);

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
            }
        });
    }
}
