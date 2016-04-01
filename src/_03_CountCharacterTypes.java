import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by pc on 3/25/2016.
 */
public class _03_CountCharacterTypes {
    public static void main(String[] args) {
        ArrayList<Character> allVawels = new ArrayList<>();
        Collections.addAll(allVawels, 'a', 'e', 'i', 'o', 'u');
        ArrayList<Character> allMarks = new ArrayList<>();
        Collections.addAll(allMarks, '!', ',', '.', '?');

        int vowels = 0;
        int consonants = 0;
        int marks = 0;

        try (FileReader reader = new FileReader(new File("words.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("count-chars.txt"))) {

            int input = reader.read();
            while (input != -1) {
                char symbol = (char)input;
                if (Character.isLetter(symbol)) {
                    if (allVawels.contains(symbol)) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                } else if (allMarks.contains(symbol)) {
                    marks++;
                }

                input = reader.read();
            }

            writer.write(String.format("Vowels: %d\nConsonants: %d\nPunctuation: %d",
                    vowels,
                    consonants,
                    marks));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
