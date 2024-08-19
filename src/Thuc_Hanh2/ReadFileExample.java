package Thuc_Hanh2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            // Đọc file theo hướng dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ
            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại!");
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                try {
                    sum += Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Dòng không phải là số nguyên: " + line);
                }
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);

        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
