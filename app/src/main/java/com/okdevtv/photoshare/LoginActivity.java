package com.okdevtv.photoshare;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void signIn(View view) {
        EditText editTextId = (EditText) findViewById(R.id.id);
        EditText editTextPassword = (EditText) findViewById(R.id.password);
        String id = editTextId.getText().toString();
        String password = editTextPassword.getText().toString();
        Log.d(this.getLocalClassName(), "login info " + id + ", " + password);

        boolean isValid = checkLogin(id, password);
        if (isValid) {
            // go main
            goMain(view);

        } else {
            // show wrong
            // password reset
            editTextPassword.setText("");
        }
    }

    private boolean checkLogin(String id, String password) {
        return "user".equals(id) && "1234".equals(password);
    }

    public void goMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void goDetail(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
    public void goShare(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }
}
