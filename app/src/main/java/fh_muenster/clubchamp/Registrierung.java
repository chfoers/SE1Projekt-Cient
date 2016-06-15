package fh_muenster.clubchamp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;

public class Registrierung extends AppCompatActivity {

    EditText regiEmail;
    EditText regiUser;
    EditText regiPW;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regi);
        regiEmail = (EditText) findViewById(R.id.email_regis);
        regiUser = (EditText) findViewById(R.id.regiUser);
        regiPW = (EditText) findViewById(R.id.regiPW);
        b = (Button) findViewById(R.id.button_registrieren);

        setupRegi();
    }

    public void setupRegi() {





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (regiEmail.getText().length() != 0 && regiEmail.getText().toString() != "" &&
                        regiUser.getText().toString() != "" && regiUser.getText().length() != 0 &&
                        regiPW.getText().toString() != "" && regiPW.getText().length() != 0){
                    new RegiAsync().execute();
                }
                else{
                    Toast.makeText(Registrierung.this,"Bitte füll alle Felder aus", Toast.LENGTH_LONG).show();
                }
            }

        });


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
    */class RegiAsync extends AsyncTask<String, String, String> {

      private String regiMail = regiEmail.getText().toString();
      private String regiUse = regiUser.getText().toString();
      private String regiPas = regiPW.getText().toString();
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
                  String res = service.signUp(regiMail, regiUse,regiPas).toString();
                  return res;
                  //return service.signUp(regiMail, regiUse,regiPas);

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

              Toast.makeText(Registrierung.this,"Login failed", Toast.LENGTH_LONG).show();
          }
          else {

              Toast.makeText(Registrierung.this, "Registrierung erfolgreich", Toast.LENGTH_LONG).show();
              startActivity(new Intent(Registrierung.this, Musikwunsch.class));
          }
      }
  }
}
