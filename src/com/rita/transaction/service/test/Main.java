package com.rita.transaction.service.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rita.transaction.model.Account;
import com.rita.transaction.model.History;
import com.rita.transaction.service.*;

public class Main
{
	
	
	public static void main(String[] args)
	{
		ITransService transService  = TransService.getTransService();
		
		//CASE 1 : Account Number = "A4"
			System.out.println("----TEST CASE 1 : Account Number = A1 -----");
			Account account = transService.findAccount("A1");
			printAccountInfo(account);
	
			//Test deposit
			System.out.println("TEST : DEPOSIT $100");
			printAccountInfo(transService.deposit(account, new BigDecimal(100), null));
			System.out.println("TEST : DEPOSIT $50");
			printAccountInfo(transService.deposit(account, new BigDecimal(50), null));
			//Test withdraw
			System.out.println("TEST : WITHDRAW $20");
			printAccountInfo(transService.withdraw(account, new BigDecimal(20), null));
			
			//Test query list of history
			List<History> historys = transService.getHistorys(account);
			printOneAccountHistorys(historys);
		

		//CASE 2 : Account Number = "A6"
			System.out.println("---- TEST CASE 2 : Account Number = A6 -----");
			Account account1 = transService.findAccount("A6");
			printAccountInfo(account1);
	
			//Test deposit
			System.out.println("TEST : DEPOSIT $1000");
			printAccountInfo(transService.deposit(account1, new BigDecimal(1000), null));
			//Test withdraw
			System.out.println("TEST : WITHDRAW $2200");
			printAccountInfo(transService.withdraw(account1, new BigDecimal(2200), null));
			
			//Test query list of history
			List<History> historys1 = transService.getHistorys(account1);
			printOneAccountHistorys(historys1);
		
		//CASE 3 : Account Number = "A6"
			System.out.println("---- TEST CASE 3 : Account Number = A7 -----");
			Account account2 = transService.findAccount("A7");
			printAccountInfo(account2);
	
			// Test withdraw
			System.out.println("TEST : WITHDRAW $500000");
			printAccountInfo(transService.withdraw(account2, new BigDecimal(500000), null));
			// Test query list of history
			List<History> historys2 = transService.getHistorys(account2);
			printOneAccountHistorys(historys2);

	}
	
	/**
	 * @param account
	 * print the account information
	 */
	public static void printAccountInfo(Account account)
	{
		
		System.out.println("Account ID: " + account.getId());
		System.out.println("Account Number : " + account.getAccountNum() );
		System.out.println("Balance : " + 	account.getBalance() );
		String lastTransMsg = account.getLastTransMsg();
		System.out.println("Last Transaction Msg: " + (lastTransMsg == null ? "---" : lastTransMsg));

		System.out.println("================================");

	}
	
	/**
	 * @param historys
	 * print all history information
	 */
	public static void printOneAccountHistorys(List<History> historys)
	{
		Account account = historys.get(0).getAccount();
		System.out.println("=*=*=*=*=* Here are the historys for " + account.getAccountNum() + "  =*=*=*=*=* " );
		System.out.println("Account Number : " + account.getAccountNum() );
		System.out.println("Balance : " + 	account.getBalance() );
		System.out.println("History Transactions :");
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		for(History history : historys)
		{
			System.out.print("You " + history.getTransType() + " $" + history.getAmount() + " dollars in ");
			System.out.print(sdFormat.format(history.getDate()));
			String note = history.getNote();
			System.out.print(". Note: " + (note == null ? "---" : note));
			System.out.println(". History ID : " + history.getId());

		}
		System.out.println("ID: " + account.getId());
		System.out.println("================================");
		
	}
}
