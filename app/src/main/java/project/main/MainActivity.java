package project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user, pass;
Button btnEntrar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        String usuario=user.getText().toString();
        String contraseña=pass.getText().toString();
        switch (v.getId()){
            case R.id.btnEntrar:

                if((!usuario.equals("")) && (!contraseña.equals(""))){
                    if(usuario.equals("correo@mail.com") && contraseña.equals("admin")){
                        i=new Intent(MainActivity.this,Inicio.class);
                        startActivity(i);
                    }
                }else {
                    Toast.makeText(this,"Error: Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }

                /**/

                break;

            case R.id.btnRegistrar:
                i=new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }

    }
}