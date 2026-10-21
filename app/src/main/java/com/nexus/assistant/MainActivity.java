package com.nexus.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(30, 30, 30, 30);
        layout.setBackgroundColor(Color.rgb(5, 5, 5));

        TextView titulo = new TextView(this);
        titulo.setText("N E X U S");
        titulo.setTextSize(34);
        titulo.setTextColor(Color.CYAN);
        titulo.setGravity(Gravity.CENTER);

        TextView subtitulo = new TextView(this);
        subtitulo.setText("SUA INTELIGÊNCIA PESSOAL");
        subtitulo.setTextSize(13);
        subtitulo.setTextColor(Color.WHITE);
        subtitulo.setGravity(Gravity.CENTER);

        EditText entrada = new EditText(this);
        entrada.setHint("Digite um comando...");
        entrada.setTextColor(Color.WHITE);
        entrada.setHintTextColor(Color.GRAY);
        entrada.setSingleLine(true);

        Button executar = new Button(this);
        executar.setText("EXECUTAR");

        executar.setOnClickListener(v -> {
            String comando = entrada.getText().toString().trim();

            if (comando.isEmpty()) {
                Toast.makeText(this,
                    "Digite um comando primeiro!",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                    "Comando recebido: " + comando,
                    Toast.LENGTH_LONG).show();
            }
        });

        layout.addView(titulo);
        layout.addView(subtitulo);

        LinearLayout.LayoutParams campoParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
        campoParams.setMargins(0, 40, 0, 15);

        layout.addView(entrada, campoParams);
        layout.addView(executar);

        setContentView(layout);
    }
}