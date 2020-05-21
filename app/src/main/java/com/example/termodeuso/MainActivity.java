package com.example.termodeuso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.receitasdecodigo.utils.inputMask;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnConfirm = (Button) findViewById(R.id.confirmButton);
        final CheckBox check = (CheckBox) findViewById(R.id.checkboxView);

        final EditText lblName = (EditText) findViewById(R.id.nameInput);
        final EditText lblCpf = (EditText) findViewById(R.id.cpfInput);
        final EditText lblPhone = (EditText) findViewById(R.id.phoneInput);
        final EditText lblEmail = (EditText) findViewById(R.id.emailInput);
        lblCpf.addTextChangedListener(inputMask.mask(lblCpf, inputMask.FORMAT_CPF));
        lblPhone.addTextChangedListener(inputMask.mask(lblPhone, inputMask.FORMAT_PHONE));


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Erro");
                if(lblName.getText().toString().matches("")){
                    builder.setMessage("Por favor, preencha seu nome.");
                }else if(lblCpf.getText().toString().matches("")){
                    builder.setMessage("Por favor, preencha seu CPF.");
                }else if(lblPhone.getText().toString().matches("")){
                    builder.setMessage("Por favor, preencha seu telefone.");
                }else if(lblEmail.getText().toString().matches("")){
                    builder.setMessage("Por favor, preencha seu email.");
                }else if(!check.isChecked()){
                    builder.setMessage("Você precisa concordar com os termos de uso para prosseguir.");
                }else{
                    builder.setTitle("Sucesso");
                    builder.setMessage("Usuário cadastrado com êxito.");
                }

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });



    }
}
