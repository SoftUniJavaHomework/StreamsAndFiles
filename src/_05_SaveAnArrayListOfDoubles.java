import java.io.*;
import java.util.*;

/**
 * Created by pc on 3/25/2016.
 */
public class _05_SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<Double>();
        Collections.addAll(doubles, 5.5, 2.3, 1.4, 0.9, 5.18, 6.6, 36.9);

        try(ObjectOutputStream destination = new ObjectOutputStream(
                new FileOutputStream("doubles.list"))) {

            destination.writeObject(doubles);
            destination.flush();

            ObjectInputStream source = new ObjectInputStream(
                    new FileInputStream("doubles.list"));

            System.out.println(source.readObject());
            source.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

