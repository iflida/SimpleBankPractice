/**
 * 
 */
package com.rita.transaction.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author win7
 * This class is mapping to DB "Account"
 */
public class Account
{
	private int id;
	private BigDecimal balance;
	private String lastTransMsg;
	private String accountNum;
	public Account()
	{
		
	}
	public Account(String accountNum)
	{
		
	}
	
	
	public String getLastTransMsg()
	{
		return lastTransMsg;
	}
	public void setLastTransMsg(String lastTransMsg)
	{
		this.lastTransMsg = lastTransMsg;
	}
	public String getAccountNum()
	{
		return accountNum;
	}
	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public BigDecimal getBalance()
	{
		return balance;
	}
	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}
	
//	public List<History> getHistorys()
//	{
//		return historys;
//	}
//	public void setHistorys(List<History> historys)
//	{
//		this.historys = historys;
//	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * equals if IDs are the same
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
	 * equals if IDs are the same
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
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		//show all the field.
		return "Account [id=" + id + ", balance=" + balance + ", lastTransMsg=" + lastTransMsg + ", accountNum="
				+ accountNum + "]";
	}

	
	
	
	
	

}
