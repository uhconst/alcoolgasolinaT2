package com.uhc.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calcular = findViewById(R.id.btn_calcular);

        final TextView txt_resultado = findViewById(R.id.txt_resultado);


        final EditText edt_alcool = findViewById(R.id.edt_alcool);
        final EditText edt_gasolina = findViewById(R.id.edt_gasolina);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strValorAlcool = edt_alcool.getText().toString();
                String strValorGasolina = edt_gasolina.getText().toString();

                if (strValorAlcool.isEmpty() || strValorGasolina.isEmpty()) {
                    // mensagem erro
                    Toast.makeText(MainActivity.this, "Informe todos os campos!", Toast.LENGTH_LONG).show();

                } else {
                    double vlrAlcool = Double.parseDouble(strValorAlcool);
                    double vlrGasolina = Double.parseDouble(strValorGasolina);

                    double resultado = vlrAlcool / vlrGasolina;

                    if (resultado >= 0.7) {
                        // Compensa gasolina
                        txt_resultado.setText("Compensa Gasolina!");

                    } else {
                        // Compensa alcool
                        txt_resultado.setText("Compensa Alcool!");

                    }
                }
            }
        });
    }
}
