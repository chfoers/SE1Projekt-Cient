package fh_muenster.clubchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrierung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regi);

        setupRegi();
    }

    public void setupRegi() {
        Button regis = (Button) findViewById(R.id.button_registrieren);




        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText regiEmail = (EditText) findViewById(R.id.email_regis);
                EditText regiUser = (EditText) findViewById(R.id.regiUser);
                EditText regiPW = (EditText) findViewById(R.id.regiPW);

                if (regiEmail.getText().length() != 0 && regiEmail.getText().toString() != "" &&
                        regiUser.getText().toString() != "" && regiUser.getText().length() != 0 &&
                        regiPW.getText().toString() != "" && regiPW.getText().length() != 0){
                    Toast.makeText(Registrierung.this, "Registrierung erfolgreich", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Registrierung.this, Musikwunsch.class));
                }
                else{
                    Toast.makeText(Registrierung.this,"Bitte füll alle Felder aus", Toast.LENGTH_LONG).show();
                }
            }

        };
        regis.setOnClickListener(myListener);

    }
  /*  @Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_musikwunsch);
    }

    @Override
    protected void onPause(){
        super.onPause();
        setContentView(R.layout.activity_main);
    }
    */
}
