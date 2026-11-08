package com.chillclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PresentacionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        findViewById(R.id.inscribirme)
                .setOnClickListener(v -> startActivity(new Intent(this, InscripcionActivity.class)));
    }
}
