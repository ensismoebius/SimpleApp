package org.dedira.simplesapp;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {

    private final FirebaseFirestore bd;
    public BancoDeDados(){
        this.bd = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings.Builder carregador = new FirebaseFirestoreSettings.Builder(
                bd.getFirestoreSettings()
        );

        FirebaseFirestoreSettings configuracao = carregador.build();
        bd.setFirestoreSettings(configuracao);
    }

    public void salvarConta(String conta){

        Map<String, String> registro = new HashMap<>();
        registro.put("valor", conta);


        bd.collection("contas").add(registro);
    }
}










