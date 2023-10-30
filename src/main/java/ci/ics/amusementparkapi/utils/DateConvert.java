package ci.ics.amusementparkapi.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConvert {

    public static String getStringDate(LocalDateTime dateTime){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);

    }
}
