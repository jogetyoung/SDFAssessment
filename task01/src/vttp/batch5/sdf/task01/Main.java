package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import javax.swing.text.AbstractDocument;
import vttp.batch5.sdf.task01.models.BikeEntry;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read the CSV file

        String FilePath = "/Users/joel/Downloads/vttp_b5_assessment_template/task01/day.csv";
        Reader reader = new FileReader(FilePath);
        BufferedReader bReader = new BufferedReader(reader);

        List<MyBikeEntry> csvData = new ArrayList<>();

        String line;

        line = bReader.readLine(); // skips the header

        while ((line = bReader.readLine()) != null) {

            MyBikeEntry entry = new MyBikeEntry();

            String[] data = line.split(",");

            for (String entry : data) {
                csvData.add(entry);
            }

        }
        bReader.close();// reader closed

        for (MyBikeEntry entry : csvData) {
            int season = entry.getSeason();
            int weekday = entry.getWeekday();
            int month = entry.getMonth();
            int weather = entry.getWeather();
            boolean holiday = entry.isHoliday();
            int casual = entry.getCasual();
            int registered = entry.getRegistered();
            int total = entry.getTotal(casual, registered);

            System.out.println("The highest (position) recorded number of cyclists was in " + season +
                    "(season), on a " + weekday + "(day) in the month of " + month + ".\n" + "There were a total of "
                    + total
                    + "(total) cyclist." + "The weather was " + weather
                    + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
                    + weekday + "(day) was" + holiday + ".");

            System.out.println("The second highest (position) recorded number of cyclists was in " + season +
                    "(season), on a " + weekday + "(day) in the month of " + month + ".\n" + "There were a total of "
                    + total
                    + "(total) cyclist." + "The weather was " + weather
                    + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
                    + weekday + "(day) was not a holiday.");

            System.out.println("The third highest (position) recorded number of cyclists was in " + season +
                    "(season), on a " + weekday + "(day) in the month of " + month + ".\n" + "There were a total of "
                    + total
                    + "(total) cyclist." + "The weather was " + weather
                    + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
                    + weekday + "(day) was not a holiday.");

            System.out.println("The fourth highest (position) recorded number of cyclists was in " + season +
                    "(season), on a " + weekday + "(day) in the month of " + month + ".\n" + "There were a total of "
                    + total
                    + "(total) cyclist." + "The weather was " + weather
                    + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
                    + weekday + "(day) was not a holiday.");

            System.out.println("The fifth highest (position) recorded number of cyclists was in " + season +
                    "(season), on a " + weekday + "(day) in the month of " + month + ".\n" + "There were a total of "
                    + total
                    + "(total) cyclist." + "The weather was " + weather
                    + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
                    + weekday + "(day) was not a holiday.");
        }
    }
}