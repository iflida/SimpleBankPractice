package com.rita.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;

/**
 * @author win7
 * Ssupport some Transaction function
 */
public interface ITransService
{
	/**
	 * Find the Account by account number
	 * @param accountnum account number
	 * @return the Account by specific account number
	 */
	public Account findAccount(String accountnum);
	/**
	 * Deposit $amount to the account and can leave notes for this transaction
	 * @param account Account
	 * @param amount the price of the transaction
	 * @param note leave the note in this transaction
	 * @return the Account you deposit money
	 */
	public Account deposit(Account account, BigDecimal amount,String note);
	/**
	 * Withdraw $amount from the account and can leave notes for this transaction
	 * @param account Account
	 * @param amount the price of the transaction
	 * @param note leave the note in this transaction
	 * @return the Account you deposit money
	 */
	public Account withdraw(Account account, BigDecimal amount,String note);
	/**
	 * get all the history records from the specific Account
	 * @param account Account
	 * @return the list of History record by specific Account
	 */
	public List<History> getHistorys(Account account);


}
