package Bai_Tap5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {
//    phuong thuc de doc du lieu tu file
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(fileName )){
            int character ;
            while((character = reader.read()) != -1){
                content.append((char)character);
            }
        }catch(IOException e){
            System.out.println("da xay ra loi khi doc file : "+e.getMessage());
        }
        return content.toString();
    }
//    phuong thuc de ghi du lieu vao file
    public static boolean writeFile(String filePath , String data ){
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(data );
           return true;
        }catch (IOException e){
            System.out.println("da xay ra loi khi doc file : "+e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String filePath = "data.txt ";
        String dataToWrite = "day la noi dung se dc ghi vao file . ";
//        ghi du lieu vao file
        boolean isWriteSuccessful  = writeFile(filePath,dataToWrite);
        if(isWriteSuccessful){
            System.out.println("ghi du lieu vao file thanh cong ");
        }else{
            System.out.println("ghi du lieu vao file that bai ");
        }
//        doc du lieu tu file
        String fileContent = readFile(filePath);
        if (!fileContent.isEmpty()){
            System.out.println("noi dung da doc tu file ");
            System.out.println(fileContent);

        }


    else{
        System.out.println("k co du lieu de doc hoac file trong ");
    }
}
}
