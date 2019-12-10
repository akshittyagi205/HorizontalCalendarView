package in.akshit.horizontalcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tools {
    public static long getTimeInMillis(String date){
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(date.split("-")[2]),Integer.parseInt(date.split("-")[1])-1,Integer.parseInt(date.split("-")[0]));
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,1);
        c.set(Calendar.SECOND,1);
        c.set(Calendar.MILLISECOND,0);
        return c.getTimeInMillis();
    }
    public static String getFormattedDateToday(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String time = sdf.format(c.getTimeInMillis());
        return time;
    }
}
