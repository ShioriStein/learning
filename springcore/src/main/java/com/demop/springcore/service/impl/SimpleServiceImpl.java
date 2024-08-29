package com.demop.springcore.service.impl;

import com.demop.springcore.service.SimpleService;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleServiceImpl implements SimpleService {
    @Override
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream()))) {
            String[] header = {"Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks"};
            writer.writeNext(header);
            Long count = 0L;
            while (count < 10000000) {
                for (int i = 0; i < 10000; i++) {
                    writer.writeNext(new String[]{"test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "markEnds" + (count + i)});
                }
                count += 10000;
                Thread.sleep(10);
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error in exportCSV");
        }
    }

    @Override
    public void exportWholeCSV(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/csv");
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(res.getOutputStream()))) {
            String[] header = {"Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks", "Name", "Class", "Marks"};
            List<String[]> rowData = new ArrayList<String[]>();
            ;
            writer.writeNext(header);
            Long count = 0L;
            while (count < 1000000000) {
                for (int i = 0; i < 1000; i++) {
                    rowData.add(new String[]{"test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "marks" + (count + i), "test" + (count + i), "class" + (count + i), "markEnds" + (count + i)});
                }
                count += 10000;
            }
            rowData.forEach(writer::writeNext);
        } catch (Exception ex) {
            System.out.println("Error in exportCSV");
        }
    }


}
