package sg.edu.rp.c346.id20013327.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    TextView viewName;
    TextView viewMobile;
    TextView viewPeople;
    EditText name;
    EditText mobileNum;
    EditText amountOfPeople;
    DatePicker dp;
    TimePicker tp;
    RadioButton rbSmoke;
    Button reserve;
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        mobileNum = findViewById(R.id.editTextMobile);
        amountOfPeople = findViewById(R.id.editTextPeople);
        dp = findViewById(R.id.inputDate);
        tp = findViewById(R.id.inputTime);
        rbSmoke = findViewById(R.id.area);
        reserve = findViewById(R.id.buttonReserve);
        reset = findViewById(R.id.buttonReset);
        viewName = findViewById(R.id.viewName);
        viewMobile = findViewById(R.id.textViewMobile);
        viewPeople = findViewById(R.id.viewTextPeople);




        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = "";
                String who = name.getText().toString();
                String number = mobileNum.getText().toString();
                String amount = amountOfPeople.getText().toString();

                if(rbSmoke.isChecked()) {
                    area += "Smoking area";
                } else {
                    area += "Non-Smoking area";
                }

                String date = dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                String time = "";
                if(tp.getCurrentHour() < 10 && tp.getCurrentMinute() < 10) {
                    time += "0" + String.valueOf(tp.getCurrentHour()) + ":0" + String.valueOf(tp.getCurrentMinute());

                } else if(tp.getCurrentHour() < 10) {
                    time += String.valueOf(tp.getCurrentHour()) + ":" + String.valueOf(tp.getCurrentMinute());

                } else if(tp.getCurrentMinute() > 10) {
                    time += String.valueOf(tp.getCurrentHour()) + ":0" + String.valueOf(tp.getCurrentMinute());

                } else {
                    time += String.valueOf(tp.getCurrentHour()) + ":" + String.valueOf(tp.getCurrentMinute());

                }

                String msg = "Hi " + who + ". Your mobile number is "+ number +  ". You have successfully reserved a " +
                        amount + " person(s) table." + " See you on " + date + ", in the " + area + " table at " + time +".";

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

            }
        });



        reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               name.setText("");
               mobileNum.setText("");
               amountOfPeople.setText("");
               rbSmoke.setChecked(false);
               dp.updateDate(2021,5, 1 );
               tp.setCurrentHour(20); // or tp.setCurrentHour(19) + 1;
               tp.setCurrentMinute(30);
           }
        });


    }
}