package project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LoginAdmin extends AppCompatActivity  implements View.OnClickListener {


    Button btnEditarAdmin,btnVerUsers,btnSalirAdmin;
    private FirebaseAuth nAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        nAuth=FirebaseAuth.getInstance();

        btnEditarAdmin=(Button)findViewById(R.id.btnEditarAdmin);
        btnEditarAdmin.setOnClickListener(this);

        btnSalirAdmin=(Button)findViewById(R.id.btnSalirAdmin);
        btnSalirAdmin.setOnClickListener(this);

        btnVerUsers=(Button)findViewById(R.id.btnVerUsuarios);
        btnVerUsers.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditarAdmin:
                Intent i1=new Intent(LoginAdmin.this,Editar.class);
                startActivity(i1);
                break;

            case R.id.btnVerUsuarios:
                Intent i2=new Intent(LoginAdmin.this,Mostrar.class);
                startActivity(i2);
                break;


            case R.id.btnSalirAdmin:
                nAuth.signOut();
                startActivity(new Intent(LoginAdmin.this,MainActivity.class));
                finish();
                break;
        }
    }

    }
