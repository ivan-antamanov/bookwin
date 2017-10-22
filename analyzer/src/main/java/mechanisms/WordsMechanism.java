package mechanisms;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordsMechanism {

    public void countTop10words(String text) {
        text = text.replaceAll("[!?,\'\":;*#.]", "");
        String[] words = text.split("\\s+");
        HashMap<String, Integer> wordToCountNumber = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();
            wordToCountNumber.putIfAbsent(word, 0);
            if (wordToCountNumber.containsKey(word.toUpperCase())) {
                System.out.println("WOoW!");
            }
            wordToCountNumber.computeIfPresent(word, (key, value) -> ++value);
        }
        Map<String, Integer> sortedWords = sortByValue(wordToCountNumber);

    }

    public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(final Map<K, V> map) { //todo 22.10.2017 Analysis of method
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet()); //many entries
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
