package project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity implements View.OnClickListener{

    Button btnEditar,btnEliminar,btnRepSintomas,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btnRepSintomas=(Button)findViewById(R.id.btnReportar);
        btnRepSintomas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                break;

            case R.id.btnEliminar:
                break;

            case R.id.btnReportar:
                Intent i3=new Intent(Inicio.this,ReprteDeSintomas.class);
                startActivity(i3);
                break;

            case R.id.btnSalir:

                break;
        }
    }
}