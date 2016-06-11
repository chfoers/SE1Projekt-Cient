package fh_muenster.clubchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Musikwunsch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musikwunsch);
        setupWunsch();
    }

    public void setupWunsch() {
        Button wunsch = (Button) findViewById(R.id.button_wunsch);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Musikwunsch.this, Musikwunsch.class));
            }

        };
        wunsch.setOnClickListener(myListener);

    }
}
