package fh_muenster.clubchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                startActivity(new Intent(Registrierung.this, Musikwunsch.class));
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
