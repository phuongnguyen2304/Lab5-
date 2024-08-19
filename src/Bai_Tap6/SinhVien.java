package Bai_Tap6;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SinhVien {
    private String maSinhVien;
    private String tenSinhVien;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    // Constructor
    public SinhVien(String maSinhVien, String tenSinhVien, double diemToan, double diemLy, double diemHoa) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    // Getter và Setter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    // Phương thức toString() trả về thông tin đầy đủ của sinh viên
    @Override
    public String toString() {
        return maSinhVien + "," + tenSinhVien + "," + diemToan + "," + diemLy + "," + diemHoa;
    }
}

 class FileReadWriteSinhVien {

    // Phương thức lưu đối tượng sinh viên vào file
    public static boolean luuSinhVienVaoFile(SinhVien sv, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(sv.toString() + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + e.getMessage());
            return false;
        }
    }

    // Phương thức đọc dữ liệu sinh viên từ file
    public static SinhVien[] docSinhVienTuFile(String filePath) {
        List<SinhVien> danhSachSinhVien = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    SinhVien sv = new SinhVien(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                    danhSachSinhVien.add(sv);
                }
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }

        if (danhSachSinhVien.isEmpty()) {
            return null;
        }

        return danhSachSinhVien.toArray(new SinhVien[0]);
    }

    public static void main(String[] args) {
        String filePath = "sinhvien.txt";

        // Tạo đối tượng sinh viên
        SinhVien sv1 = new SinhVien("SV001", "Nguyen Van A", 8.5, 7.0, 9.0);
        SinhVien sv2 = new SinhVien("SV002", "Le Thi B", 7.5, 8.0, 7.0);

        // Lưu thông tin sinh viên vào file
        if (luuSinhVienVaoFile(sv1, filePath)) {
            System.out.println("Lưu sinh viên 1 thành công.");
        } else {
            System.out.println("Lưu sinh viên 1 thất bại.");
        }

        if (luuSinhVienVaoFile(sv2, filePath)) {
            System.out.println("Lưu sinh viên 2 thành công.");
        } else {
            System.out.println("Lưu sinh viên 2 thất bại.");
        }

        // Đọc thông tin sinh viên từ file
        SinhVien[] danhSachSinhVien = docSinhVienTuFile(filePath);
        if (danhSachSinhVien != null) {
            System.out.println("Danh sách sinh viên trong file:");
            for (SinhVien sv : danhSachSinhVien) {
                System.out.println(sv);
            }
        } else {
            System.out.println("Không có sinh viên trong file hoặc file trống.");
        }
    }
}
