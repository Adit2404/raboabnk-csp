/**
 * 
 */
package com.rabobank.csp.entities;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author adityabhargava
 *
 */

@XmlRootElement(name = "record")
public class Record  {
	

	public Record(Long reference, String accountNumber, Double startBalance, Double mutation, String description,
			Double endBalance) {
		super();
		this.reference = reference;
		this.accountNumber = accountNumber;
		this.startBalance = startBalance;
		this.mutation = mutation;
		this.description = description;
		this.endBalance = endBalance;
	}
	public Record() {
		
	}
	private Long reference;
	
	private String accountNumber;
	
	private Double startBalance;
	
	
	private Double mutation;
	
	private String description;
	
	private Double endBalance;



	@XmlAttribute
	public Long getReference() {
		return reference;
	}
	
	public void setReference(Long reference) {
		this.reference = reference;
	}
	  
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	  
	public Double getStartBalance() {
		return startBalance;
	}
	
	public void setStartBalance(Double startBalance) {
		this.startBalance = startBalance;
	}

	
	  
	public Double getMutation() {
		return mutation;
	}
	
	
	public void setMutation(Double mutationValue) {
		this.mutation = mutationValue;
	}
	  
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	  
	public Double getEndBalance() {
		return endBalance;
	}
	
	
	public void setEndBalance(Double endBalance) {
		this.endBalance = endBalance;
	}
	
	@Override
	public String toString() {
		return "Record [transactionReference=" + reference + ", accountNumber=" + accountNumber
				+ ", startBalance=" + startBalance  + ", mutationValue="
				+ mutation + ", description=" + description + ", endBalance=" + endBalance + "]";
	}

}
