package fh_muenster.clubchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Musikwunsch extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musikwunsch);
        ListView wuensche = (ListView) findViewById(R.id.lvw);
        String[] items = {"Test1","Test2","Test3"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this, R.layout.activity_musikliste, R.id.txtv, arrayList);
        wuensche.setAdapter(adapter);
       setupWunsch();
    }

    public void setupWunsch() {
        Button wunsch = (Button) findViewById(R.id.button_wabgeben);


        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText wun = (EditText) findViewById(R.id.wunsch);
                String wu = wun.getText().toString();
                arrayList.add(wu);
                adapter.notifyDataSetChanged();
                wun.setText("");

            }

        };
        wunsch.setOnClickListener(myListener);

    }
}
