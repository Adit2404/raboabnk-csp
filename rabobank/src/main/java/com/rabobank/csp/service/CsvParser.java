package com.rabobank.csp.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.rabobank.csp.entities.Record;
import com.rabobank.csp.exception.InvalidCSVException;
import com.rabobank.csp.utils.Utility;

/**
 * Implementation of {@link Parser}
 * 
 * @author adityabhargava
 *
 */
public class CsvParser implements Parser {

	
	@Override
	public List<Record> readAndTranslate(String file) {

		List<Record> recordList = new ArrayList<>();
		
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			
            List<String[]> records = reader.readAll();
            

            for (int i = 1; i < records.size(); i++) {
                String[] recordTemp = records.get(i);
            	
                if(recordTemp.length == 6) {
                	
                	Record record = new Record();
                	
                	record.setReference(Utility.validateAndConvertTransactionReference(recordTemp[0]));
                	record.setAccountNumber(recordTemp[1]);
                	record.setDescription(recordTemp[2]);
                	record.setStartBalance(Double.parseDouble(recordTemp[3]));
                	record.setMutation(Double.parseDouble(recordTemp[4]));
                	record.setEndBalance(Double.parseDouble(recordTemp[5]));
                	recordList.add(record);
                	
                } 
            
            else {
                	throw new InvalidCSVException(String.format("Invalid CSV. Kindly check the records \n"));
                }
            }
            
           
                   }
		catch (IOException |CsvException | InvalidCSVException e)
		{
			
           Utility.displayErrorMessage(e.getMessage());
           System.exit(1);
           
        } 
		
		 return recordList;

		
	}

}
