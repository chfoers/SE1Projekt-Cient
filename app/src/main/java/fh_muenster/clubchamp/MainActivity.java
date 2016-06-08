package fh_muenster.clubchamp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_login);
        setupRegi();
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

    public void setupLogin(){
        Button login = (Button) findViewById(R.id.button_login);


        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                EditText emailLogin = (EditText) findViewById(R.id.email_login);
                EditText pwLogin = (EditText) findViewById(R.id.pw_login);

                if( emailLogin.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();

                }
                else{
                    if( pwLogin.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Login successed", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, Musikwunsch.class));
                    }
                }

            }

        });

    }
}
