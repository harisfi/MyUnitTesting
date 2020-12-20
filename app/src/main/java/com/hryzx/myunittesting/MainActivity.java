package com.hryzx.myunittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainViewModel mainViewModel;

    private EditText edtWidth, edtLength, edtHeight;
    private Button btnSave, btnCalcVolume, btnCalcSurfaceArea, btnCalcCircumfence;
    private TextView txResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());

        edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        edtHeight = findViewById(R.id.edt_height);
        txResult = findViewById(R.id.txResult);
        btnSave = findViewById(R.id.btn_save);
        btnCalcVolume = findViewById(R.id.btn_calculate_volume);
        btnCalcSurfaceArea = findViewById(R.id.btn_calculate_surface_area);
        btnCalcCircumfence = findViewById(R.id.btn_calculate_circumfence);

        btnSave.setOnClickListener(this);
        btnCalcVolume.setOnClickListener(this);
        btnCalcSurfaceArea.setOnClickListener(this);
        btnCalcCircumfence.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String width = edtWidth.getText().toString().trim();
        String length = edtLength.getText().toString().trim();
        String height = edtHeight.getText().toString().trim();

        if (TextUtils.isEmpty(width)) {
            edtWidth.setError("Field ini tidak boleh kosong!");
        } else if (TextUtils.isEmpty(length)) {
            edtLength.setError("Field ini tidak boleh kosong!");
        } else if (TextUtils.isEmpty(height)) {
            edtHeight.setError("Field ini tidak boleh kosong!");
        } else {
            double w = Double.parseDouble(width);
            double l = Double.parseDouble(length);
            double h = Double.parseDouble(height);

            switch (v.getId()) {
                case R.id.btn_save:
                    mainViewModel.save(l, w, h);
                    visible();
                    break;
                case R.id.btn_calculate_volume:
                    txResult.setText(String.valueOf(mainViewModel.getVolume()));
                    gone();
                    break;
                case  R.id.btn_calculate_surface_area:
                    txResult.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                    gone();
                    break;
                case R.id.btn_calculate_circumfence:
                    txResult.setText(String.valueOf(mainViewModel.getCircumference()));
                    gone();
                    break;
            }
        }
    }

    private void visible() {
        btnCalcVolume.setVisibility(View.VISIBLE);
        btnCalcSurfaceArea.setVisibility(View.VISIBLE);
        btnCalcCircumfence.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.GONE);
    }

    private void gone() {
        btnCalcVolume.setVisibility(View.GONE);
        btnCalcSurfaceArea.setVisibility(View.GONE);
        btnCalcCircumfence.setVisibility(View.GONE);
        btnSave.setVisibility(View.VISIBLE);
    }
}