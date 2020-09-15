import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SourceryAcademyTask {

    public static boolean checkIfDateAndReversedDateAreEqual(String date, String reversedDate) {
        if(date.equals(reversedDate)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String startDate = "2000-01-01";
        String endDate = "2015-01-01";

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<LocalDate> allDates =
                start.datesUntil(end).collect(Collectors.toList());

        int bigestIndexOfTheList = allDates.size() - 1;

        for (int index = 0; index < allDates.size() ; index++) {
            String date = allDates.get(index).toString();
            String numericDate = date.replaceAll("-", "");

            String reversedDate =new StringBuilder(numericDate).reverse().toString();

            if(checkIfDateAndReversedDateAreEqual(numericDate, reversedDate)) {
                LocalDate bonusDate = allDates.get(index);
                System.out.println("Bonus date: " + bonusDate);
            }
        }
    }
}
