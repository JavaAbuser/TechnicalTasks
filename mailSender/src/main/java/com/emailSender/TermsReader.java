package com.emailSender;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TermsReader {
    public static boolean cyclically;
    public static long period;
    public static void readTerms(String path) {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            char timeChar = 0;
            int timeInt = 0;
            Pattern pattern = Pattern.compile("period:(\\d+)\\w");
            while (line != null) {
                cyclically = (line.contains("cyclically:true"));

                if(line.contains("period")){
                    timeChar = line.charAt(line.length() - 1);
                    Matcher matcher = pattern.matcher(line);
                    if(matcher.find()){
                        timeInt = Integer.parseInt(matcher.group(1));
                    }
                }
                line = reader.readLine();
            }

            switch (timeChar){
                case 'm':
                    period = 60L * timeInt;
                    break;
                case 's':
                    period = timeInt;
                    break;
                case 'h':
                    period = 3600L * timeInt;
                    break;
                case 'd':
                    period = 3600L * 24L * timeInt;
                    break;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
