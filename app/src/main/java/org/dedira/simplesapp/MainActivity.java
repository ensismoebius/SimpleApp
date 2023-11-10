package org.dedira.simplesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Informacoes.listaDeContas = new ArrayList<>();
        TextView numero1 = this.findViewById(R.id.txtNum1);
        TextView numero2 = this.findViewById(R.id.txtNum2);
        TextView resultado = this.findViewById(R.id.txtRes);
        Button botaoSoma = this.findViewById(R.id.btnSomar);
        ListView visualizacaoDaLista = this.findViewById(R.id.lstContas);


        Adaptador adaptador = new Adaptador(this, Informacoes.listaDeContas);
        visualizacaoDaLista.setAdapter(adaptador);

        BancoDeDados bd = new BancoDeDados();


        botaoSoma.setOnClickListener(evento -> {
            String valor1 = numero1.getText().toString();
            String valor2 = numero2.getText().toString();

            Float v1 = Float.valueOf(valor1);
            Float v2 = Float.valueOf(valor2);

            Float res = v1 + v2;

            String strResultado = res.toString();

            Informacoes.listaDeContas.add(strResultado);

            resultado.setText(strResultado);

            adaptador.notifyDataSetChanged();
            bd.salvarConta(strResultado);
        });


    }
}