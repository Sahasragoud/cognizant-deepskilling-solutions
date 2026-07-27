package com.financialforecasting.system;

public class FinancialForecasting {
	
	public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
		// Base Case: 0 periods remaining, value is present value
		if (periods <= 0) {
			return presentValue;
		}

		// Recursive Step: multiply previous period's value by (1 + growthRate)
		return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
	}

	public static void main(String[] args) {
		double pv = 1000.00;   // $1,000 initial investment
		double rate = 0.05;    // 5% annual growth rate
		int years = 5;         // 5 years forecast

		double futureValue = calculateFutureValue(pv, rate, years);
		System.out.printf("Predicted Future Value after %d years: $%.2f%n", years, futureValue);
	}
}