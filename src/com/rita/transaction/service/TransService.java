package com.rita.transaction.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rita.transaction.dao.AccountDao;
import com.rita.transaction.dao.HistoryDao;
import com.rita.transaction.dao.IAccountDao;
import com.rita.transaction.dao.IHistoryDao;
import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;
import com.rita.transaction.model.TransType;

public class TransService implements ITransService
{

	private IHistoryDao historyDao;
	private IAccountDao accountDao;

	public static String msgInsufficientAccountBalance = "Insufficient account balance.";
	
	private static TransService transService;
	private TransService()
	{
		historyDao  = HistoryDao.getHistoryDao();
		accountDao = AccountDao.getAccountDao();
	}
	
	/**
	 * get synchronized singleton TransService instance
	 * @return the singleton TransService instance
	 */
	public synchronized static TransService getTransService()
	{
		if (transService == null)
		{
			transService = new TransService();
		}
		return transService;
	}
	
	@Override
	public Account deposit(Account account, BigDecimal amount,String note)
	{
		
		//Add one History record
		History history = new History(new Date(), amount, TransType.Deposit, note, account);
		historyDao.insert(history);

		//update Account
		if (history.getAmount() != null && account.getBalance() != null)
		{
			account.setBalance(history.getAmount().add(account.getBalance()));
		}
		
		return accountDao.update(account);
	}

	/* (non-Javadoc)
	 * @see com.rita.transaction.service.ITransService#withdraw(com.rita.transaction.model.Account, double, java.lang.String)
	 */
	@Override
	public Account withdraw(Account account, BigDecimal amount,String note)
	{
		
		//update Account
		BigDecimal balance = account.getBalance();
		if ( balance != null && amount != null && balance.compareTo(amount) >= 0)
		{
			
			account.setBalance(balance.subtract(amount));
			
			
			//Add one History record
			History history = new History(new Date(), amount, TransType.Withdraw, note, account);
			historyDao.insert(history);
		}
		else //Insufficient account balance
		{
			account.setLastTransMsg(msgInsufficientAccountBalance);

		}
		return accountDao.update(account);

		
	}

	/* (non-Javadoc)
	 * @see com.rita.transaction.service.ITransService#getHistorys(com.rita.transaction.model.Account)
	 */
	@Override
	public List<History> getHistorys(Account account)
	{
		return historyDao.find(account);
	}



	/* (non-Javadoc)
	 * @see com.rita.transaction.service.ITransService#findAccount(java.lang.String)
	 */
	@Override
	public Account findAccount(String accountum)
	{
		return accountDao.find(accountum);
	}
	

}
