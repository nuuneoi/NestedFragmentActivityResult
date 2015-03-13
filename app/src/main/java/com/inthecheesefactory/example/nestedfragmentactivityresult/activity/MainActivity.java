package com.inthecheesefactory.example.nestedfragmentactivityresult.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.inthecheesefactory.example.nestedfragmentactivityresult.R;
import com.inthecheesefactory.example.nestedfragmentactivityresult.bus.MainBus;
import com.inthecheesefactory.example.nestedfragmentactivityresult.bus.event.ActivityResultEvent;
import com.inthecheesefactory.example.nestedfragmentactivityresult.fragment.GroundFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.contentContainer, GroundFragment.newInstance())
                                       .commit();
        }
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

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Toast.makeText(MainActivity.this, "Activity Got it: " + requestCode + ", " + resultCode, Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "Fire Event");
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                MainBus.getInstance().post(new ActivityResultEvent(requestCode, resultCode, data));
            }
        });
    }
}
