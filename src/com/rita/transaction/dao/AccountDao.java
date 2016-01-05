package com.rita.transaction.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;
import com.rita.transaction.model.TransType;

/**
 * @author iflida
 *
 * This class is DAO of Account
 */
public class AccountDao implements IAccountDao
{

	List<Account> accountTable = new ArrayList<Account>();// to simulate table "Account"
	HistoryDao historyDao = HistoryDao.getHistoryDao();// this is also for simulate DB, for the table "History"
	
	private static AccountDao accountDao;
	private int newestId = 0;// for record the newest ID of Account
	
	//Initial, there are 10 Account Record in mock up DB.
	private AccountDao()
	{
		//10 Account Record in mock up DB
		for (int i = 0 ; i < 10 ; ++i)
		{
			Account account = new Account();
			BigDecimal deposit = new BigDecimal(i*1000);
			account.setBalance(deposit);
			ArrayList<History> historys = new ArrayList<History>();
			History history = new History(new Date(), deposit, TransType.DEPOSIT, "Init Setting", account);
			historys.add(history);
			this.insert(account);
			
			//insert one record to Table "history"
			historyDao.insert(history);
		}
	}
	
	
	/**
	 * get the synchronized singleton Account instance
	 * @return the singleton Account instance
	 */
	public synchronized static AccountDao getAccountDao()
	{
		if(accountDao == null)
		{
			accountDao = new AccountDao();
		}
		
		return accountDao;
	}
	/* (non-Javadoc)
	 * @see com.rita.transaction.dao.IAccountDao#insert(com.rita.transaction.model.Account)
	 */
	@Override
	public Account insert(Account account)
	{
		//generate the new id
		
		if (account != null)
		{
			newestId++;
			account.setId(newestId);
			account.setAccountNum("A" + newestId);
			
			accountTable.add(account);	
		}
		return account;
	}
	
	

	/* (non-Javadoc)
	 * @see com.rita.transaction.dao.IAccountDao#find(java.lang.String)
	 */
	@Override
	public Account find(String accountNum)
	{
		for(Account account : accountTable)
		{
			if (accountNum != null && account.getAccountNum().equals(accountNum) )
			{
				return account;
			}
		}
		return null;
	}

	@Override
	public Account update(Account account)
	{
		//TODO : 
		//find the Account Record "OriginalAccount" by account.getId()
		//update OriginalAccount's field from account!
		return account;
		
	}

	@Override
	public void delete(Account account)//??
	{
		//delete		
	}

}
