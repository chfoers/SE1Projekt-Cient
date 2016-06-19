package fh_muenster.clubchamp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;
import fh_muenster.webservices.AQLIServiceEvents;
import fh_muenster.webservices.AQLOperationResult;

/**
 * LoginActivity
 * @author Carlo Eefting
 */
public class MainActivity extends AppCompatActivity {

    EditText emailLogin;
    EditText pwLogin;
    String sessionId;
    Button b;

    SharedPreferences pref;

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRegi();
        emailLogin = (EditText) findViewById(R.id.email_login);
        pwLogin = (EditText) findViewById(R.id.pw_login);
        b = (Button) findViewById(R.id.button_login);
        pref = getApplication().getSharedPreferences("shared_preferences", 0);

        try{
        setupLogin();}
        catch (Exception e){}
    }

    /*@Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
    }
    */



    /**
     * Setup Registrierbutton
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

    /**
     * Setup Loginbutton. ruft den AsyncTask für login auf.
     * @throws Exception
     */
    public void setupLogin()throws Exception{



        b.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v
             */
            @Override
            public void onClick(View v) {


                if (emailLogin.getText().length() != 0 && emailLogin.getText().toString() != "" && pwLogin.getText().toString() != "" && pwLogin.getText().length() != 0) {


                    new LoginAsync().execute();

                } else {

                    Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();

                }
            }

        });
    }

    /**
     * ruft die Methode login aus dem Webservice auf.
     * @author Carlo Eefting
     *
     */
    class LoginAsync extends AsyncTask<String, String, String> {

        private String email = emailLogin.getText().toString();
        private String password = pwLogin.getText().toString();

        @Override
        protected void onPreExecute() {

        }

        /**
         *
         * @param strings
         * @return
         */
        @Override
        protected String doInBackground(String... strings) {
            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                try {
                    return service.login(email, password);

                } catch (Exception e) {
                    return " ";
                }
            }


        catch(Exception e){return " ";
        }
    }

        /**
         *
         * @param result
         */
          protected void onPostExecute(String result) {
            Log.i("LOG: ", result);
            if(result.equals(" ")){

                Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor editor = pref.edit();
                sessionId = result;
                editor.putString("Email", emailLogin.getText().toString());
                editor.putString("Password", pwLogin.getText().toString());
                editor.putString("Session",sessionId);
                editor.commit();
                Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Musikwunsch.class));
                finish();
            }
        }
    }
}


