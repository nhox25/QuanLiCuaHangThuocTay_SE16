/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author chinv
 *
 */
public class Excel {

    public static boolean writeThongKe(ArrayList<HoaDon> students, String fileName) throws IOException {

        if (fileName != null && !fileName.isEmpty()) {

            File file = new File(fileName);

            return writeThongKe(students, file);
        }

        return false;
    }

    public static boolean writeThongKe(ArrayList<HoaDon> hoadon, File file) throws IOException {

        if (file != null) {

            try {

                // Create a new workbook
                HSSFWorkbook workbook = new HSSFWorkbook();

                if (workbook != null) {

                    // Create a new sheet
                    HSSFSheet sheet = workbook.createSheet("Thống Kê");

                    if (sheet != null) {

                        // Create header row
                        Row header = sheet.createRow(0);

                        // Code
                        Cell cell = header.createCell(0);
                        cell.setCellValue("Mã hóa đơn");

                        // Thuốc
                        cell = header.createCell(1);
                        cell.setCellValue("Tên thuốc");

                        // Số
                        cell = header.createCell(2);
                        cell.setCellValue("Số lượng");

                        // Giá
                        cell = header.createCell(3);
                        cell.setCellValue("Giá");
                        // Gender
                        cell = header.createCell(4);
                        cell.setCellValue("Thành tiền");
                        // Gender
                        cell = header.createCell(5);
                        cell.setCellValue("Người bán");
                        // Gender
                        cell = header.createCell(6);
                        cell.setCellValue("Ngày bán");

                        // Create content rows
                        int length = hoadon != null ? hoadon.size() : 0;
                        for (int i = 0; i < length; i++) {

                            HoaDon hd = hoadon.get(i);

                            if (hd != null) {

                                // Create content row
                                Row row = sheet.createRow(i + 1);

                                // Code
                                cell = row.createCell(0);
                                cell.setCellValue(hd.getIdHD());
                                
                                cell = row.createCell(1);
                                cell.setCellValue(hd.getTenSP());
                                
                                cell = row.createCell(2);
                                cell.setCellValue(hd.getSoluong());
                                
                                cell = row.createCell(3);
                                cell.setCellValue(hd.getGia());
                                
                                cell = row.createCell(4);
                                cell.setCellValue(hd.getThanhtien());

                                // FullName
                                cell = row.createCell(5);
                                cell.setCellValue(hd.getUsername());

                                // Time
                                cell = row.createCell(6);
                                cell.setCellValue(formatDatetime(hd.getTime()));

                            }
                        }
                    }

                    FileOutputStream fileOutputStream = new FileOutputStream(file);

                    workbook.write(fileOutputStream);

                    workbook.close();

                    return true;
                }
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return false;
    }
    public static String formatDatetime(java.sql.Date time) {
        if (time == null) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "dd-MM-yyyy");//
            return dateFormat.format(time);
        }
    }
}
