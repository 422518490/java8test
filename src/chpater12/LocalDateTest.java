package chpater12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/9/4
 * @description
 */
public class LocalDateTest {

    public static void main(String [] args){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date = LocalDate.of(2014, 3, 18);
        String formattedDate = date.format(dateTimeFormatter);
        System.out.println(formattedDate);
        LocalDate localDate1 = LocalDate.parse(formattedDate,dateTimeFormatter);
        System.out.println(localDate1);
    }

}
