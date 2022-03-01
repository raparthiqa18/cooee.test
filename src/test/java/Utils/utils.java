package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class utils {

    //To add days and return the new date in a specific format
    public static String addDate(long numofdays){
        try{
            LocalDate myObj = LocalDate.now(); // Create a date object
            myObj=myObj.plusDays(numofdays);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMMM dd");
            String formattedDate = myObj.format(myFormatObj);
            String[] datearr=formattedDate.split(" ");
            System.out.println(datearr[2] + " " + datearr[1]);
            return datearr[2] + " " + datearr[1];
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //To Add days and return date in forecast date format
    public static String forecastdate(long numofdays){
       try{
           LocalDate myObj = LocalDate.now(); // Create a date object
           myObj=myObj.plusDays(numofdays);
           DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("YYYYMMdd");
           String formattedDate = myObj.format(myFormatObj);
           return formattedDate;
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }
}
