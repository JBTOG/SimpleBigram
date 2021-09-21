import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Util {

    private String text;
    private List<String> bigrams;
    private List<String> wordsInOrder;
    private Map<String, Integer> histogram;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void loadTextFileToString(String fileName){
        try {
            setText("");
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                text += data;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        cleanUpString();
    }

    private void cleanUpString(){
        text = getText().replaceAll("\\p{Punct}", "").toLowerCase();
    }

    public void getWords(String text) {
        wordsInOrder = Arrays.asList(text.split(" "));
    }

    public void createBigrams(){
        String s;
        bigrams = new ArrayList();

        for (int i = 0; i < wordsInOrder.size(); i++) {
            if (i == wordsInOrder.size()-1) {
                break;
            }
            s = wordsInOrder.get(i);
            s += " " + wordsInOrder.get(i+1);
            bigrams.add(s);
        }

//        System.out.println(bigrams.size());
//        for (String a: bigrams) {
//            System.out.println(a);
//        }
    }


    public void populateHistrogram(){
        histogram = new HashMap<>();
        for (String bigram:bigrams){
            if(histogram.containsKey(bigram)){
                histogram.put(bigram, histogram.get(bigram) + 1);
            } else {
                histogram.put(bigram, 1);
            }
        }

        printMap(histogram);
    }


    public <K, V> void printMap(Map<K, V> map) {
        map.forEach((key, value) -> System.out.println("\"" + key + "\" " + value));
    }
}
