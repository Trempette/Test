package com.example.trempette.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button accept = findViewById(R.id.button);
        final TextView firstname = findViewById(R.id.firstname);
        final TextView lastname = findViewById(R.id.lastname);
        final TextView congrats = findViewById(R.id.congrats);
        final CheckBox checkbox = findViewById(R.id.checkBox1);

        firstname.setEnabled(false);
        lastname.setEnabled(false);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                firstname.setEnabled(isChecked);
                lastname.setEnabled(isChecked);
            }
        });


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean name =(firstname.getText().toString().isEmpty()) || (lastname.getText().toString().isEmpty());
                if (name) {
                    congrats.setText("");
                    Context context = getApplicationContext();
                    CharSequence text;
                    text = getString(R.string.toastnok);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    congrats.setText("Congratulation "+" "+firstname.getText()+" "+lastname.getText());
                }

            }
        });



    }
}
