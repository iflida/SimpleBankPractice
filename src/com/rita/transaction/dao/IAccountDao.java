package com.rita.transaction.dao;

import com.rita.transaction.model.Account;

/**
 * @author win7
 * AccountDao
 *
 */
public interface IAccountDao
{
	 	/**
	 	 * insert one Account
	 	 * @param account account
	 	 * @return the Account you insert
	 	 */
	 	public Account insert(Account account);
	    /**
	     * find the Account by the ID
	     * @param id
	     * @return the Account in specific ID
	     */
	    public Account find(String id);
	    /**
	     * update Original Account to input Account
	     * @param account
	     * @return the updated Account
	     */
	    public Account update(Account account);
	    public void delete(Account account);
}
