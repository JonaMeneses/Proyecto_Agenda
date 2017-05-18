package com.example.paco.agendacards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button btnGuardar;
    private Button btnCancelar;

    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = (EditText) findViewById(R.id.txt_nombre);
        txtTelefono = (EditText) findViewById(R.id.txt_telefono);
        txtEmail = (EditText) findViewById(R.id.txt_email);

        btnGuardar = (Button) findViewById(R.id.btn_guardar);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);

        btnGuardar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_guardar:
                guardar();
                break;
            case R.id.btn_cancelar:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }

    private void guardar(){
        Intent data = new Intent();
        Contacto contacto = new Contacto();
        contacto.setNombre(txtNombre.getText().toString());
        contacto.setTelefono(txtTelefono.getText().toString());
        contacto.setEmail(txtEmail.getText().toString());
        data.putExtra("CONTACTO",contacto);
        setResult(RESULT_OK,data);
    }

}
