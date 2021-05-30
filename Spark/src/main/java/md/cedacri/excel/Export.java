package md.cedacri.excel;

import md.cedacri.spark.Domain;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import scala.Tuple2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * This class creates a new excel file
 */
public class Export {
    //Private constructor because this class has only static methods,
    // and you can call them without creating an object of this class
    private Export() {
    }

    /**
     * This method uses <b>Apache Poi</b> to create a new excel file with the name <code>fileName</code>
     * and fills file with a list of domains and their number
     *
     * @param fileName name for our excel file
     * @throws IOException if it is not possible to create a file
     */
    public static void toExcel(String fileName) throws IOException {
        try (Workbook workbook = new HSSFWorkbook()) {
            Domain domain = new Domain();
            Sheet sheet = workbook.createSheet("Domains");
            Sheet topDomainsSheet = workbook.createSheet("Top 10 Domains");

            List<Tuple2<String, Integer>> domains = domain.parseDomain();
            List<Tuple2<String, Integer>> topDomains = domain.topDomains();

            Iterator<Tuple2<String, Integer>> iterator = domains.iterator();
            Iterator<Tuple2<String, Integer>> topDomainIterator = topDomains.iterator();

            int rowIndex = 0;

            //Domains Sheet
            while (iterator.hasNext()) {
                Tuple2<String, Integer> currentData = iterator.next();
                Row row = sheet.createRow(rowIndex++);

                Cell cell0 = row.createCell(0);
                cell0.setCellValue(currentData._1);

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(currentData._2);
            }

            //Top Domains Sheet
            rowIndex = 0;
            while (topDomainIterator.hasNext()) {
                Tuple2<String, Integer> currentData = topDomainIterator.next();
                Row row = topDomainsSheet.createRow(rowIndex++);

                Cell cell0 = row.createCell(0);
                cell0.setCellValue(currentData._1);

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(currentData._2);
            }


            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            System.out.println(fileName + " written successfully");
        }
    }
}
