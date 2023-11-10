package com.example.lab2.Service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.example.lab2.Result;

import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalcService extends IntentService {
    private static List<Observer> observers = new ArrayList<>();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CalcService() {
        super("CalculationService");
    }

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String M = intent.getStringExtra("doxid");
        String p = intent.getStringExtra("percent");
        String valut = intent.getStringExtra("valut");

        double cstart;
        double cend;
        if (Objects.equals(valut, "Euro")) {
            cstart = 39.05;
            cend = 38.64;
        } else {
            cstart = 40;
            cend = 37.20;
        }

        double Sy = 12 * Double.parseDouble(M);
        double Sc = Double.parseDouble(p) * Sy;
        double Ci = cstart + (10 * ((cend - cstart) / 12));
        double W = 0;
        for (int i = 1; i <= 12; i++) {
            W += (Double.parseDouble(p) * Double.parseDouble(M)) / Ci;
        }
        double Sh = W * cend;
        double Sl = Sy - Sc;
        double H = Sh + Sl;
        double r = H - Sy;

        Result result = new Result(Sy, Sc, W, Sh, Sl, H, r);
        System.out.println(Sy);
        for (Observer observer : observers) {
            observer.update(null, result);
        }
    }
}
