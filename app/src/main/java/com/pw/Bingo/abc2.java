package com.pw.Bingo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.ankit.Bingo.R;


public class abc2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abc2, menu);
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
    public void onStart() {
        super.onStart();

        WebView web =  (WebView)findViewById(R.id.webView);
        //enable JavaScript
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/index.html");
        web.addJavascriptInterface(new java2JSAgent(), "java2JSAgentVar");
    }


    public class java2JSAgent
    {
        @android.webkit.JavascriptInterface
        public String getContacts()
        {
            String jsonResponse = null;
            //call Android APIs to get contacts
            //serialize to JSON and assign to jsonResponse

            return jsonResponse;
        }
    }
}
