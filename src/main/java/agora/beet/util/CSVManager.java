package agora.beet.util;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan C. Alonso
 */
public class CSVManager {

    public static List<List<String>> readCSV(String path, Boolean includeFirstRow, char delimiter) {
        List<List<String>> rows = readCSV(path, delimiter);
        if (!includeFirstRow)
            rows.remove(0);
        return rows;
    }

    public static List<String> readValues(String path) {
        List<String> values = new ArrayList<String>();

        Reader in;
        try {
            in = new FileReader(path);

            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            for (CSVRecord record : records)
                values.add(record.get(0));

        }catch (IOException ex) {
            System.err.println("Error parsing CSV file: {}" + path);
            System.err.println("Exception " + ex);
        }

        return values;
    }

    public static List<List<String>> readCSV(String path, char delimiter) {
        List<List<String>> rows = new ArrayList<>();

        Reader in;
        try {
            in = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter(delimiter).parse(in);
            for (CSVRecord record : records) {
                List<String> currentRow = new ArrayList<>();
                for (String field: record)
                    currentRow.add(field);
                rows.add(currentRow);
            }
        } catch (IOException ex) {
            System.err.println("Error parsing CSV file: {}" + path);
            System.err.println("Exception " + ex);
        }

        return rows;
    }

    public static CSVRecord getCSVRecord(String line) {
        CSVRecord res = null;
        try {
            List<CSVRecord> csvRecords =  CSVParser.parse(line, CSVFormat.EXCEL).getRecords();
            if(csvRecords.size() != 1) {
                throw new IndexOutOfBoundsException("Each line should contain only one record");
            }
            res = csvRecords.get(0);
        } catch (IOException e) {
            System.err.println("Error parsing CSV file");
            System.err.println("Exception " + e);
        }
        return res;
    }

    public static void createCSVwithHeader(String path, String header) {
        FileManager.deleteFile(path); // delete file if it exists
        FileManager.createFileIfNotExists(path);
        writeCSVRow(path, header);
    }

    public static void writeCSVRow(String path, String row) {
        File csvFile = new File(path);
        try(FileOutputStream oCsvFile = new FileOutputStream(csvFile, true)) {
            row += "\n";
            oCsvFile.write(row.getBytes());
        } catch (IOException e) {
            System.err.println("The line could not be written to the CSV: " + path);
            System.err.println("Exception: " + e);
        }

    }



}
