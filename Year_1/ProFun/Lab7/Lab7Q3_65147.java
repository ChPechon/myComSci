public class Lab7Q3_65147 {
    static void numDaysFromDate(int date, int month, int year, int myBD) {
        int daysBornTil31Dec2021 = 0;
        int fullDays = (2021 - (year - 1)) * 365; // set number of day (19 year * 365 days)
        int remainDays = 0;
        int [] monthNum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // set number of months
        
        for (int i = year; i < 2021; i++) //check leap years
        {
            if (i % 4 == 0)
                fullDays += 1; //add 1 more day for leap years
        }
        
        remainDays += date; // add input days
        for (int i = (month - 1); i > 0; i--) // add days of month exclude input month
            remainDays += monthNum[i - 1];
        
        daysBornTil31Dec2021 = fullDays - remainDays;
        int daysBornTil2Jan2022 = daysBornTil31Dec2021 + 2; // shift to Sunday Jan 02 2022
        String str = showResult(date, month, year, myBD, daysBornTil2Jan2022);
        System.out.println(str);
    }
    
    static String showResult(int date, int month, int year, int myBD, int fromNumDaysFromDate) {
        String[] dayName = { "Sunday", "Monday", "Tuesday", "Wednesday",
         "Thursday", "Friday", "Saturday" };
        int dayFromSun = 0;
        int modResult = fromNumDaysFromDate % 7;
        /* your code */
        String str = String.format("You were born on %s and have been born for %d days (2 Jan 2022).Your program says %s", dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);
        return str;
    }
    
    public static void main(String []args) {
        numDaysFromDate(28, 8, 2003, 4);
    }
}
