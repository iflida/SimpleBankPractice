/**
 * 
 */
package com.rita.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author win7
 * this class is mapping to the table "History".
 * History is for record the history of every transaction .
 * One Account can have many Historys.
 */
public class History
{
	private int id;
	private Date date;
	private BigDecimal amount; // the transaction price
	private TransType transType;// the transaction type : deposit or withdraw
	private String note;//note of this record
	private Account account; //the account who own the history

	public History()
	{
		
	}
	
	
	/**
	 * @param date : the date you do the transaction, usually is "NOW".
	 * @param amount : the price($)
	 * @param transType : deposit/withdraw
	 * @param note : leave notes
	 * @param account the account who own the history
	 */
	public History( Date date, BigDecimal amount, TransType transType, String note, Account account)
	{
		super();
		this.date = date;
		this.amount = amount;
		this.transType = transType;
		this.note = note;
		this.account = account;
	}




	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the date that the transaction happened
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date the date that the transaction happened
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the price in this transaction
	 */
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the price in this transaction
	 */
	public TransType getTransType()
	{
		return transType;
	}

	/**
	 * @param transType the type of the transaction
	 */
	public void setTransType(TransType transType)
	{
		this.transType = transType;
	}

	/**
	 * @return the type of the transaction
	 */
	public String getNote()
	{
		return note;
	}

	/**
	 * @param note Note the detail in this transaction
	 */
	public void setNote(String note)
	{
		this.note = note;
	}

	/**
	 * @return the detail note in this transaction
	 */
	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * Equals if IDs are the same
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Equals if IDs are the same
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		if (id != other.id)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * List all the field Except "Account"
	 * and show the Account Number
	 */
	@Override
	public String toString()
	{
		//List all the field Except "Account" ,and show the "Account Number".
		return "History [id=" + id + ", date=" + date + ", amount=" + amount + ", transType=" + transType + ", note="
				+ note + ", Account Number=" + account.getAccountNum() + "]";
	}

	
	
}

