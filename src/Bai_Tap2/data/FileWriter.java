package Bai_Tap2.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 class FileWriterExample   {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String data = "Chào mừng bạn đến với Java FileWriter!";

        // Ghi dữ liệu vào file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            System.out.println("Dữ liệu đã được ghi vào file: " + filePath);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + e.getMessage());
        }

        // Đọc dữ liệu từ file và hiển thị ra màn hình
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.println("Nội dung trong file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
    }

}
