/**
 * 
 */
package com.rabobank.csp.utils;

import java.io.File;

import com.rabobank.csp.consts.Constants;
import com.rabobank.csp.exception.ValidationException;

/**
 * This class contains validation and utilities method
 * @author adityabhargava
 *
 */
public class Utility {
	
		/**
		 * Validate the given file extension.
		 * 
		 * @param fileName
		 * @return boolean
		 */
		public static boolean isFileAllowed(String fileName) {
			return isCsv(fileName) || isXml(fileName);
		}
		
		/**
		 * Check the given fileName is CSV type
		 * 
		 * @param fileName
		 * @return boolean
		 */
		public static boolean isCsv(String fileName) {
			return fileName.toLowerCase().endsWith(Constants.CSV);
		}
		
		/**
		 * Check the given fileName is XML type
		 * 
		 * @param fileName
		 * @return boolean
		 */
		public static boolean isXml(String fileName) {
			return fileName.toLowerCase().endsWith(Constants.XML);
		}
		
		
		/**
		 * Check the given Transaction Reference is valid and convert it into Long
		 * 
		 * @param transactionRef
		 * @return boolean
		 */
		public static Long validateAndConvertTransactionReference(String transactionRef) {
			if(Constants.TRANSACTION_REF_PATTERN.matcher(transactionRef).matches()) {
				return Long.parseLong(transactionRef);
			} else {
				throw new ValidationException(String.
				format("Transaction Reference '%s' is not valid.", transactionRef));
			}
		}
		
		public static String getFilePath(String fileName) {
	        File file = new File(fileName);
	        if (file.isAbsolute()) {
	            return file.getAbsolutePath();
	        } else {
	            return new File("").getAbsolutePath() + File.separator + fileName;
	        }
	    }
		
		public static void displayErrorMessage(String message) {
			System.out.println("Error occured. Please check the below message...\n"+message);
			
		}
		
		
		
		
		

}
