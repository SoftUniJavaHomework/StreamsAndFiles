import java.io.*;

/**
 * Created by pc on 3/25/2016.
 */
public class _02_ALLCAPITALS {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File("lines.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                output.append(line.toUpperCase() + "\n");
                line = reader.readLine();
            }

            try (PrintWriter writer = new PrintWriter(
                    new FileWriter(
                            new File("lines.txt")))) {
                writer.write(output.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
