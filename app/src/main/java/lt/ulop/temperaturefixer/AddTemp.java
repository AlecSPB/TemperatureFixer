package lt.ulop.temperaturefixer;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "temperature")
public class AddTemp extends Model {
    public AddTemp(String temperature, Date time, String pill) {
        Temperature = temperature;
        Time = time;
        Pill=pill;
    }

    @Column(name = "Temperature")
    String Temperature;
    @Column(name = "Time")
    Date Time;
    @Column(name = "Pill")
    String Pill;

    public AddTemp() {}
}