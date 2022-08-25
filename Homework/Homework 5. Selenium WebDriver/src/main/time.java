import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class time {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1996, Calendar.SEPTEMBER, 11);
        DateFormat df = new SimpleDateFormat("dd MMM,yyy", Locale.ENGLISH);
        System.out.println(df.format(calendar.getTime()));
        String dt = df.format(calendar.getTime());
        System.out.println(dt);


    }


}
