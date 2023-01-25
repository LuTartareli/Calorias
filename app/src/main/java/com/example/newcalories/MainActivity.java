package com.example.newcalories;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3;
    private Spinner sp1;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        sp1=(Spinner)findViewById(R.id.sp1);
        tv3=(TextView)findViewById(R.id.tv3);

        String[] opcoes={"Ml/Grama","Litro/Kg"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,opcoes);

        sp1.setAdapter(adapter);

    }

    public void calcular(View view){
        double MlGrama, LKG;
        String select;

        select=sp1.getSelectedItem().toString();

        if(et1.getText().toString().equals("")){
            et1.setError("Preencha o campo");
        }
        else if(et2.getText().toString().equals("")){
            et2.setError("Preencha o campo");
        }
        else if(et3.getText().toString().equals("")){
            et3.setError("Preencha o campo");
        }else{

        if(select.equals("Ml/Grama")){
            MlGrama = (parseDouble(et1.getText().toString()) / parseDouble(et2.getText().toString())) * parseDouble(et3.getText().toString());
            DecimalFormat df = new DecimalFormat(".00");

            tv3.setText("O resultado é: "+df.format(MlGrama));
        }else{
            if(select.equals("Litro/Kg")){
                LKG=((parseDouble(et1.getText().toString()) * 1000) / parseDouble(et2.getText().toString())) * parseDouble(et3.getText().toString());
                DecimalFormat df = new DecimalFormat(".00");

                tv3.setText("O resultado é: "+df.format(LKG));
            }
        }

    }
}

}
