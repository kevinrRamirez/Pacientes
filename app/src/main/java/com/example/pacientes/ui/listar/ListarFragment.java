package com.example.pacientes.ui.listar;

import android.app.AlertDialog;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pacientes.R;

import java.io.File;
import java.util.ArrayList;

import SQL.SQLite;

public class ListarFragment extends Fragment {

    private ListarViewModel listarViewModel;
    ArrayList<String> reg;
    ArrayList<String> imagenes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listarViewModel =
                ViewModelProviders.of(this).get(ListarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listar, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        listarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        ListView l= root.findViewById(R.id.lista) ;
        SQLite sqlite;

        //base de datos
        sqlite = new SQLite(getContext());
        sqlite.abrir();
        Cursor cursor = sqlite.getRegistro();
        reg = sqlite.getPaciente(cursor);
        imagenes = sqlite.getImagenes(cursor);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,reg);
        l.setAdapter(adaptador);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_paciente,null);
                ((TextView)dialogView.findViewById(R.id.dialogPacienteTvDatos)).setText(reg.get(i));
                ImageView iVImagen=dialogView.findViewById(R.id.dialogPacienteIVFoto);
                cargarImagen(imagenes.get(i),iVImagen);
                AlertDialog.Builder dialogo=new AlertDialog.Builder(getContext());
                dialogo.setTitle("Paciente");
                dialogo.setView(dialogView);
                dialogo.setPositiveButton("Aceptar",null);
                dialogo.show();
            }
        });
        return root;
    }

    //cargar imagen
    public void cargarImagen(String imagen, ImageView iv){
        try{
            File filePhoto=new File(imagen);
            Uri uriPhoto = FileProvider.getUriForFile(getContext(),"com.example.pacientes",filePhoto);
            iv.setImageURI(uriPhoto);
        }catch (Exception ex){
            Toast.makeText(getContext(), "Ocurrio un error al cargar la imagen", Toast.LENGTH_SHORT).show();
            Log.d("Cargar Imagen","Error al cargar imagen: "+imagen+"\nMensaje: "+ex.getMessage()+"\nCausa: "+ex.getCause());
        }
    }
}