package lt.ulop.temperaturefixer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText editName;
    EditText editSurename;
    EditText editHeigth;
    EditText editWeigth;
    EditText editAge;
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userInfo = UserInfo.load(UserInfo.class, 1);

        editName = (EditText)findViewById(R.id.editName);
         editSurename = (EditText)findViewById(R.id.editSurename);
         editHeigth = (EditText)findViewById(R.id.editTall);
         editWeigth = (EditText)findViewById(R.id.editWeight);
         editAge = (EditText)findViewById(R.id.editOld);

        if (userInfo != null){
            editName.setText(userInfo.Name);
            editSurename.setText(userInfo.SureName);
            editHeigth.setText(userInfo.Height);
            editWeigth.setText(userInfo.Weight);
            editAge.setText(userInfo.Age);
        } else userInfo = new  UserInfo();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userInfo.Name = editName.getText().toString();
                userInfo.SureName = editSurename.getText().toString();
                userInfo.Height = editHeigth.getText().toString();
                userInfo.Weight = editWeigth.getText().toString();
                userInfo.Age = editAge.getText().toString();

                userInfo.save();

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Настройки успешно сохранены !", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
