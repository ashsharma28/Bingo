package com.pw.Bingo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ankit.Bingo.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class main_game extends ActionBarActivity {



    Button textView0;
    Button textView1;
    Button textView2;
    Button textView3;
    Button textView4;
    Button textView5;
    Button textView6;
    Button textView7;
    Button textView8;
    Button textView9;
    Button textView10;
    Button textView11;
    Button textView12;
    Button textView13;
    Button textView14;
    Button textView15;
    Button textView16;
    Button textView17;
    Button textView18;
    Button textView19;
    Button textView20;
    Button textView21;
    Button textView22;
    Button textView23;
    Button textView24;

    TextView turnOf1;
    TextView turnOf2;
    TextView turnOf3;

    TextView B;
    TextView I;
    TextView N;
    TextView G;
    TextView O;

    Firebase myFirebaseRef;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://glaring-fire-5485.firebaseio.com/ashish");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        textView0=  (Button) findViewById(R.id.button26);
        textView1=  (Button) findViewById(R.id.button27);
        textView2=  (Button) findViewById(R.id.button28);
        textView3=  (Button) findViewById(R.id.button29);
        textView4=  (Button) findViewById(R.id.button30);
        textView5=  (Button) findViewById(R.id.button31);
        textView6=  (Button) findViewById(R.id.button32);
        textView7=  (Button) findViewById(R.id.button33);
        textView8=  (Button) findViewById(R.id.button34);
        textView9=  (Button) findViewById(R.id.button35);
        textView10= (Button) findViewById(R.id.button36);
        textView11= (Button) findViewById(R.id.button37);
        textView12= (Button) findViewById(R.id.button38);
        textView13= (Button) findViewById(R.id.button39);
        textView14= (Button) findViewById(R.id.button40);
        textView15= (Button) findViewById(R.id.button41);
        textView16= (Button) findViewById(R.id.button42);
        textView17= (Button) findViewById(R.id.button43);
        textView18= (Button) findViewById(R.id.button44);
        textView19= (Button) findViewById(R.id.button45);
        textView20= (Button) findViewById(R.id.button46);
        textView21= (Button) findViewById(R.id.button47);
        textView22= (Button) findViewById(R.id.button48);
        textView23= (Button) findViewById(R.id.button49);
        textView24= (Button) findViewById(R.id.button50);

        turnOf1  = (TextView) findViewById(R.id.player1Button);
        turnOf2  = (TextView) findViewById(R.id.player2Button);
        turnOf3  = (TextView) findViewById(R.id.player3Button);

        B  = (TextView) findViewById(R.id.B);
        I  = (TextView) findViewById(R.id.I);
        N  = (TextView) findViewById(R.id.N);
        G  = (TextView) findViewById(R.id.G);
        O  = (TextView) findViewById(R.id.O);


        textView0.setEnabled(false);
        textView1.setEnabled(false);
        textView2.setEnabled(false);
        textView3.setEnabled(false);
        textView4.setEnabled(false);
        textView5.setEnabled(false);
        textView6.setEnabled(false);
        textView7.setEnabled(false);
        textView8.setEnabled(false);
        textView9.setEnabled(false);
        textView10.setEnabled(false);
        textView11.setEnabled(false);
        textView12.setEnabled(false);
        textView13.setEnabled(false);
        textView23.setEnabled(false);
        textView14.setEnabled(false);
        textView15.setEnabled(false);
        textView16.setEnabled(false);
        textView17.setEnabled(false);
        textView18.setEnabled(false);
        textView19.setEnabled(false);
        textView20.setEnabled(false);
        textView21.setEnabled(false);
        textView22.setEnabled(false);
        textView24.setEnabled(false);

        setValuesInTextBox();

        myFirebaseRef.child("arenas")
                .child("VarForArenaID: " + Application.getArenaID())
                .child("turnOfPlayerWithId").addValueEventListener( new ValueEventListener()
        {
            int  myID = Application.getMyID();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String  changedValue = dataSnapshot.getValue() + "";

                if(changedValue.equals(1+"")){ turnOf1.setBackgroundColor(Color.GREEN); turnOf2.setBackgroundColor(Color.TRANSPARENT); turnOf3.setBackgroundColor(Color.TRANSPARENT);}
                if(changedValue.equals(2+"")){ turnOf2.setBackgroundColor(Color.GREEN); turnOf1.setBackgroundColor(Color.TRANSPARENT); turnOf3.setBackgroundColor(Color.TRANSPARENT);}
                if(changedValue.equals(3+"")){ turnOf3.setBackgroundColor(Color.GREEN); turnOf1.setBackgroundColor(Color.TRANSPARENT); turnOf2.setBackgroundColor(Color.TRANSPARENT);}


                if(changedValue.equals(""+myID)){
                    setButtonStatus(true);

                }
                else
                {

                    setButtonStatus(false);
                    myFirebaseRef.child("arenas")
                            .child("VarForArenaID: " + Application.getArenaID())
                            .child("valueSelectedByPlayer").addValueEventListener( new ValueEventListener(){

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String valueSelectedByPlayer = (String) dataSnapshot.getValue();
                            strikeValue(valueSelectedByPlayer);

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });


                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





    }


    private void setButtonStatus(Boolean status){
        textView0. setEnabled(status);
        textView1. setEnabled(status);
        textView2. setEnabled(status);
        textView3. setEnabled(status);
        textView4. setEnabled(status);
        textView5. setEnabled(status);
        textView6. setEnabled(status);
        textView7. setEnabled(status);
        textView8. setEnabled(status);
        textView9. setEnabled(status);
        textView10.setEnabled(status);
        textView11.setEnabled(status);
        textView12.setEnabled(status);
        textView13.setEnabled(status);
        textView14.setEnabled(status);
        textView15.setEnabled(status);
        textView16.setEnabled(status);
        textView17.setEnabled(status);
        textView18.setEnabled(status);
        textView19.setEnabled(status);
        textView20.setEnabled(status);
        textView21.setEnabled(status);
        textView22.setEnabled(status);
        textView23.setEnabled(status);
        textView24.setEnabled(status);
    }
    /**
     * Randomise the values of text fields
     */
    private void setValuesInTextBox()
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 26; i++)
        {
            numbers.add(i+1);
        }



        Collections.shuffle(numbers);


        textView0.setText(numbers.get(25).intValue() + "");
        textView1.setText(numbers.get(1).intValue() + "" );
        textView2.setText(numbers.get(2).intValue() + "" );
        textView3.setText(numbers.get(3).intValue() + "" );
        textView4.setText(numbers.get(4).intValue() + "" );
        textView5.setText(numbers.get(5).intValue() + "" );
        textView6.setText(numbers.get(6).intValue() + "" );
        textView7.setText(numbers.get(7).intValue() + "" );
        textView8.setText(numbers.get(8).intValue() + "" );
        textView9.setText(numbers.get(9).intValue() + "" );
        textView10.setText(numbers.get(10).intValue() + "" );
        textView11.setText(numbers.get(11).intValue() + "" );
        textView12.setText(numbers.get(12).intValue() + "" );
        textView13.setText(numbers.get(13).intValue() + "" );
        textView14.setText(numbers.get(14).intValue() + "" );
        textView15.setText(numbers.get(15).intValue() + "" );
        textView16.setText(numbers.get(16).intValue() + "" );
        textView17.setText(numbers.get(17).intValue() + "" );
        textView18.setText(numbers.get(18).intValue() + "" );
        textView19.setText(numbers.get(19).intValue() + "" );
        textView20.setText(numbers.get(20).intValue() + "" );
        textView21.setText(numbers.get(21).intValue() + "" );
        textView22.setText(numbers.get(22).intValue() + "" );
        textView23.setText(numbers.get(23).intValue() + "" );
        textView24.setText(numbers.get(24).intValue() + "" );




    }


    int  valueSelected;
    private void strikeValue(String valueSelectedByPlayer) {

        if(textView0.getText().equals(valueSelectedByPlayer + "" ) ) textView0.setBackgroundColor(Color.RED);
        if(textView1.getText().equals(valueSelectedByPlayer + "" ) ) textView1.setBackgroundColor(Color.RED);
        if(textView2.getText().equals(valueSelectedByPlayer + "" ) ) textView2.setBackgroundColor(Color.RED);
        if(textView3.getText().equals(valueSelectedByPlayer + "" ) ) textView3.setBackgroundColor(Color.RED);
        if(textView4.getText().equals(valueSelectedByPlayer + "" ) ) textView4.setBackgroundColor(Color.RED);
        if(textView5.getText().equals(valueSelectedByPlayer + "" ) ) textView5.setBackgroundColor(Color.RED);
        if(textView6.getText().equals(valueSelectedByPlayer + "" ) ) textView6.setBackgroundColor(Color.RED);
        if(textView7.getText().equals(valueSelectedByPlayer + "" ) ) textView7.setBackgroundColor(Color.RED);
        if(textView8.getText().equals(valueSelectedByPlayer + "" ) ) textView8.setBackgroundColor(Color.RED);
        if(textView9.getText().equals(valueSelectedByPlayer + "" ) ) textView9.setBackgroundColor(Color.RED);
        if(textView10.getText().equals(valueSelectedByPlayer + "" ) ) textView10.setBackgroundColor(Color.RED);
        if(textView11.getText().equals(valueSelectedByPlayer + "" ) ) textView11.setBackgroundColor(Color.RED);
        if(textView12.getText().equals(valueSelectedByPlayer + "" ) ) textView12.setBackgroundColor(Color.RED);
        if(textView13.getText().equals(valueSelectedByPlayer + "" ) ) textView13.setBackgroundColor(Color.RED);
        if(textView14.getText().equals(valueSelectedByPlayer + "" ) ) textView14.setBackgroundColor(Color.RED);
        if(textView15.getText().equals(valueSelectedByPlayer + "" ) ) textView15.setBackgroundColor(Color.RED);
        if(textView16.getText().equals(valueSelectedByPlayer + "" ) ) textView16.setBackgroundColor(Color.RED);
        if(textView17.getText().equals(valueSelectedByPlayer + "" ) ) textView17.setBackgroundColor(Color.RED);
        if(textView18.getText().equals(valueSelectedByPlayer + "" ) ) textView18.setBackgroundColor(Color.RED);
        if(textView19.getText().equals(valueSelectedByPlayer + "" ) ) textView19.setBackgroundColor(Color.RED);
        if(textView20.getText().equals(valueSelectedByPlayer + "" ) ) textView20.setBackgroundColor(Color.RED);
        if(textView21.getText().equals(valueSelectedByPlayer + "" ) ) textView21.setBackgroundColor(Color.RED);
        if(textView22.getText().equals(valueSelectedByPlayer + "" ) ) textView22.setBackgroundColor(Color.RED);
        if(textView23.getText().equals(valueSelectedByPlayer + "" ) ) textView23.setBackgroundColor(Color.RED);
        if(textView24.getText().equals(valueSelectedByPlayer + "" ) ) textView24.setBackgroundColor(Color.RED);


    }


    /**
     * Onclick handler for each of the buttons, on the GUI. Basically strikes off that button and further actions.
     * @param view
     */
    public void onClickHandler(View view)
    {
        String text = ((Button) view).getText() + "";

        int myId = Application.getMyID();
        int nextID =0;

        if(myId == 1) nextID =2;
        if(myId == 2) nextID =3;
        if(myId == 3) nextID =1;
        myFirebaseRef.child("arenas").child("VarForArenaID: " + Application.getArenaID()).child("valueSelectedByPlayer").setValue(text);

        myFirebaseRef.child("arenas").child("VarForArenaID: " + Application.getArenaID()).child("turnOfPlayerWithId").setValue(nextID + "");
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
