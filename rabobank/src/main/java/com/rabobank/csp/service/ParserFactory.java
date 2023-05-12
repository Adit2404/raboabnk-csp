package com.rabobank.csp.service;

import com.rabobank.csp.utils.Utility;




/**
 *  Factory class which creates different bean implementation based on the
 * type of uploaded file csv,xml,e.t.c.
 * 
 * @author adityabhargava
 *
 */
public class ParserFactory {
	
	/**
	 * Bean Factory method which creates implementation type and assign it to DataImporter 
	 * 
	 * @param filename
	 * @return
	 */
	public static Parser createParser( String filename) {
		
		Parser parser = null;
		
		if(Utility.isCsv(filename)) {
			parser = new CsvParser();
		} else if(Utility.isXml(filename)) {
			parser = new XmlParser();
		}
		
		return parser;
	}

}
