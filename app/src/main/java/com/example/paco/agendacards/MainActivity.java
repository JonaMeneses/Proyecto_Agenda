package com.example.paco.agendacards;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private FloatingActionButton fabAdd;
    private RecyclerView recycler;
    private ContactoAdapter adapter;
    private List<Contacto> dataSet;
    public static int NUEVO = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView)
                findViewById(R.id.recycler_contactos);
        fabAdd = (FloatingActionButton)
                findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(this);

        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager =
                new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        dataSet = getContactos();
        adapter = new ContactoAdapter(dataSet,this);
        recycler.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,NuevoActivity.class);
        startActivityForResult(intent,NUEVO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK &&requestCode == NUEVO){
            Contacto contacto = data.getParcelableExtra("CONTACTO");
            dataSet.add(contacto);
            adapter.notifyDataSetChanged();
        }
    }

    private List<Contacto> getContactos(){
        List<Contacto> list = new ArrayList<>();
        list.add(new Contacto("Ely","2881002302"));
        list.add(new Contacto("Lupis","2881053435"));
        list.add(new Contacto("Norita","2881308509"));
        return list;
    }
}
