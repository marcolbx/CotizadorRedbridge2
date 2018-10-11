package com.example.marco.cotizadorredbridge;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class CotizadorActivity extends AppCompatActivity {

    public static final String EXTRA_EDAD = "com.example.marco.cotizadorredbridge.extra.EDAD";
    public static final String EXTRA_25x1000 = "com.example.marco.cotizadorredbridge.extra.25x1000";
    public static final String EXTRA_25x2500 = "com.example.marco.cotizadorredbridge.extra.25x2500";
    public static final String EXTRA_50x1000 = "com.example.marco.cotizadorredbridge.extra.50x1000";
    public static final String EXTRA_50x2500 = "com.example.marco.cotizadorredbridge.extra.50x2500";
    public static final String EXTRA_100x1000 = "com.example.marco.cotizadorredbridge.extra.100x1000";
    public static final String EXTRA_100x2500 = "com.example.marco.cotizadorredbridge.extra.100x2500";
    public static final String EXTRA_FECHA = "com.example.marco.cotizadorredbridge.extra.FECHA";
    private int edadtitular;

    CotizacionActivity ca;

    public ArrayList<HijoVo> listahijos;

    RecyclerView recyclerHijos;
    AdaptadorHijos adapter;
    Date currentTime;

    private ImageButton buttonInsert;
    private ImageButton buttonDelete;
    private Button buttonCotizar;
    private EditText etEdad;

    private static final String TAG = "CotizadorActivity";
    private TextView mDisplayDate;
    private TextView mTDisplayDate;
    private TextView mCDisplayDate;
    private TextView agetitulartextview;
    private TextView ageconyugueTextView;
    private TextView prueba1;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mTDateSetListener;
    private DatePickerDialog.OnDateSetListener mCDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizador);
        ca = new CotizacionActivity();

        //TextViews
        agetitulartextview = findViewById(R.id.agetitular);
        ageconyugueTextView = findViewById(R.id.ageconyugue);

        //RECYCLER VIEW
        listahijos = new ArrayList<>();
        recyclerHijos = (RecyclerView)findViewById(R.id.recycler);
        recyclerHijos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdaptadorHijos(listahijos,this);
        recyclerHijos.setAdapter(adapter);

        //Buttons
        buttonInsert = findViewById(R.id.button_insert);
        buttonDelete = findViewById(R.id.button_delete);
        buttonCotizar = findViewById(R.id.button_cotizar);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            insertItem();
            }

        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deleteItem();
            }
        });
        buttonCotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ca.reiniciar();
                listahijos= adapter.listaHijos;
                if(agetitulartextview.getText() != ""){
                ca.MPlus25000deducible1000(ca.getEdadTitular());
                ca.MPlus25000deducible2500(ca.getEdadTitular());
                ca.MPlus50000deducible1000(ca.getEdadTitular());
                ca.MPlus50000deducible2500(ca.getEdadTitular());
                ca.MPlus100000deducible1000(ca.getEdadTitular());
                ca.MPlus100000deducible2500(ca.getEdadTitular());}

                if(ageconyugueTextView.getText() != ""){
                ca.MPlus25000deducible1000(ca.getEdadConyugue());
                ca.MPlus25000deducible2500(ca.getEdadConyugue());
                ca.MPlus50000deducible1000(ca.getEdadConyugue());
                ca.MPlus50000deducible2500(ca.getEdadConyugue());
                ca.MPlus100000deducible1000(ca.getEdadConyugue());
                ca.MPlus100000deducible2500(ca.getEdadConyugue());}

               // adapter.editModelArrayList.forEach(EditModel);


                Iterator<HijoVo> nombreIterator = listahijos.iterator();
                while(nombreIterator.hasNext()){
                    HijoVo hijo = nombreIterator.next();
                    ca.MPlus25000deducible1000(hijo.getAños());
                    ca.MPlus25000deducible2500(hijo.getAños());
                    ca.MPlus50000deducible1000(hijo.getAños());
                    ca.MPlus50000deducible2500(hijo.getAños());
                    ca.MPlus100000deducible1000(hijo.getAños());
                    ca.MPlus100000deducible2500(hijo.getAños());
                }



                ca.aplicarCostoEmisionFijo();
                launchCotizacionActivity();
            }
        });

        //CURRENT DATE
        currentTime = Calendar.getInstance().getTime();

        //DATE PICKER Poliza efectiva
        mDisplayDate = (TextView)findViewById(R.id.tvdate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                //ESTOY QUITANDO LA INSTRUCCION DE ARRIBA
                day = 1;

                DatePickerDialog dialog = new DatePickerDialog(
                        CotizadorActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;

                dayOfMonth = 1;
                //ELIMINO LA INSTRUCCION PQ REDBRIDGE NECESITA Q SEA EL PRIMER DIA
                Log.d(TAG,"onDateSet: " + year + "/" + month +"/" + dayOfMonth);
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        //DATE PICKER TITULAR
        mTDisplayDate = (TextView)findViewById(R.id.tvdatetitular);
        mTDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        CotizadorActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mTDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mTDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               month = month + 1;
                Log.d(TAG,"onDateSet: " + year + "/" + month +"/" + dayOfMonth);
                String date = month + "/" + dayOfMonth + "/" + year;
                mTDisplayDate.setText(date);
                month = month -1; //Para la calculadora

                Date dateTitular = new Date(year,month,dayOfMonth);
                int age = calculateAgeWithJava7(dateTitular, currentTime,dayOfMonth);
                edadtitular = age;
                ca.setEdadTitular(age);

                agetitulartextview.setText(Integer.toString(age));
            }
        };

        //DATE PICKER CONYUGUE
        mCDisplayDate = (TextView)findViewById(R.id.tvconyugue);
        mCDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar();
            }
        });

        mCDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG,"onDateSet: " + year + "/" + month +"/" + dayOfMonth);
                String date = month + "/" + dayOfMonth + "/" + year;
                mCDisplayDate.setText(date);
                month = month -1; //Para la calculadora

                Date dateConyugue = new Date(year,month,dayOfMonth);
                int age = calculateAgeWithJava7(dateConyugue, currentTime,dayOfMonth);
                ca.setEdadConyugue(age);

                ageconyugueTextView.setText(Integer.toString(age));
            }
        };

    }


    public int calculateAgeWithJava7(Date birthDate, Date currentDate ,int day) {
        // validate inputs ...
        int d1 = birthDate.getYear()*10000+ ((birthDate.getMonth()+1)*100) + day;
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
       /* int d1 = Integer.parseInt(formatter.format(birthDate));
        agetitulartextview.setText(Integer.toString(d1));*/
        int d2 = Integer.parseInt(formatter.format(currentDate));
        int age = (d2 - d1) / 10000;
        return age;
    }

    public  void insertItem(){
        listahijos.add(new HijoVo(0));
        adapter.notifyDataSetChanged();

    }

    public void deleteItem(){
        if(!listahijos.isEmpty())
        listahijos.remove(listahijos.get(listahijos.size()-1));
        adapter.notifyDataSetChanged();
    }

    public void launchCotizacionActivity(){
        Intent intent = new Intent (this, CotizacionActivity.class);
        String edad = agetitulartextview.getText().toString();
        String casilla1x1 = Integer.toString(ca.totalPrimaMPlus25000x1000);
        String casilla2x1 = Integer.toString(ca.totalPrimaMPlus25000x2500);
        String casilla1x2 = Integer.toString(ca.totalPrimaMPlus50000x1000);
        String casilla2x2 = Integer.toString(ca.totalPrimaMPlus50000x2500);
        String casilla1x3 = Integer.toString(ca.totalPrimaMPlus100000x1000);
        String casilla2x3 = Integer.toString(ca.totalPrimaMPlus100000x2500);
        String fecha = (String) mDisplayDate.getText();
        intent.putExtra(EXTRA_EDAD, edad);
        intent.putExtra(EXTRA_25x1000, casilla1x1);
        intent.putExtra(EXTRA_25x2500,casilla2x1);
        intent.putExtra(EXTRA_50x1000,casilla1x2);
        intent.putExtra(EXTRA_50x2500,casilla2x2);
        intent.putExtra(EXTRA_100x1000,casilla1x3);
        intent.putExtra(EXTRA_100x2500,casilla2x3);
        intent.putExtra(EXTRA_FECHA,fecha);

        startActivity(intent);
    }

    public void calendar(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(
                CotizadorActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mCDateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }



}
