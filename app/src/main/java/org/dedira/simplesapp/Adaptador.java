package org.dedira.simplesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<String> {

    public Adaptador(@NonNull Context context, ArrayList<String> lista) {
        super(context, 0, lista);
    }

    public View getView(int posicao, View precarregada, ViewGroup pai){

        String valor = this.getItem(posicao);

        if(precarregada == null){
            precarregada = LayoutInflater.from(this.getContext()).inflate(R.layout.linha, pai, false);
        }

        TextView txt = precarregada.findViewById(R.id.txtItemConta);
        txt.setText(valor);

        return precarregada;
    }
}
