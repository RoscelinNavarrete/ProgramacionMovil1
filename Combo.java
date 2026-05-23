///////////Configuracion
<?xml version="1.0" encoding="utf-8"?>

<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.funciones">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Funciones">

        <activity
            android:name=".Combo"
            android:exported="true">

            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>

        </activity>

    </application>

</manifest>

//////////////TextoColor
  package com.example.funciones;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Combo extends Activity {

    Spinner comboNC;
    EditText et1;

    @Override
    protected void onCreate(Bundle b) {

        super.onCreate(b);

        setContentView(R.layout.vista);

        comboNC = findViewById(R.id.comboopciones);
        et1 = findViewById(R.id.textocambio);

        String colores[] = {"Rojo", "Verde", "Azul"};

        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                colores
        );

        ad.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        comboNC.setAdapter(ad);

        comboNC.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        cambiarColor(position);
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {

                    }
                });
    }

    public void cambiarColor(int posicion) {

        switch (posicion) {

            case 0:
                et1.setTextColor(Color.RED);
                break;

            case 1:
                et1.setTextColor(Color.GREEN);
                break;

            case 2:
                et1.setTextColor(Color.BLUE);
                break;
        }
    }
}

/////////////Vista Nueva
<?xml version="1.0" encoding="utf-8"?>

<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:background="#CCCCCC">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Selecciona un color"
        android:textSize="20sp"
        android:paddingBottom="20dp"/>

    <Spinner
        android:id="@+id/comboopciones"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/textocambio"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Escribe aquí"
        android:textSize="24sp"
        android:layout_marginTop="20dp"/>

</LinearLayout>
