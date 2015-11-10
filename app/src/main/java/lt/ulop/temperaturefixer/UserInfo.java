package lt.ulop.temperaturefixer;

/**
 * Created by UlopL on 10.11.2015.
 */
public class UserInfo {
    public UserInfo(String name, String sureName, Integer age, Float weight, Float height) {
        Name = name;
        SureName = sureName;
        Age = age;
        Weight = weight;
        Height = height;
    }

    String Name;
    String SureName;
    Integer Age;
    Float Weight;
    Float Height;
}
