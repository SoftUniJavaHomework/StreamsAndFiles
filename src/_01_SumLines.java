import java.io.*;

/**
 * Created by pc on 3/25/2016.
 */
public class _01_SumLines {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File("lines.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
