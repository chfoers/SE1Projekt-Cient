package fh_muenster.clubchamp;


import android.content.Intent;
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


public class MainActivity extends AppCompatActivity {

    EditText emailLogin;
    EditText pwLogin;
    String sessionId;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRegi();
        emailLogin = (EditText) findViewById(R.id.email_login);
        pwLogin = (EditText) findViewById(R.id.pw_login);
        b = (Button) findViewById(R.id.button_login);


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

    public void setupLogin()throws Exception{



        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (emailLogin.getText().length() != 0 && emailLogin.getText().toString() != "" && pwLogin.getText().toString() != "" && pwLogin.getText().length() != 0) {

                    /*String email = emailLogin.getText().toString();
                    String password = pwLogin.getText().toString();
                    AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding(new AQLIServiceEvents() {

                        @Override
                        public void Starting() {

                        }

                        @Override
                        public void Completed(AQLOperationResult result) {
                        String res = (String)result.Result;
                        }
                    },"http://10.0.2.2:8080/ClubChamp-System-ejb-0.0.1/ClubChampWebService");
                    service.loginAsync (email,password);
                    */
                    //Get the text control value
                    //AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                    //service.loginAsync(emailLogin.getText().toString(),pwLogin.getText().toString());
                    //Create instance for AsyncCallWS
                    new LoginAsync().execute();
                    //Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(MainActivity.this, Musikwunsch.class));
                } else {

                    Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();

                }
            }

        });
    }
    class LoginAsync extends AsyncTask<String, String, String> {

        private String email = emailLogin.getText().toString();
        private String password = pwLogin.getText().toString();
        /*AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding(new AQLIServiceEvents() {

            @Override
            public void Starting() {

            }

            @Override
            public void Completed(AQLOperationResult result) {
                String res = (String) result.Result;
            }
        }, "http://10.0.2.2:8080/ClubChamp-System-ejb-0.0.1/ClubChampWebService");
        */
        @Override
        protected void onPreExecute() {

        }

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


        protected void onPostExecute(String result) {
            Log.i("LOG: ", result);
            if(result.equals(" ")){

                Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
            }
            else {
                sessionId = result;
                Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Musikwunsch.class));
            }
        }
    }
}


