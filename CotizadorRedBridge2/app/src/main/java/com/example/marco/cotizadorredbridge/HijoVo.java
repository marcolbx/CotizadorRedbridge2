package com.example.marco.cotizadorredbridge;

public class HijoVo {
    private String edad = "Edad";
    private int años;


    public HijoVo(int años) {
        this.edad = "Edad";
        this.años = años;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
}
