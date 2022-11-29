package util;

import java.time.LocalTime;
import java.util.Random;

public class Generator {
    public static LocalTime genRandomTimeCost(){
        Random random = new Random();
        int hour = random.nextInt(12);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);
        return LocalTime.of(hour,minute,second);
    }
}
