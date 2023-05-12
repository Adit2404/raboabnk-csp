/**
 * 
 */
package com.rabobank.csp.main;

import java.util.ArrayList;
import java.util.List;

import com.rabobank.csp.entities.Record;
import com.rabobank.csp.exception.InvalidCSVException;
import com.rabobank.csp.exception.InvalidFileTypeException;
import com.rabobank.csp.exception.ValidationException;
import com.rabobank.csp.service.ParserFactory;
import com.rabobank.csp.service.Parser;
import com.rabobank.csp.utils.Utility;
import com.rabobank.csp.validation.Validator;

/**
 * Main class 
 * @author adityabhargava
 *
 */
public class CustomerStatementProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length < 1) {
            System.out.println("Please provide the CSV or XML.");
            return;
        }
		
		 String file = args[0];
		 
		 file = Utility.getFilePath(file);
		 	
		
		  if (!Utility.isFileAllowed(file))
		  {
		try { 	
			  throw new InvalidFileTypeException(
						String.format("Invalid File Format. Kindly pass .csv or .xml", file));

		  }
		 
		 catch(InvalidFileTypeException ex)
		 {
			 Utility.displayErrorMessage(ex.getMessage());
			 return ;
		 }
		  }
		 
			  readAndValidate(file); 

		  
			  
		
	}
	
	

	/**
	 * This method reads and validates collection of record
	 * 
	 * @param filename
	 */
	
	public static void readAndValidate(String file) {
		
		Parser Parser = ParserFactory.createParser(file);
		
		
		try {
			List<Record> records = Parser.readAndTranslate(file);
			
			List<Record> duplicateRecords = new ArrayList<>();
			
			duplicateRecords.addAll(Validator.validateTransactionReferencesRecords(records));
			
			System.out.println("Duplicate Transaction Reference  \n");
			
			System.out.println("Transaction Reference   :" + "Description");
			
			duplicateRecords.stream().forEach
			(r -> System.out.println(r.getReference() + " \t\t\t:" + r.getDescription()));
			
			System.out.println("---------------------------------------------------------  \n");
			
			duplicateRecords = new ArrayList<>();
			
			duplicateRecords.addAll(Validator.validateEndBalance(records));
			
			System.out.println("Invalid End Balance Transaction Reference  \n");

			System.out.println("Transaction Reference   :" + "Description");
			
			duplicateRecords.stream().forEach
			(r -> System.out.println(r.getReference() + " \t\t\t:" + r.getDescription()));

		}
		catch(ValidationException | InvalidCSVException ex)
		{
			Utility.displayErrorMessage(ex.getMessage());
		} 
		
		
		
		
	}

}
