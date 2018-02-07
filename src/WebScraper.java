import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(final String text){
        String[] arraytext = text.split(" ");
        int wordcount = 0;
        for (int index = 0; index < arraytext.length; index++)
            wordcount++;
        return wordcount;
    }
    public static int countOneWord(final String text, final String word){
        String[] arraytext = text.split(word);
        return arraytext.length -1;
    }

//    public static int uniqueWordCount(final String url)
    public static void main(String[] unused) {
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(countOneWord(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Hamlet"));

    }
}
