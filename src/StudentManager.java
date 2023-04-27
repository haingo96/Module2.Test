import java.util.*;

public class StudentManager {
    private static List<Student> studentList = new ArrayList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> studentList) {
        StudentManager.studentList = studentList;
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input student name:");
        String name = scanner.nextLine();
        System.out.println("Input student age:");
        String age = scanner.nextLine();
        System.out.println("Input student sex:");
        String sex = scanner.nextLine();
        System.out.println("Input student address:");
        String address = scanner.nextLine();
        System.out.println("Input student average point:");
        String averagePoint = scanner.nextLine();
        studentList.add(new Student(name, Integer.parseInt(age), "sex", address, Double.parseDouble(averagePoint)));

        UserInterface.displayMenu();
    }

    public static void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input student id for editing:");
        int inputID;
        boolean idMatchInputId;
        do {
            inputID = Integer.parseInt(scanner.nextLine());
            idMatchInputId = studentList.stream().map(student -> student.getId()).toList().contains(inputID);
            if (!idMatchInputId){
                System.out.println("Id not found \nInput id again");
            }
        }while (!idMatchInputId);

        int finalId = inputID;
        Student studentMatchInputId = studentList.stream().filter(student -> student.getId() == finalId).findFirst().get();

        System.out.println("Input student name:");
        String name = scanner.nextLine();
        System.out.println("Input student age:");
        String age = scanner.nextLine();
        System.out.println("Input student sex:");
        String sex = scanner.nextLine();
        System.out.println("Input student address:");
        String address = scanner.nextLine();
        System.out.println("Input student average point:");
        String averagePoint = scanner.nextLine();

        studentMatchInputId.setName(name);
        studentMatchInputId.setAge(Integer.parseInt(age));
        studentMatchInputId.setSex(sex);
        studentMatchInputId.setAddress(address);
        studentMatchInputId.setAveragePoint(Double.parseDouble(averagePoint));

        UserInterface.displayMenu();
    }

    public static void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input studetn id for removing:");

        int inputID;
        boolean idMatchInputId;
        do {
            inputID = scanner.nextInt();
            idMatchInputId = studentList.stream().map(student -> student.getId()).toList().contains(inputID);
            if (!idMatchInputId){
                System.out.println("Id not found \nInput id again");
            }
        }while (!idMatchInputId);

        int finalId = inputID;
        Student studentMatchInputId = studentList.stream().filter(student -> student.getId() == finalId).findFirst().get();

        System.out.println("Confirm removing this student? y/n");
        String userConfirm = scanner.nextLine();
        if (userConfirm == "y") {
            studentList.remove(studentMatchInputId);
        }

        UserInterface.displayMenu();
    }

    public static void sort() {
        System.out.println("""
                ---- Sắp xếp sinh viên theo điểm trung bình ----
                Chọn chức năng theo số (để tiếp tục)
                1. Sắp xếp điểm trung bình tăng dần
                2. Sắp xếp điểm trung bình giảm dần
                3. Thoát""");
        System.out.print("Chọn chức năng: ");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            studentList.sort((student1, student2) -> Double.compare(student1.getAveragePoint(), student2.getAveragePoint()));
            display();
        }if (userChoice == 2) {
            studentList.sort((student1, student2) -> Double.compare(student2.getAveragePoint(), student1.getAveragePoint()));
            display();
        }

        UserInterface.displayMenu();
    }

    public static void display() {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (index < StudentManager.getStudentList().size()) {
            List<Student> holder = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                if (StudentManager.getStudentList().size() - index == 0) {
                    break;
                }
                holder.add(StudentManager.studentList.get(index));
                index++;
            }
            System.out.println(Arrays.toString(holder.stream().toArray()));
            String userInput = scanner.nextLine();
        }

        UserInterface.displayMenu();
    }
}
