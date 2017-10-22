package utils;

import java.util.ArrayList;

public class Alphabets {

    private static ArrayList<Character> englishAlphabet = new ArrayList<>(26);
    private static ArrayList<Character> russianAlphabet = new ArrayList<>(32);


    static {
        for (int i = 0; i < 26; i++) {
            int c = 'a' + i;
            char letter = (char) c;
            englishAlphabet.add(letter);
        }
    }

    static {
        for (int i = 0; i < 32; i++) {
            int c = 'а' + i;
            char letter = (char) c;
            russianAlphabet.add(letter);
        }
    }

    public static ArrayList<Character> getEnglishAlphabet() {
        return englishAlphabet;
    }

    public static ArrayList<Character> getRussianAlphabet() {
        return russianAlphabet;
    }
}
