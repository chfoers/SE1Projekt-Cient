package fh_muenster.clubchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Adapter;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        TextView use = (TextView) findViewById(R.id.tvUser);


        use.setText("ICH BIN GEIL");
      //TextView usern = (TextView) findViewById(R.id.tvEmail);
        //TextView usN = (TextView) findViewById(R.id.tvUser);

        //usN.setText(usern.getText().toString());
        setupWunsch();
    }

    public void setupWunsch() {
        Button wunsch = (Button) findViewById(R.id.button_wabgeben);


        OnClickListener myListener = new OnClickListener() {
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

    public void setupLogout(){
        Button logout = (Button) findViewById(R.id.button_Logout);

        OnClickListener myListener = new OnClickListener(){

            @Override
            public void onClick(View v) {


            }
        };

    }

}
