package md.cedacri;

import md.cedacri.excel.Export;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Export.toExcel("report.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
