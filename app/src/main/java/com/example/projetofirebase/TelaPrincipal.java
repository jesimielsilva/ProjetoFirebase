package com.example.projetofirebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TelaPrincipal extends AppCompatActivity {

    private TextView    textNomeUser, textEmailUser;
    private Button      bt_deslogar;
    FirebaseFirestore   bd  =   FirebaseFirestore.getInstance();
    String  usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        IniciarComponentes();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut(); //encerrando usuario
                Intent intent   = new Intent(TelaPrincipal.this, FormLogin.class); // direcionando para tela de login
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        String  email   =   FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioID       =   FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference =   bd.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    textNomeUser.setText(documentSnapshot.getString("nome"));
                    textEmailUser.setText(email);
                }
            }
        });
    }

    private void IniciarComponentes(){
        textNomeUser    = findViewById(R.id.textNomeUser);
        textEmailUser   = findViewById(R.id.textEmailUser);
        bt_deslogar     = findViewById(R.id.bbt_deslogar);
    }

}