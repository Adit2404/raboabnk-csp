package com.rabobank.csp.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.rabobank.csp.entities.Record;
import com.rabobank.csp.entities.Records;
import com.rabobank.csp.utils.Utility;


/**
 *  Implementation of {@link Parser}
 * 
 * @author adityabhargava
 *
 */
public class XmlParser implements Parser {


	@Override
	public List<Record> readAndTranslate(String file) {
		
		List<Record> recordList = null;	
		try {
			
			File xmlFile = new File(file);
			JAXBContext jaxbContext 	= JAXBContext.newInstance( Records.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Records records = (Records) jaxbUnmarshaller.unmarshal(xmlFile);
	        recordList = records.getRecord();			
	        
	        
		} catch (Exception e) {
			Utility.displayErrorMessage("Kindly check content of the file.");
			System.exit(1);
			}
		return recordList;
	}

}