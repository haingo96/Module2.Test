import java.util.Scanner;

public class UserInterface {
    public static void displayMenu() {
        System.out.println("""
                ---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----
                Chọn chức năng theo số (để tiếp tục)
                1. Xem danh sách sinh viên
                2. Thêm mới
                3. Cập nhật
                4. Xóa
                5. Sắp xếp
                6. Đọc từ file
                7. Ghi vào file
                8. Thoát""");

        chooseFromMenu();
    }

    public static void chooseFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> StudentManager.display();
            case 2 -> StudentManager.add();
            case 3 -> StudentManager.update();
            case 4 -> StudentManager.remove();
            case 5 -> StudentManager.sort();
            case 6 -> FileIO.readFromFile();
            case 7 -> FileIO.writeToFile();
        }
    }
}
