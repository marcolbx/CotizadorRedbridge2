package com.example.marco.cotizadorredbridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CotizacionActivity extends AppCompatActivity {


    private TextView prueba1;
    private TextView tv25000d1000;
    private TextView tv25000d2500;
    private TextView tv50000d1000;
    private TextView tv50000d2500;
    private TextView tv100000d1000;
    private TextView tv100000d2500;
    private TextView tvFecha;

    public int costoTarifa;



    private int edadTitular = 0;
    private int edadConyugue = 0;
    public int costoEmisionFijo = 35;
    public int totalPrimaMPlus25000x1000 = 0;
    public int totalPrimaMPlus25000x2500 = 0;
    public int totalPrimaMPlus50000x1000 = 0;
    public int totalPrimaMPlus50000x2500 = 0;
    public int totalPrimaMPlus100000x1000 = 0;
    public int totalPrimaMPlus100000x2500 = 0;

    public int getEdadTitular() {
        return edadTitular;
    }

    public void setEdadTitular(int edadTitular) {
        this.edadTitular = edadTitular;
    }

    public int getEdadConyugue() {
        return edadConyugue;
    }

    public void setEdadConyugue(int edadConyugue) {
        this.edadConyugue = edadConyugue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);

        Intent intent = getIntent();

        String casilla1x1 = intent.getStringExtra(CotizadorActivity.EXTRA_25x1000);
        String casilla2x1 = intent.getStringExtra(CotizadorActivity.EXTRA_25x2500);
        String casilla1x2 = intent.getStringExtra(CotizadorActivity.EXTRA_50x1000);
        String casilla2x2 = intent.getStringExtra(CotizadorActivity.EXTRA_50x2500);
        String casilla1x3 = intent.getStringExtra(CotizadorActivity.EXTRA_100x1000);
        String casilla2x3 = intent.getStringExtra(CotizadorActivity.EXTRA_100x2500);
        String fecha = intent.getStringExtra(CotizadorActivity.EXTRA_FECHA);
        tv25000d1000 = findViewById(R.id.tv25x1000);
        tv25000d1000.setText(casilla1x1);
        tv25000d2500 = findViewById(R.id.tv25x2500);
        tv25000d2500.setText(casilla2x1);
        tv50000d1000 = findViewById(R.id.tv50x1000);
        tv50000d1000.setText(casilla1x2);
        tv50000d2500 = findViewById(R.id.tv50x2500);
        tv50000d2500.setText(casilla2x2);
        tv100000d1000 = findViewById(R.id.tv100x1000);
        tv100000d1000.setText(casilla1x3);
        tv100000d2500 = findViewById(R.id.tv100x2500);
        tv100000d2500.setText(casilla2x3);
        tvFecha = findViewById(R.id.tvfecha);
        tvFecha.setText(fecha);


    }

    public void reiniciar(){
        totalPrimaMPlus25000x1000 = 0;
        totalPrimaMPlus25000x2500 = 0;
        totalPrimaMPlus50000x1000 = 0;
        totalPrimaMPlus50000x2500 = 0;
        totalPrimaMPlus100000x1000 = 0;
        totalPrimaMPlus100000x2500 = 0;
    }

    public void aplicarCostoEmisionFijo(){
        totalPrimaMPlus25000x1000 +=costoEmisionFijo;
        totalPrimaMPlus25000x2500 +=costoEmisionFijo;
        totalPrimaMPlus50000x1000 +=costoEmisionFijo;
        totalPrimaMPlus50000x2500 +=costoEmisionFijo;
        totalPrimaMPlus100000x1000 +=costoEmisionFijo;
        totalPrimaMPlus100000x2500 +=costoEmisionFijo;
    }

    public void MPlus25000deducible1000(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus25000x1000+= 81;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus25000x1000+= 163;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus25000x1000+= 325;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus25000x1000+= 366;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus25000x1000+= 406;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus25000x1000+= 431;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus25000x1000+= 456;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus25000x1000+= 570;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus25000x1000+= 683;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus25000x1000+= 886;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus25000x1000+= 1334;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus25000x1000+= 1450;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus25000x1000+= 1567;
       // tv25000d1000.setText(Integer.toString(totalPrimaMPlus25000x1000));
       // else //trigger mensaje
    }

    public void MPlus25000deducible2500(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus25000x2500+= 65;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus25000x2500+= 130;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus25000x2500+= 260;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus25000x2500+= 293;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus25000x2500+= 325;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus25000x2500+= 345;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus25000x2500+= 365;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus25000x2500+= 456;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus25000x2500+= 547;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus25000x2500+= 709;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus25000x2500+= 1067;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus25000x2500+= 1160;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus25000x2500+= 1253;
        // else //trigger mensaje
    }

    public void MPlus50000deducible1000(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus50000x1000+= 108;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus50000x1000+= 217;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus50000x1000+= 434;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus50000x1000+= 488;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus50000x1000+= 542;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus50000x1000+= 575;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus50000x1000+= 608;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus50000x1000+= 760;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus50000x1000+= 911;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus50000x1000+= 1181;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus50000x1000+= 1779;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus50000x1000+= 1934;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus50000x1000+= 2089;
        // else //trigger mensaje
    }

    public void MPlus50000deducible2500(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus50000x2500+=87 ;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus50000x2500+= 173;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus50000x2500+= 347;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus50000x2500+= 390;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus50000x2500+= 434;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus50000x2500+= 460;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus50000x2500+= 487;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus50000x2500+= 608;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus50000x2500+= 729;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus50000x2500+= 945;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus50000x2500+= 1423;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus50000x2500+= 1547;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus50000x2500+= 1671;
        // else //trigger mensaje

    }

    public void MPlus100000deducible1000(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus100000x1000+= 141;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus100000x1000+= 282;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus100000x1000+= 564;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus100000x1000+= 634;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus100000x1000+= 704;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus100000x1000+= 748;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus100000x1000+= 791;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus100000x1000+= 988;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus100000x1000+= 1184;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus100000x1000+= 1535;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus100000x1000+= 2312;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus100000x1000+= 2514;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus100000x1000+= 2716;
        // else //trigger mensaje
    }

    public void MPlus100000deducible2500(int edad){
        if(edad>= 0 && edad <= 9) totalPrimaMPlus100000x2500+= 113;
        else if(edad>= 10 && edad <= 17) totalPrimaMPlus100000x2500+= 225;
        else if(edad>= 18 && edad <= 23) totalPrimaMPlus100000x2500+= 451;
        else if(edad>= 24 && edad <= 29) totalPrimaMPlus100000x2500+= 507;
        else if(edad>= 30 && edad <= 34) totalPrimaMPlus100000x2500+= 564;
        else if(edad>= 35 && edad <= 39) totalPrimaMPlus100000x2500+= 598;
        else if(edad>= 40 && edad <= 44) totalPrimaMPlus100000x2500+= 633;
        else if(edad>= 45 && edad <= 49) totalPrimaMPlus100000x2500+= 790;
        else if(edad>= 50 && edad <= 54) totalPrimaMPlus100000x2500+= 947;
        else if(edad>= 55 && edad <= 59) totalPrimaMPlus100000x2500+= 1228;
        else if(edad>= 60 && edad <= 64) totalPrimaMPlus100000x2500+= 1850;
        else if(edad>= 65 && edad <= 69) totalPrimaMPlus100000x2500+= 2011;
        else if(edad>= 70 && edad <= 74) totalPrimaMPlus100000x2500+= 2173;
        // else //trigger mensaje
    }

}
