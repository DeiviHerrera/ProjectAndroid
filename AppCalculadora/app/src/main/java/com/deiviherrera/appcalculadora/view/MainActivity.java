package com.deiviherrera.appcalculadora.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.deiviherrera.appcalculadora.R;
import com.deiviherrera.appcalculadora.presenter.MainActivityPresenter;
import com.deiviherrera.appcalculadora.presenter.MaintActivityPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private EditText edN1;
    private EditText edN2;
    private TextView tvResul;
    private MainActivityPresenter preserter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edN1 = findViewById(R.id.number1);
        edN2 = findViewById(R.id.number2);
        tvResul = findViewById(R.id.tvResul);

        preserter = new MaintActivityPresenterImpl(this);
    }

    public void suma(View view){
        String n1= edN1.getText().toString();
        String n2=edN2.getText().toString();
        preserter.sumar(n1, n2);
    }

    @Override
    public void showResult(String result) {
    tvResul.setText(result);
    }

    @Override
    public void showError(String error) {

    }
}
