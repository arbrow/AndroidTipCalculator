package com.laurengariepy.android.tipcalculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Tip {
	
	/**
	 * Method returns $-formatted tip based on argument values for tip percent and total bill.
	 * If either argument cannot be converted to BigDecimal representation, method returns "-0.00" 
	 * sentinel value.
	 * 
	 * @return String representing tip amount, $-formatted to two decimal places
	 */
	public static String computeTip(String sTipPercent, String sBill) {
		BigDecimal tipPercent;
		try {
			tipPercent = new BigDecimal(sTipPercent);
		} catch (NumberFormatException e) {
			return "-0.00";
		}
		
		BigDecimal bill;
		try {
			bill = new BigDecimal(sBill);
		} catch (NumberFormatException e) {
			return "-0.00";
		}
		
		BigDecimal tip = bill.multiply(tipPercent);    
		tip = tip.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
		double formattedTip = tip.doubleValue();
		
		return usdFormat.format(formattedTip);
	}
	
}
