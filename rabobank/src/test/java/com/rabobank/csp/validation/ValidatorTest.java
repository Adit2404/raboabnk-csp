/**
 * 
 */
package com.rabobank.csp.validation;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.rabobank.csp.entities.Record;

/**
 * @author adityabhargava
 *
 */
public class ValidatorTest {

	@Test
	public void testvalidateEndBalance() 
	{
		List <Record> recordList = createTestData();
		
        List<Record> invalidRecords = Validator.validateEndBalance(recordList);

        Assert.assertEquals("Invalid records  found", 2, invalidRecords.size());

		
	}
	
	@Test
	public void testValidateTransactionReferencesRecords() {
		
		List <Record> recordList = createTestData();
        List<Record> duplicates = Validator.validateTransactionReferencesRecords(recordList);

		
		Assert.assertEquals("Two duplicate records should be found", 2, duplicates.size());
        Assert.assertEquals("Duplicate records should match the input", recordList.get(0), duplicates.get(0));
    
		
	}
	
	
	
	private static List<Record> createTestData() {
        List<Record> testData = new ArrayList<>();

        // Create and add records
        testData.add(new Record(143221L, " ",123.49, 18.42,
        		"Subscription for Erik de Vries",62.91));
        testData.add(new Record(111L, "NL69ABNA0433647324",20.49, -18.42,
        		"Subscription for Erik de Vries",2.07));
        testData.add(new Record(null, "NL69ABNA0433647324",-50.00, -2.50,
        		"Subscription for Erik de Vries",-52.50));
        testData.add(new Record(143221L, "NL69ABNA0433647324",100.11, 0.0,
        		"Subscription for Erik de Vries",100.00));
       
        return testData;
    }


}
