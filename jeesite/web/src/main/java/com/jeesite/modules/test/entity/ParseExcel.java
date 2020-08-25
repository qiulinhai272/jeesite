package com.jeesite.modules.test.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import lombok.Data;


@Table(name="ks_trade_volume", alias="a", columns={
		@Column(name="account_ownership", attrName="accountOwnership", label="账户归属"),
		@Column(name="account", attrName="account", label="账号"),
		@Column(name="name", attrName="name", label="姓名"),
		@Column(name="order_number", attrName="orderNumber", label="订单号"),
		@Column(name="variety", attrName="variety", label="品种"),
		@Column(name="transaction_type", attrName="transactionType", label="交易类型"),
		@Column(name="trading_volume", attrName="tradingVolume", label="交易量"),
		@Column(name="billing_time", attrName="billingTime", label="开单时间"),
		@Column(name="billing_price", attrName="billingPrice", label="开单价格"),
		@Column(name="stop_loss", attrName="stopLoss", label="止损"),
		@Column(name="take_profit", attrName="takeProfit", label="止盈"),
		@Column(name="closing_time", attrName="closingTime", label="平仓时间"),
		@Column(name="closing_price", attrName="closingPrice", label="平仓价格"),
		@Column(name="handling_fee", attrName="handlingFee", label="手续费"),
		@Column(name="interest", attrName="interest", label="利息"),
		@Column(name="profit_and_loss", attrName="profitAndLoss", label="盈亏"),
		@Column(name="ksremarks", attrName="ksremarks", label="备注"),
		@Column(includeEntity= DataEntity.class),
}
)


public class ParseExcel extends DataEntity<ParseExcel> {

	private String account_ownership;
	private double account;
	private String name;
	private double order_number;
	private String variety;
	private String transaction_type;
	private double trading_volume;
	private String billing_time;
	private double billing_price;
	private double stop_loss;
	private double take_profit;
	private String closing_time;
	private double closing_price;
	private double handling_fee;
	private double interest;
	private double profit_and_loss;
	private String ksremarks;

	public ParseExcel() {

	}

	public String getaccountOwnership() {
		return account_ownership;
	}

	public void setAccount_ownership(String account_ownership) {
		this.account_ownership = account_ownership;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getorderNumber() {
		return order_number;
	}

	public void setOrder_number(double order_number) {
		this.order_number = order_number;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String gettransactionType() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double gettradingVolume() {
		return trading_volume;
	}

	public void setTrading_volume(double trading_volume) {
		this.trading_volume = trading_volume;
	}

	public String getbillingTime() {
		return billing_time;
	}

	public void setBilling_time(String billing_time) {
		this.billing_time = billing_time;
	}

	public double getbillingPrice() {
		return billing_price;
	}

	public void setBilling_price(double billing_price) {
		this.billing_price = billing_price;
	}

	public double getstopLoss() {
		return stop_loss;
	}

	public void setStop_loss(double stop_loss) {
		this.stop_loss = stop_loss;
	}

	public double gettakeProfit() {
		return take_profit;
	}

	public void setTake_profit(double take_profit) {
		this.take_profit = take_profit;
	}

	public String getclosingTime() {
		return closing_time;
	}

	public void setClosing_time(String closing_time) {
		this.closing_time = closing_time;
	}

	public double getclosingPrice() {
		return closing_price;
	}

	public void setClosing_price(double closing_price) {
		this.closing_price = closing_price;
	}

	public double gethandlingFee() {
		return handling_fee;
	}

	public void setHandling_fee(double handling_fee) {
		this.handling_fee = handling_fee;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getprofitAndLoss() {
		return profit_and_loss;
	}

	public void setProfit_and_loss(double profit_and_loss) {
		this.profit_and_loss = profit_and_loss;
	}

	public String getKsremarks() {
		return ksremarks;
	}

	public void setKsremarks(String ksremarks) {
		this.ksremarks = ksremarks;
	}

	@Override
	public String toString() {
		return "ParseExcel{" +
				"account_ownership='" + account_ownership + '\'' +
				", account=" + account +
				", name='" + name + '\'' +
				", order_number=" + order_number +
				", variety='" + variety + '\'' +
				", transaction_type='" + transaction_type + '\'' +
				", trading_volume=" + trading_volume +
				", billing_time='" + billing_time + '\'' +
				", billing_price=" + billing_price +
				", stop_loss=" + stop_loss +
				", take_profit=" + take_profit +
				", closing_time='" + closing_time + '\'' +
				", closing_price=" + closing_price +
				", handling_fee=" + handling_fee +
				", interest=" + interest +
				", profit_and_loss=" + profit_and_loss +
				", ksremarks='" + ksremarks + '\'' +
				'}';
	}
}
