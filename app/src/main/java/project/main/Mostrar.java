package project.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import project.main.Informes.Informe;
import project.main.Informes.InformeAdapter;

public class Mostrar extends AppCompatActivity {

    private InformeAdapter iAdapter;
    private RecyclerView nRecyclerView;
    private ArrayList<Informe> nInformesList=new ArrayList<>();
    private ArrayList<String> nInformesList2=new ArrayList<>();
    private DatabaseReference nDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar);

        nDatabase= FirebaseDatabase.getInstance().getReference();

        nRecyclerView=(RecyclerView)findViewById(R.id.recyclerViewInforme);
        nRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getInformeFromFirebase();

    }

    private void getInformeFromFirebase(){
        nDatabase.child("Informes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    nInformesList2.clear();
                    for (DataSnapshot ds: snapshot.getChildren()){
                        String cedula =ds.child("cedula").getValue().toString();
                        String correo =ds.child("correo").getValue().toString();
                        String estado =ds.child("estado").getValue().toString();
                        String fecha =ds.child("fecha").getValue().toString();
                        String puntaje =ds.child("puntaje").getValue().toString();

                       /* String informeSt=cedula+" "+correo+" "+estado+" "+fecha+" "+puntaje;
                        nInformesList2.add(informeSt);*/

                      nInformesList.add(new Informe(cedula,correo,estado,fecha,puntaje));
                    }
                    iAdapter =new InformeAdapter(nInformesList,R.layout.informe);
                    nRecyclerView.setAdapter(iAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}