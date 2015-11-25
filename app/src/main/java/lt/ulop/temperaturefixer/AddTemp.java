package lt.ulop.temperaturefixer;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "temperature")
public class AddTemp extends Model {
    public AddTemp(String temperature, String time, String pill) {
        Temperature = temperature;
        Time = time;
        Pill=pill;
    }

    @Column(name = "Temperature")
    String Temperature;
    @Column(name = "Time")
    String Time;
    @Column(name = "Pill")
    String Pill;

    public AddTemp() {}
}