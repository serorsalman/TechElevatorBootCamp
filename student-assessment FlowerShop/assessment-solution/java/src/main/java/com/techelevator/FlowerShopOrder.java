package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FlowerShopOrder {
	
	private String bouquetType;
	private int numberOfRoses;
	// subtotal is a derived field and therefore doesn't need a property field
	
	public FlowerShopOrder(String bouquetType, int numberOfRoses) {
		this.bouquetType = bouquetType;
		this.numberOfRoses = numberOfRoses; 
	}
	
	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal(19.99).add(new BigDecimal(this.numberOfRoses*2.99));
		return subtotal;
	} 
	
	public BigDecimal deliveryTotal(boolean isSameDay, String zipCode) {
		BigDecimal total = new BigDecimal(0.00);
		int intZipCode = Integer.parseInt(zipCode);
		if(intZipCode < 10000 || intZipCode > 39999) {
			total = total.add(new BigDecimal( 19.99));
			return total;  // no same-day delivery option so return here
		} if (intZipCode >= 10000 && intZipCode <= 19999) {
			total = total.add(new BigDecimal( 0.00));
			return total;  // no delivery charge for these regardless of same day boolean
		} else if (intZipCode >= 30000 && intZipCode <= 39999) {
			total = total.add(new BigDecimal( 6.99));
		} else if (intZipCode >= 20000  && intZipCode <= 29999){
			total = total.add(new BigDecimal( 3.99));
		}
		if (isSameDay){
			total = total.add(new BigDecimal(5.99));
		}
		return total;
	}
	
	
	@Override
	public String toString() {
		return "ORDER - " + this.bouquetType + " - "
	+ this.numberOfRoses + " roses - " + getSubtotal().setScale(2, RoundingMode.HALF_UP) ;
	} 
		
}
