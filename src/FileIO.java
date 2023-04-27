import java.io.*;
import java.util.List;

public class FileIO {
    public static void writeToFile() {
        File file = new File("data\\student.csv");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(StudentManager.getStudentList());
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UserInterface.displayMenu();
    }

    public static void readFromFile() {
        File file = new File("data\\student.csv");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            StudentManager.setStudentList((List<Student>) objectInputStream.readObject());
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        UserInterface.displayMenu();
    }
}
