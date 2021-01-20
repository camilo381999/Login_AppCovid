package project.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    EditText us,pas,nom,ap,dir,ced,edad;
    RadioButton genero;
    Button reg,can;

    String generoS;
    String usu="";
    String pass="";
    String nomb="";
    String ape="";
    String dire="";
    String cedu="";
    String ed="";

    FirebaseAuth mAuth;
    DatabaseReference nDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        mAuth=FirebaseAuth.getInstance();
        nDatabase=FirebaseDatabase.getInstance().getReference();

        genero=(RadioButton)findViewById(R.id.RegRadbtnH);
        reg=(Button)findViewById(R.id.btnRegRegistrar);
        can=(Button)findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegRegistrar:


                //Firebase

                usu=(us.getText().toString());
                pass=(pas.getText().toString());
                nomb=(nom.getText().toString());
                ape=(ap.getText().toString());
                dire=(dir.getText().toString());
                ed=(edad.getText().toString());
                cedu=(ced.getText().toString());

                if (usu.isEmpty()&&pass.isEmpty()&&nomb.isEmpty()&&
                        ape.isEmpty()&&dire.isEmpty()&&ed.isEmpty()&&cedu.isEmpty()){
                    if (pass.length()>=6){
                        registerUser();
                    }else {
                        Toast.makeText(this,"La contraseña debe tener 6 caracteres", Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(this,"Debe completar la información", Toast.LENGTH_LONG).show();
                }

                //Obtener dato radioButton
                if (genero.isChecked()==true){
                    generoS="Hombre";

                }else{
                    generoS="Mujer";
                }


                Intent b=new Intent(Registrar.this,MainActivity.class);
                startActivity(b);
                break;

            case R.id.btnRegCancelar:
                Intent i=new Intent(Registrar.this,MainActivity.class);
                startActivity(i);
                break;
        }
    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(usu,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                }else{
                    Toast.makeText(Registrar.this,"No se pudo registrar este usuario", Toast.LENGTH_LONG).show();
                }
            }});
    }

}