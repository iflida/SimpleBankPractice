package com.rita.transaction.dao;

import java.util.ArrayList;
import java.util.List;

import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;

/**
 * @author win7
 * This is DAO of History
 */
public class HistoryDao implements IHistoryDao
{

	List<History> historyTable = new ArrayList<History>();// to simulate table "History"
	
	private static HistoryDao historyDao;
	
	private static int newtestId = 0; // to record the newest ID of History
	
	private HistoryDao()
	{
	}
	
	/**
	 * get the synchronized singleton HistoryDao instance
	 * @return the singleton HistoryDao instance
	 */
	public synchronized static HistoryDao getHistoryDao()
	{
		if(historyDao == null)
		{
			historyDao = new HistoryDao();
		}
		
		return historyDao;
	}
	
	/* (non-Javadoc)
	 * @see com.rita.transaction.dao.IHistoryDao#insert(com.rita.transaction.model.History)
	 */
	@Override
	public History insert(History history)
	{
		if (history != null)
		{
			history.setId(newtestId++);
			historyTable.add(history);
		}
		return history;	
	
		
	}

	@Override
	public History find(String id)
	{
		// find
		return null;
	}

	@Override
	public History update(History history)
	{
		// update
		return history;
		
	}

	@Override
	public void delete(History history)
	{
		// delete
		
	}

	/* (non-Javadoc)
	 * @see com.rita.transaction.dao.IHistoryDao#find(com.rita.transaction.model.Account)
	 */
	@Override
	public List<History> find(Account account)
	{
		int accountId = account.getId();
		
		List<History> historys = new ArrayList<History>();
		for (History history : historyTable )
		{
			if (accountId == history.getAccount().getId())
			{
				historys.add(history);
			}
		}
		return historys;
	}

}
