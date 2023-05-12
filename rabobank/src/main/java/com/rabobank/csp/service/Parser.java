package com.rabobank.csp.service;

import java.util.List;

import com.rabobank.csp.entities.Record;



/**
 * Interface for reading and validating file content
 * @author adityabhargava
 *
 */
public interface Parser {

	/**
	 * Method to read and translate each record 
	 * 
	 * @param file
	 * @return
	 */
	List<Record> readAndTranslate(String file);

}
