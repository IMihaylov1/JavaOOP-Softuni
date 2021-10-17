package smartphone;

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


    public List<String> getNumbers() {
        return this.numbers;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            if (isUrlValid(url)) {
                stringBuilder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }


    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            if (isNumberValid(number)) {
                stringBuilder.append("Calling... ").append(number);
            } else {
                stringBuilder.append("Invalid number!");
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }


    private boolean isNumberValid(String number) {
        Pattern pattern = Pattern.compile("^[\\d]+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    private boolean isUrlValid(String url){
        Pattern pattern = Pattern.compile("^[\\D]+$");
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
