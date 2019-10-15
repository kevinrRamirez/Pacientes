package com.example.pacientes.ui.modificar;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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
import java.io.IOException;
import java.util.Calendar;

import SQL.SQLite;

public class ModificarFragment extends Fragment {
    Spinner sexo, area, doctor;
    EditText ID, nombre, edad, estatura, fecha,peso;
    Button btnLimpiar, btnModificar, btnBuscar, btnFecha;
    ImageView iVPhoto;
    Uri uriPhoto;
    public SQLite sqlite;
    String a, b, sex, imagen="";
    private int dia, mes,ano;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ModificarViewModel modificarViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        modificarViewModel =
                ViewModelProviders.of(this).get(ModificarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_modificar, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        modificarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ID = root.findViewById(R.id.id_pacienteBuscar);
        area = root.findViewById(R.id.sp_areaIngresoModificar);
        doctor = root.findViewById(R.id.sp_doctorModificar);
        nombre = root.findViewById(R.id.nombreModificar);
        sexo = root.findViewById(R.id.sp_sexoModificar);
        fecha = root.findViewById(R.id.fechaIngresoModificar);
        edad = root.findViewById(R.id.edadModificar);
        peso = root.findViewById(R.id.pesoModificar);
        estatura = root.findViewById(R.id.estaturaModificar);
        iVPhoto = root.findViewById(R.id.ivFotoModificar);

        btnBuscar = root.findViewById(R.id.btnBuscar);
        btnLimpiar = root.findViewById(R.id.btnLimpiar);
        btnModificar = root.findViewById(R.id.btnModificar);
        btnFecha = root.findViewById(R.id.btnDateModificar);


        area.setVisibility(View.INVISIBLE);
        doctor.setVisibility(View.INVISIBLE);
        nombre.setVisibility(View.INVISIBLE);
        sexo.setVisibility(View.INVISIBLE);
        peso.setVisibility(View.INVISIBLE);
        fecha.setVisibility(View.INVISIBLE);
        edad.setVisibility(View.INVISIBLE);
        estatura.setVisibility(View.INVISIBLE);
        iVPhoto.setVisibility(View.GONE);
        btnModificar.setVisibility(View.INVISIBLE);
        btnFecha.setVisibility(View.INVISIBLE);
        sqlite = new SQLite(getContext());
        sqlite.abrir();
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.opciones, android.R.layout.simple_spinner_item);


