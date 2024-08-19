package Bai_Tap4;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        String filePath = "newfile.txt";
        File file = new File(filePath);
//        taoj file moi
        try{
            if (file.createNewFile()){
                System.out.println("file da dc tao : "+file.getName());
            }else{
                System.out.println("file da ton tai ");
            }
        }catch (IOException e){
            System.out.println("da xay ra loi khi tao file "+e.getMessage());
        }
//        kiem tra xem file co ton tai hay khong
        if (file.exists()){
            System.out.println("file ton tai ");
        }else{
            System.out.println("file khong ton tai ");
        }
//        kiem tra xem file co phai la thu muc hay khong
        if (file.isDirectory()){
            System.out.println("day la mot thu muc ");
        }else {
            System.out.println("day khong phai la mot thu muc ");
        }
//        hien thi duong dan cua file
        System.out.println("duong dan cua file : "+file.getAbsolutePath());



   }
}