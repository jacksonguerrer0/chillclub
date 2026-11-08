package com.chillclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AceptacionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptacion);
        Intent datos = getIntent();
        boolean acida = datos.getBooleanExtra(InscripcionActivity.ACIDA, false);
        TextView resumen = findViewById(R.id.datos);
        resumen.setText(getString(R.string.result,
                datos.getStringExtra(InscripcionActivity.NOMBRE),
                datos.getStringExtra(InscripcionActivity.CORREO),
                datos.getStringExtra(InscripcionActivity.PUNTO),
                getString(acida ? R.string.yes : R.string.no)));
        findViewById(R.id.editar).setOnClickListener(v -> finish());
        findViewById(R.id.salir).setOnClickListener(v -> finishAffinity());
    }
}
