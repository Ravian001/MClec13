package com.example.diatoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, buttonAlert, buttonAlert1, buttonAlertList, buttonMC, buttonCustDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonAlert = findViewById(R.id.button_alert_dialog);
        buttonAlert1 = findViewById(R.id.button_alert_dialog1);
        buttonAlertList = findViewById(R.id.button_alert_dialog_with_list);
        buttonMC = findViewById(R.id.button_alert_dialog_with_mc);
        buttonCustDialog = findViewById(R.id.button_customized_dialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflator= getLayoutInflater();
                View layout = inflator.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.my_toast_viewgroup) );

                TextView text = layout.findViewById(R.id.textView);
                text.setText("Customized Toast");

                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 350);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

            }



        });



        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                build.setMessage("Virus detected on your phone");
                build.setTitle("Virus!");
                build.setCancelable(true);
                build.setPositiveButton("Download", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflator= getLayoutInflater();
                        View layout = inflator.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.my_toast_viewgroup) );

                        TextView text = layout.findViewById(R.id.textView);
                        text.setText("Customized Toast");

                        Toast toast = new Toast(MainActivity.this);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 350);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                    }

                });

                build.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    { dialog.cancel(); }
                });
                AlertDialog alertDialog = build.create();
                alertDialog.show();


            }
        });


    }
}