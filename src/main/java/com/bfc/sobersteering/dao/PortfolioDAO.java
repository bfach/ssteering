package com.bfc.sobersteering.dao;

import java.util.List;

import com.bfc.sobersteering.bean.Portfolio;
import com.bfc.sobersteering.bean.TradeOrder;

public interface PortfolioDAO {

	
	void writePortfolio(Portfolio portfolio, String username);
	
	Portfolio retrievePortfolio(String username);
	
	void deletePortfolio(String username);
	
	void executeOrder(String userName, String stockCode, double price, int number);

	void placeOrder(TradeOrder job);

	public List<TradeOrder> getOrdersInProgress();
	
}
