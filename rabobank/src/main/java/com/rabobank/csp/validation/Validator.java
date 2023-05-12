package com.rabobank.csp.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import com.rabobank.csp.entities.Record;
import com.rabobank.csp.exception.ValidationException;

public class Validator {

	
	/**
	 * Check the transaction reference for each record.
	 * 
	 * @param records
	 * @return list of records
	 */
	
	public static List<Record>  validateTransactionReferencesRecords(List <Record> records) throws ValidationException
	{
		List<Record> duplicatesRecords;
		List<Record> duplicatesRecordDetails;
		
		try {
		 duplicatesRecords = records.stream()
        .collect(Collectors.groupingBy(Record::getReference))
        .entrySet()
        .stream()
        .filter(e -> e.getValue().size() > 1)
        .flatMap(e -> e.getValue().stream())
        .collect(Collectors.toList());
		
		
		
		duplicatesRecordDetails = records.stream()
		        .filter(duplicatesRecords::contains)
		        .collect(Collectors.toList());
		
		return duplicatesRecordDetails;
		
		}
		catch (Exception e)
		{
			throw new ValidationException("Kindly check the Transaction Reference values for the records!");
			
		}
		
		
		
	}
	
	/**
	 * Check the End balance = Start Balance + Mutation  for each record.
	 * 
	 * @param records
	 * @return list of records
	 */
	
	public static List<Record> validateEndBalance(List <Record> records)
	{
	
		try {
			return records.stream()
                .filter(record -> {
                    double startBalance = record.getStartBalance();
                    double mutation = record.getMutation();
                    double endBalance = record.getEndBalance();
                    
                    // Calculate the expected end balance with two decimal places precision
                    double expectedEndBalance = BigDecimal.valueOf(startBalance)
                            .add(BigDecimal.valueOf(mutation))
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
                    
                    // Compare the expected end balance with the actual end balance
                    return Double.compare(expectedEndBalance, endBalance) != 0;
                })
                .collect(Collectors.toList());
	}
	catch (Exception e)
	{
		throw new ValidationException("Kindly check the values for the Balances in the records!");
	}
		
		
	}
}
