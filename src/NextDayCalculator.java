import java.util.Scanner;

public class NextDayCalculator {

    public static int[] nextDay() {

        int toDay[] = new int[3];

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số ngày: ");
        toDay[0] = sc.nextInt();
        System.out.print("Nhập vào số tháng: ");
        toDay[1] = sc.nextInt();
        System.out.print("Nhập vào số năm: ");
        toDay[2] = sc.nextInt();

        while (!validDate(toDay)) {
            System.out.println("Ngày không hợp lệ, nhập lại:");

            System.out.print("Nhập vào số ngày: ");
            toDay[0] = sc.nextInt();
            System.out.print("Nhập vào số tháng: ");
            toDay[1] = sc.nextInt();
            System.out.print("Nhập vào số năm: ");
            toDay[2] = sc.nextInt();
        }

        int nextDay[] = new int[3];

        if (toDay[1] == 12 && toDay[0] == 31) {
            nextDay[2] = toDay[2] + 1;
            nextDay[1] = 1;
            nextDay[0] = 1;
        } else if (toDay[0] == getDaysOfMonth(toDay)) {
            nextDay[2] = toDay[2];
            nextDay[1] = toDay[1] + 1;
            nextDay[0] = 1;
        } else {
            nextDay[2] = toDay[2];
            nextDay[1] = toDay[1];
            nextDay[0] = toDay[0] + 1;
        }
        System.out.println("Ngày hôm sau là: " + nextDay[0] + "/" + nextDay[1] + "/" + nextDay[2]);
        return nextDay;
    }

    public static int getDaysOfMonth(int toDay[]) {

        int result = 0;

        switch (toDay[1]) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                result = 30;
                break;
            case 2:
                boolean isLeapYear = isLeapYear(toDay);
                if (isLeapYear) {
                    result = 29;
                } else {
                    result = 28;
                }
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    private static boolean validDate(int toDay[]) {

        if ((toDay[0] > 0 && toDay[0] <= getDaysOfMonth(toDay)) && (toDay[1] > 0 && toDay[1] <= 12) && toDay[2] > 0) {
            return true;
        } else return false;
    }

    private static boolean isLeapYear(int toDay[]) {
        int year = toDay[3];
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    isLeapYear = true;
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}
