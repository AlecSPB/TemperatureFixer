package lt.ulop.temperaturefixer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddEvent extends AppCompatActivity {
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTemp addTemp = new AddTemp();

                addTemp.Temperature = editTemperature.getText().toString();
                addTemp.Time = editTime.getText().toString();
                addTemp.Pill = editPill.getText().toString();

                addTemp.save();
                finish();
            }
        });
    }

}
