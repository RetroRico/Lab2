package com.example.lab2;

public class Result {
    private final double Sy,Sc,W,Sh,Sl,H,r;

    public Result(double Sy,double Sc,double W,double Sh,double Sl,double H,double r){
        this.Sy = Sy;
        this.Sc = Sc;
        this.W = W;
        this.Sh = Sh;
        this.Sl = Sl;
        this.H = H;
        this.r = r;

    }

    public double getSy() {
        return Sy;
    }

    public double getSc() {
        return Sc;
    }

    public double getW() {
        return W;
    }

    public double getSh() {
        return Sh;
    }

    public double getSl() {
        return Sl;
    }

    public double getH() {
        return H;
    }

    public double getR() {
        return r;
    }
}
