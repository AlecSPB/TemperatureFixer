package lt.ulop.temperaturefixer;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEvent extends AppCompatActivity implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    EditText editTemperature;
    EditText editTime;
    EditText editPill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        editTemperature = (EditText)findViewById(R.id.editTemperature);
        editTime = (EditText)findViewById(R.id.editTime);

        editPill = (EditText)findViewById(R.id.editPill);

        editTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            AddEvent.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "");
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTemp addTemp = new AddTemp();

                addTemp.Temperature = editTemperature.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                try {
                    addTemp.Time = dateFormat.parse(editTime.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                addTemp.Pill = editPill.getText().toString();

                addTemp.save();
                finish();
            }
        });
    }

    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String value = "";
        if(dayOfMonth < 9) value += "0";
        value += dayOfMonth + "-";
        if (monthOfYear < 9) value += "0";
        value += monthOfYear + "-" + year;
        editTime.setText(value);
        Date date = new Date();
        TimePickerDialog pickerDialog = TimePickerDialog.newInstance(AddEvent.this, date.getHours(), date.getMinutes(), true);
        pickerDialog.show(getFragmentManager(), "");
    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String value = " ";
        if(hourOfDay < 9) value += "0";
        value += hourOfDay + ":";
        if (minute < 9) value += "0";
        value += minute;
        editTime.setText(editTime.getText().toString() + value);
    }
}
