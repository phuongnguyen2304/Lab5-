package Bai_Tap3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 class FileReaderExample  {
     public static void main(String[] args) {
         String filePath = "data.txt";
        String  data = "đây là một chuỗi dữ liệu mẫu được lưu vào tệp .  ";

//         ghi dữ liệu vào file
         try (FileWriter writer = new FileWriter(filePath)) {
             writer.write(data);
             System.out.println("dữ liêuj đã được ghi vào file : "+ filePath );


         }catch(IOException e){
             System.out.println("đã xảy ra lỗi khi ghi vào file : "+ e.getMessage());
         }
//         đọc dữ liệu từ file và hiển thị ra màn hình
         try(FileReader reader = new FileReader(filePath)) {
             int character ;
             System.out.println("nội dung trong file : ");
             while((character = reader.read()) != -1){
                 System.out.println((char )character);

             }

         }catch (IOException e ){
             System.out.println("đã xảy ra lỗi khi đọc file : "+e.getMessage());
         }
     }
}
