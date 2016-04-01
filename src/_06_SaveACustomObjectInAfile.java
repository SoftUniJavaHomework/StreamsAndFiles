import java.io.*;

/**
 * Created by pc on 3/25/2016.
 */
public class _06_SaveACustomObjectInAfile {
    public static void main(String[] args) {
        Course course = new Course() {{
            name = "Java";
            numberOfStudents = 200;
        }};

        try(ObjectOutputStream destination = new ObjectOutputStream(
                new FileOutputStream("course.save"))) {

            ObjectInputStream source = new ObjectInputStream(
                    new FileInputStream("course.save"));

            destination.writeObject(course);
            Course readerObject = (Course)source.readObject();
            System.out.println(readerObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Course implements Serializable {
        String name;
        int numberOfStudents;

        public String toString() {
            return " course: " + this.name + ", number of students: " + this.numberOfStudents;
        }
    }
}