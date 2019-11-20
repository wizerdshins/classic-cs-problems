package com.wizerdshins.othertasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {

    private String encode(String str) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            int count = 1;
            while (i + 1 < str.length()
                    && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            if (str.charAt(i) == ' ') {
                continue;
            }
            builder.append(str.charAt(i))
                    .append(count);
        }
        return builder.toString();
    }

    private String decode(String str) {

        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {
                if (count == 0) count = 1;
                while (count > 0) {
                    builder.append(c);
                    count--;
                }
            }
        }
        return builder.reverse().toString();
    }

    private String decodeUsingRegex(String str) {

        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-aZ-z])([0-9]+)"); // format "one letter + some digits"
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            char c = matcher.group(1).charAt(0);
            int count = Integer.parseInt(matcher.group(2));
            for (int i = 0; i < count; i++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {}

}
