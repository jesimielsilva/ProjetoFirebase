package com.example.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    private TextView textCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        iniciarComponentes();

        textCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(intent);

            }
        });

    }

    private void iniciarComponentes(){

        textCadastro = findViewById(R.id.text_tela_cadastro);

    }

}