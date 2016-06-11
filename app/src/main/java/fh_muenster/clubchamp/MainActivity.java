package fh_muenster.clubchamp;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText emailLogin;
    EditText pwLogin;
    Button b;


    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRegi();


        emailLogin = (EditText) findViewById(R.id.email_login);
        pwLogin = (EditText) findViewById(R.id.pw_login);
        b = (Button) findViewById(R.id.button_login);

        setupLogin();
    }

    /*@Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
    }
    */


    public void setupRegi() {
        Button regis = (Button) findViewById(R.id.button_Regis);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registrierung.class));
            }

        };
        regis.setOnClickListener(myListener);

    }

    public void setupLogin() {



        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (emailLogin.getText().length() != 0 && emailLogin.getText().toString() != "" && pwLogin.getText().toString() != "" && pwLogin.getText().length() != 0) {
                    //Get the text control value
                    email = emailLogin.getText().toString();
                    //Create instance for AsyncCallWS
                    AsyncCallWS task = new AsyncCallWS();
                    //Call execute
                    task.execute();
                    //If text control is empty
                    Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, Musikwunsch.class));
                } else {

                    Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();

                }
            }

        });
    }

    /**
     * Created by user on 09.06.16.
     */
    public class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response



        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }
}


