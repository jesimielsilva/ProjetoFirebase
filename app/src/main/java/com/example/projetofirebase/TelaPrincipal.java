package com.example.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class TelaPrincipal extends AppCompatActivity {

    private TextView    textNomeUser, textEmailUser;
    private Button      bt_deslogar;

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

    private void IniciarComponentes(){
        textNomeUser    = findViewById(R.id.textNomeUser);
        textEmailUser   = findViewById(R.id.textEmailUser);
        bt_deslogar     = findViewById(R.id.bbt_deslogar);
    }

}