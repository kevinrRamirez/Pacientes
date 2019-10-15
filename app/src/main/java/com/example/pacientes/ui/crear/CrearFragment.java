package com.example.pacientes.ui.crear;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import SQL.SQLite;

public class CrearFragment extends Fragment {

    private CrearViewModel createViewModel;
    private int dia, mes,ano;

    //Constantes
    public static final int REQUEST_TAKE_PHOTO = 1;

    //Variables globales
    Spinner area, doctor, sexo;
    EditText nombre, edad, estatura, fecha, id, peso;
    String a,b,sex,imagen="",currentPhotoPath;
    Button btnGuardar, btnLimpiar, btnFecha;
    ImageView iVFoto;
    Uri photoURI;
    public SQLite sqlite;





    //Esto ya estaba
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createViewModel =
                ViewModelProviders.of(this).get(CrearViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        createViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //Enlazamos la interfaz con el modelo
         area= root.findViewById(R.id.spAreaIngresoCrear);
        doctor = root.findViewById(R.id.spDoctorCrear);
        sexo = root.findViewById(R.id.sp_sexo);
        id= root.findViewById(R.id.idPacienteCrear);
        nombre = root.findViewById(R.id.nombrePacienteCrear);
        fecha = root.findViewById(R.id.fechaIngresoCrear);
        edad = root.findViewById(R.id.edadPacienteCrear);
        estatura = root.findViewById(R.id.estaturaPacienteCrear );
        peso = root.findViewById(R.id.pesoPacienteCrear);
        btnGuardar =root.findViewById(R.id.btn_crear_guardar);
        btnLimpiar =root.findViewById(R.id.btn_crear_limpiar);
        btnFecha = root.findViewById(R.id.btnDateCrear);
        iVFoto = root.findViewById(R.id.ivFotoCrear);

        //conexion con base de datos
        sqlite = new SQLite(getContext());
        sqlite.abrir();
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),R.array.opciones,
                android.R.layout.simple_spinner_item
        );
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

        // datepicker

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

        //Tomar fotografia
        iVFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tomarfoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Se comprueba que se encontro una actividad para genera la foto
                if(tomarfoto.resolveActivity(getActivity().getPackageManager())!=null){
                    //se crea el archivo donde se guardara la imagen
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex){
                        Toast.makeText(getContext(), "Ocurrio un error mientras se generaba el archivo", Toast.LENGTH_SHORT).show();
                    }
                    //se comprueba que la imagen fue creada correctamente
                    if(photoFile != null){
                        photoURI = FileProvider.getUriForFile(getContext(),"com.example.pacientes",photoFile);
                        tomarfoto.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(tomarfoto,REQUEST_TAKE_PHOTO);
                    }
                }
            }
        });

        //Guardar registro
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( !id.getText().toString().equals("") &&
                        !nombre.getText().toString().equals("") &&
                        !edad.getText().toString().equals("") &&
                        !estatura.getText().toString().equals("") &&
                        !peso.getText().toString().equals("") &&
                        !fecha.getText().toString().equals("") &&
                        !imagen.equals("")){
                    //dentro de if
                    Toast.makeText(getContext(), a+" "+b+" "+
                            nombre.getText().toString().toUpperCase()+" "+
                            sex+" "+
                            edad.getText().toString().toUpperCase()+" "+
                            peso.getText().toString().toUpperCase()+" "+
                            estatura.getText().toString().toUpperCase()+" "+
                            fecha.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (sqlite.addregistroPaciente(
                            Integer.parseInt(id.getText().toString()),
                            a,
                            b,
                            nombre.getText().toString().toUpperCase(),
                            sex,
                            fecha.getText().toString(),
                            edad.getText().toString().toUpperCase(),
                            estatura.getText().toString().toUpperCase(),
                            peso.getText().toString().toUpperCase(),
                            imagen
                            )){
                        //Dentro if agregar registro
                        Toast.makeText(getContext(), "REGISTRO AÑADIDO",Toast.LENGTH_SHORT).show();

                        //Limpiar campos
                        id.setText("");
                        nombre.setText("");
                        fecha.setText("");
                        edad.setText("");
                        estatura.setText("");
                        peso.setText("");
                        area.setId(0);
                        doctor.setId(0);
                        sexo.setId(0);
                    }else{
                        Toast.makeText(getContext(),
                                "Error: compruebe que los datos sean correctos",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(),
                            "Error: no puede haber campos vacios",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    //Crear archivo de imagen
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Obtener foto y mostrarla en el imageView

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK){
            iVFoto.setImageURI(photoURI);
            imagen=currentPhotoPath;
            Toast.makeText(getContext(), "Foto guardada en "+ imagen, Toast.LENGTH_SHORT).show();
        }
    }
}