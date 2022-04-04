import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = "1990-01-01";
        String str2 = "2020-09-08";
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str1);
        int dates = (int)((date1.getTime() - date2.getTime())/(1000*60*60*24) + 1);
        switch(dates/5){
            case 0:
                System.out.println("晒网");
                break;
            case 1:
                System.out.println("打鱼");
                break;
            case 2:
                System.out.println("打鱼");
                break;
            case 3:
                System.out.println("打鱼");
                break;
            case 4:
                System.out.println("晒网");
                break;
        }
    }
}
