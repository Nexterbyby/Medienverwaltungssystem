package ch.bbw.Converter;

import ch.bbw.Model.Medium;

import java.io.*;
import java.util.List;
import ch.bbw.App;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Nexterbyby
 * @version 0.0.1 23.06.2021
 * @since 0.0.1 23.06.2021
 *
 * The Main table of the database will be converted into different formats file
 * that will be stored in the users Download folder.
 */
public class Converter {

    public Converter(){

    }

    public void convertToCSV(){
        BufferedWriter bufferedWriter = null;
        try{
            File output = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads" + "\\" + System.currentTimeMillis() + ".txt");
            bufferedWriter = new BufferedWriter(new FileWriter(output));
            List<Medium> mediumList = App.db_manager.getAllMedia();
            String out = "";
            for(Medium m : mediumList){
                out += m.getMedium_id() + ";" +
                        m.getName() + ";" +
                        m.getKaufdatum() + ";"+
                        m.getKaufort().getName() + ";" +
                        m.getPreis() + ";" +
                        m.getSprache().getName() + ";" +
                        m.getVerlag().getName() + ";" +
                        m.getTyp().getName() + ";" +
                        m.getKommentar()
                ;
            }
            bufferedWriter.write(out);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void convertToExcel(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        try{
            // create excel file with sheet
            Sheet medium = workbook.createSheet("Medium");
            OutputStream file = new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads" + "\\" + System.currentTimeMillis() + ".xlsx");
            //set style
            XSSFFont font = workbook.createFont();
            CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setAlignment(HorizontalAlignment.LEFT);
            CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
                headerCellStyle.setBorderBottom(BorderStyle.THIN);
                headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            medium.setColumnWidth(0, 8 * 256);
            medium.setColumnWidth(1, 9 * 256);
            medium.setColumnWidth(2, 40 * 256);
            medium.setColumnWidth(3, 20 * 256);
            medium.setColumnWidth(4, 15 * 256);
            medium.setColumnWidth(5, 9 * 256);
            medium.setColumnWidth(6, 15 * 256);
            medium.setColumnWidth(7, 20 * 256);
            medium.setColumnWidth(8, 9 * 256);
            medium.setColumnWidth(9, 60 * 256);
            // get data from db
            List<Medium> mediumList = App.db_manager.getAllMedia();
            // insert data
            Row row;
            Cell cell;
            Medium m;
            row = medium.createRow(1);
            String [] headersTitels = {"Id", "Name", "Kaufdatum", "Kaufort", "Preis", "Sprache", "Verlag", "Typ", "Kommentar"};
            for(int i = 0; i < 9; i++){
                row.createCell(1+i).setCellValue(headersTitels[i]);
                row.getCell(i+1).setCellStyle(headerCellStyle);
            }
            for(int i = 0; i < mediumList.size(); i++){
                m = mediumList.get(0);
                row = medium.createRow(i+2);
                row.createCell(1).setCellValue(m.getMedium_id());
                row.createCell(2).setCellValue(m.getName());
                row.createCell(3).setCellValue(m.getKaufdatum());
                row.createCell(4).setCellValue(m.getKaufort().getName());
                row.createCell(5).setCellValue(m.getPreis());
                row.createCell(6).setCellValue(m.getSprache().getName());
                row.createCell(7).setCellValue(m.getVerlag().getName());
                row.createCell(8).setCellValue(m.getTyp().getName());
                row.createCell(9).setCellValue(m.getKommentar());
                for(int j = 0; j < 9; j++){
                    row.getCell(j+1).setCellStyle(cellStyle);
                }
            }
            workbook.write(file);
            workbook.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
