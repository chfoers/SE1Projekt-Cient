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

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;


public class MainActivity extends AppCompatActivity {

    EditText emailLogin;
    EditText pwLogin;
    Button b;


    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();

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
                    //Get the text control value
                    email = emailLogin.getText().toString();
                    //Create instance for AsyncCallWS
                    AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                    try{service.loginAsync(emailLogin.getText().toString(),pwLogin.getText().toString());}
                    catch (Exception e){}
                    Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, Musikwunsch.class));
                } else {

                    Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();

                }
            }

        });
    }

}


