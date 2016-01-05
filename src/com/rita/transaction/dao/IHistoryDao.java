package com.rita.transaction.dao;

import java.util.List;

import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;

/**
 * @author win7
 *
 */
public interface IHistoryDao
{
	 	/**
	 	 * insert one History
	 	 * @param history
	 	 * @return History you insert
	 	 */
	    /**
	     * @param account
	     * @return the List of History by sprcific Account
	     */
	    public List<History> find(Account account);

	    public History insert(History history);
	    public History find(String id);
	    public History update(History history);
	    public void delete(History history);
}
