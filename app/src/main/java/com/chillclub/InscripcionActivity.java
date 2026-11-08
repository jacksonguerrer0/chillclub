package com.chillclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InscripcionActivity extends Activity {
    static final String NOMBRE = "nombre";
    static final String CORREO = "correo";
    static final String PUNTO = "punto";
    static final String ACIDA = "acida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);
        findViewById(R.id.confirmar).setOnClickListener(v -> confirmarInscripcion());
    }

    private void confirmarInscripcion() {
        EditText campoNombre = findViewById(R.id.nombre);
        EditText campoCorreo = findViewById(R.id.correo);
        String nombre = campoNombre.getText().toString().trim();
        String correo = campoCorreo.getText().toString().trim();
        if (nombre.isEmpty()) {
            campoNombre.setError(getString(R.string.required));
            campoNombre.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            campoCorreo.setError(getString(R.string.invalid_email));
            campoCorreo.requestFocus();
            return;
        }
        RadioGroup puntos = findViewById(R.id.punto);
        if (puntos.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, R.string.choose_point, Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton punto = findViewById(puntos.getCheckedRadioButtonId());
        CheckBox cubierta = findViewById(R.id.acida);
        Intent siguiente = new Intent(this, AceptacionActivity.class);
        siguiente.putExtra(NOMBRE, nombre);
        siguiente.putExtra(CORREO, correo);
        siguiente.putExtra(PUNTO, punto.getText().toString());
        siguiente.putExtra(ACIDA, cubierta.isChecked());
        startActivity(siguiente);
    }
}
