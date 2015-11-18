package lt.ulop.temperaturefixer;

import android.widget.EditText;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "userinfo")
public class UserInfo extends Model {
    public UserInfo(String name, String sureName, String age,String weight, String height) {
        Name = name;
        SureName = sureName;
        Age = age;
        Weight = weight;
        Height = height;
    }
    @Column(name = "Name")
    String Name;
    @Column(name = "SureName")
    String SureName;
    @Column(name = "Age")
    String Age;
    @Column(name = "Weight")
    String Weight;
    @Column(name = "Height")
    String Height;

    public UserInfo(){}

}
