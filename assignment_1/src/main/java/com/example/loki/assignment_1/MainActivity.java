package com.example.loki.assignment_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    protected void onStart() {
        Log.i("MyAPP", "started");
       super.onStart();
         //The activity is about to become visible.
    }

    @Override
    protected void onResume() {
        Log.i("MyAPP", "Resumed");
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        Log.i("MyAPP","Paused");
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        Log.i("MyAPP","Stopped");
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        Log.i("MyApp","Destroyed");
        super.onDestroy();
        // The activity is about to be destroyed.
    }

    public void onClick(View v) {
        Log.i("MyAPP", "Button pressed");
        Button button = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.textView2);
        String [] quotes = getResources().getStringArray(R.array.movies);
        Random rand = new Random();
        text.setText(quotes[rand.nextInt(quotes.length)]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
