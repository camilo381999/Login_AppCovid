package project.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ReprteDeSintomas extends AppCompatActivity  implements View.OnClickListener {
    EditText etOtro;
    CheckBox cbFiebre,cbTos,cbDolor,cbRespiracion,cbOlfato,cbOpecho;
    RadioButton siNo;
    Button enviar;
    int puntaje;
    String otro;
    String estado="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprte_de_sintomas);

        enviar=(Button)findViewById(R.id.btnEnviarForm);


        cbFiebre=(CheckBox)findViewById(R.id.cbFiebre);
        cbTos=(CheckBox)findViewById(R.id.cbTos);
        cbDolor=(CheckBox)findViewById(R.id.cbDolor);
        cbRespiracion=(CheckBox)findViewById(R.id.cbRespiracion);
        cbOlfato=(CheckBox)findViewById(R.id.cbOlfato);
        cbOpecho=(CheckBox)findViewById(R.id.cbOPecho);
        siNo=(RadioButton)findViewById(R.id.RegRadbtnSi);
        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnEnviarForm:

                if (checkEstado().equals("Positivo")){
                    Toast.makeText(this,"Tome cuarentena", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(ReprteDeSintomas.this,Inicio.class);
                    startActivity(i);
                } else {
                    Toast.makeText(this,"No posee riesgo", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(ReprteDeSintomas.this,Inicio.class);
                    startActivity(i);
                }
                //Firebase
               // otro=(etOtro.getText().toString());
                        //registerSintomas();



                break;
        }
    }
    public  String checkEstado(){
        if (revisarSintomas()>=4){
            estado="Positivo";
        }
        return  estado;
    }


    public  int revisarSintomas(){

        puntaje = 0;

        if(cbFiebre.isChecked() == true){
            puntaje++;
        }
        if(cbTos.isChecked() == true){
            puntaje++;

        }
        if(cbDolor.isChecked() == true){
            puntaje++;

        }
        if(cbRespiracion.isChecked() == true){
            puntaje++;

        }
        if(cbOlfato.isChecked() == true){
            puntaje++;

        }
        if(cbOpecho.isChecked() == true){
            puntaje++;
        }
        if(siNo.isChecked() == true){
           puntaje= puntaje+4;
        }

        return puntaje;
    }

}