import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

class DateDifference {
    public static void main(String[] args) {
        LocalDate firstDate = LocalDate.of(2015, Month.FEBRUARY, 5);
        LocalDate secondDate = LocalDate.of(2000, Month.JULY, 10);

        System.out.println(dateComparison(firstDate, secondDate));
    }

    public static StringBuilder dateComparison(LocalDate firstDate, LocalDate secondDate) {
        StringBuilder result = new StringBuilder();
        Period period = Period.between(firstDate, secondDate);
        long years = Math.abs(period.getYears());
        long months = Math.abs(period.getMonths());
        long days = Math.abs(period.getDays());

        printYears(result, years);
        printMonths(result, months);
        printDays(result, days);

        return result;
    }

    private static void printDays(StringBuilder result, long days) {
        if (days % 100 > 1 && days % 100 < 5) {
            result.append(days).append(" дня");
        } else if (days % 10 == 1) {
            result.append(days).append(" день");
        } else {
            result.append(days).append(" дней");
        }
    }

    private static void printMonths(StringBuilder result, long months) {
        if ((months % 100 > 4 && months % 100 < 21) || months % 100 == 0) {
            result.append(months).append(" месяцев ");
        } else if (months % 10 == 1) {
            result.append(months).append(" месяц ");
        } else if (months % 10 > 1 && months < 5) {
            result.append(months).append(" месяца ");
        }
    }

    private static void printYears(StringBuilder result, long years) {
        if ((years % 100 > 4 && years % 100 < 21) || years % 100 == 0) {
            result.append(years).append(" лет ");
        } else if (years % 10 == 1) {
            result.append(years).append(" год ");
        } else if (years % 10 > 1 && years < 5) {
            result.append(years).append(" года ");
        }
    }
}