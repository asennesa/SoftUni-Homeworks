package Telephony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("\\d+");
        for (String url : this.urls) {
            Matcher m = p.matcher(url);
            if (m.find()) {
                sb.append("Invalid URL!" + System.lineSeparator());
            } else {
                sb.append("Browsing: " + url + "!" + System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[^0-9]+");
        for (String number : this.numbers) {
            Matcher m = p.matcher(number);
            if (m.find()) {
                sb.append("Invalid number!" + System.lineSeparator());
            } else {
                sb.append("Calling... " + number + System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