        area.setAdapter(adapter);
        area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion = String.valueOf(area .getSelectedItemId());
                int op = Integer.parseInt(opcion);
                System.out.println(opcion);
                if (op==0){

                }
                if (op ==1){
                    final ArrayAdapter<CharSequence> adapter1 =
                            ArrayAdapter.createFromResource(
                                    getContext(),
                                    R.array.o1,
                                    android.R.layout.simple_spinner_item);

                    doctor.setAdapter(adapter1);
                    a = adapter.getItem(1).toString();
                    doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(doctor.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op==0){

                            }
                            if (op==1)
                            {
                                b=adapter1.getItem(1).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==2)
                            {
                                b=adapter1.getItem(2).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==3)
                            {
                                b=adapter1.getItem(3).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==4)
                            {
                                b=adapter1.getItem(4).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }//Primera selección
                else if (op ==2){
                    final ArrayAdapter<CharSequence> adapter1 =
                            ArrayAdapter.createFromResource(
                                    getContext(),
                                    R.array.o2, //Aereos
                                    android.R.layout.simple_spinner_item);

                    doctor.setAdapter(adapter1);
                    a = adapter.getItem(2).toString(); //Clasificacion 2 - Aereos
                    doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(doctor.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op==0){

                            }
                            if (op==1)
                            {
                                b=adapter1.getItem(1).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==2)
                            {
                                b=adapter1.getItem(2).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==3)
                            {
                                b=adapter1.getItem(3).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==4)
                            {
                                b=adapter1.getItem(4).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }//Segunda selección
                else if (op ==3){
                    final ArrayAdapter<CharSequence> adapter1 =
                            ArrayAdapter.createFromResource(
                                    getContext(),
                                    R.array.o3, //Terrestres
                                    android.R.layout.simple_spinner_item);

                    doctor.setAdapter(adapter1);
                    a = adapter.getItem(3).toString(); //Clasificacion 3 - Terrestres
                    doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(doctor.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op==0){

                            }
                            if (op==1)
                            {
                                b=adapter1.getItem(1).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==2)
                            {
                                b=adapter1.getItem(2).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==3)
                            {
                                b=adapter1.getItem(3).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==4)
                            {
                                b=adapter1.getItem(4).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }//Tercera selección
                else if (op ==4){
                    final ArrayAdapter<CharSequence> adapter1 =
                            ArrayAdapter.createFromResource(
                                    getContext(),
                                    R.array.o4, //Acuaticos
                                    android.R.layout.simple_spinner_item);

                    doctor.setAdapter(adapter1);
                    a = adapter.getItem(4).toString(); //Clasificacion 4 - Acuaticos
                    doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(doctor.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op==0){

                            }
                            if (op==1)
                            {
                                b=adapter1.getItem(1).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==2)
                            {
                                b=adapter1.getItem(2).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==3)
                            {
                                b=adapter1.getItem(3).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }else if(op==4)
                            {
                                b=adapter1.getItem(4).toString();
                                Toast.makeText(getContext(),a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }//Cuarta selección
                //Spinner de SEXO
                final ArrayAdapter<CharSequence> adapter2 =
                        ArrayAdapter.createFromResource(
                                getContext(),
                                R.array.sx,
                                android.R.layout.simple_spinner_item);
                sexo.setAdapter(adapter2);
                sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String opcion = String.valueOf(sexo.getSelectedItemId());
                        int op = Integer.parseInt(opcion);
                        System.out.println(opcion);
                        if (op == 0){
                            sex = "MACULINO";
                        }else if (op == 1){
                            sex = "FEMENINO";
                        }
                    }
                    //Fin spinner sexo

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btnFecha.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                final Calendar c= Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear , int dayOfMonth) {
                        //     sFecha=Integer.toString(2019-year);
                        fecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },ano,mes,dia);
                datePickerDialog.show();

            }
        });









        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!ID.getText().toString().equals("")) {
                    if (sqlite.getCant(Integer.parseInt(ID.getText().toString())).getCount() == 1) {
                        area.setVisibility(View.VISIBLE);
                        doctor.setVisibility(View.VISIBLE);
                        nombre.setVisibility(View.VISIBLE);
                        sexo.setVisibility(View.VISIBLE);
                        fecha.setVisibility(View.VISIBLE);
                        edad.setVisibility(View.VISIBLE);
                        estatura.setVisibility(View.VISIBLE);
                        peso.setVisibility(View.VISIBLE);
                        iVPhoto.setVisibility(View.VISIBLE);
                        btnModificar.setVisibility(View.VISIBLE);
                        btnFecha.setVisibility(View.VISIBLE);


                        int f = Integer.parseInt(ID.getText().toString());
                        Cursor cursor = sqlite.getCant(f);
                        String g1 = null, g2 = null, g3 = null, g4 = null, g5 = null, g6 = null, g7 = null, g8 = null, g9 = null;
                        if (cursor.moveToFirst()) {
                            do {


                                g1 = cursor.getString(1);
                                g2 = cursor.getString(2);
                                g3 = cursor.getString(3);
                                g4 = cursor.getString(4);
                                g5 = cursor.getString(5);
                                g6 = cursor.getString(6);
                                g7 = cursor.getString(7);
                                g8 = cursor.getString(8);
                                g9 = cursor.getString(9);

                            } while (cursor.moveToNext());
                        }

                        nombre.setText(g3.toString());
                        fecha.setText(g5.toString());
                        edad.setText(g6.toString());
                        estatura.setText(g7.toString());
                        peso.setText(g8.toString());
                        imagen=g9;
                        cargarImagen();

                    } else
                        Toast.makeText(getContext(), "Error: No existe ese ID" +
                                "", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error: No has puesto un ID" +
                            "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Guardar registro
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ID.getText().toString().equals("") &&
                        !nombre.getText().toString().equals("") &&
                        !edad.getText().toString().equals("") &&
                        !estatura.getText().toString().equals("") &&
                        !peso.getText().toString().equals("") &&
                        !peso.getText().toString().equals("") &&
                        !peso.getText().toString().equals("") &&
                        !fecha.getText().toString().equals("") &&
                        !imagen.equals("")) {

                    //dentro de if
                    Toast.makeText(getContext(), a + " " + b + " " +
                            nombre.getText().toString().toUpperCase() + " " +
                            sex + " " +
                            edad.getText().toString().toUpperCase() + " " +
                            peso.getText().toString().toUpperCase() + " " +
                            estatura.getText().toString().toUpperCase() + " " +
                            fecha.getText().toString(), Toast.LENGTH_SHORT).show();
                    sqlite.updatePaciente(
                            Integer.parseInt(ID.getText().toString()),
                            a,
                            b,
                            nombre.getText().toString().toUpperCase(),
                            sex,
                            fecha.getText().toString(),
                            edad.getText().toString().toUpperCase(),
                            estatura.getText().toString().toUpperCase(),
                            peso.getText().toString().toUpperCase(),
                            imagen
                    );

                    //Dentro if agregar registro
                    Toast.makeText(getContext(), "REGISTRO AÑADIDO", Toast.LENGTH_SHORT).show();

                    //Limpiar campos
                    ID.setText("");
                    nombre.setText("");
                    fecha.setText("");
                    edad.setText("");
                    estatura.setText("");
                    peso.setText("");
                    area.setId(0);
                    doctor.setId(0);
                    sexo.setId(0);

                } else {
                    Toast.makeText(getContext(),
                            "Error: no puede haber campos vacios",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;


    }
    //cargar imagen
    public void cargarImagen(){
        try{
            File filePhoto=new File(imagen);
            uriPhoto = FileProvider.getUriForFile(getContext(),"com.example.pacientes",filePhoto);
            iVPhoto.setImageURI(uriPhoto);
        }catch (Exception ex){
            Toast.makeText(getContext(), "Ocurrio un error al cargar la imagen", Toast.LENGTH_SHORT).show();
            Log.d("Cargar Imagen","Error al cargar imagen "+imagen+"\nMensaje: "+ex.getMessage()+"\nCausa: "+ex.getCause());
        }
    }
}