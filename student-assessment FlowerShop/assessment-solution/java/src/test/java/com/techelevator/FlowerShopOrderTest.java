package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FlowerShopOrderTest { 

	
	@Test
	public void getSubtotal_5_roses_returns_34_94() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 5);
		BigDecimal expected = new BigDecimal(34.94).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.getSubtotal().setScale(2, RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test 
	public void getSubtotal_0_roses_returns_19_99() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(19.99).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.getSubtotal().setScale(2, RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal_same_day_and_15000_zipCode_returns_free_shipping() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(true, "15000").setScale(2, RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void deliveryTotal_90000_zipCode_returns_19_99() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(19.99).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(false, "90000").setScale(2,RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal_sameDay_20000_zipCode_returns_9_98() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(9.98).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(true, "20000").setScale(2, RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal__not_sameDay_20000_zipCode_returns_3_99() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(3.99).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(false, "20000").setScale(2,RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal_sameDay_2999_zipCode_returns_9_98() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(9.98).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(true, "29999").setScale(2,RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal_sameDay_3000_zipCode_returns_12_98() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(12.98).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(true, "30000").setScale(2,RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deliveryTotal_not_sameDay_3999_zipCode_returns_6_99() {
		FlowerShopOrder order = new FlowerShopOrder("Peonies", 0);
		BigDecimal expected = new BigDecimal(6.99).setScale(2, RoundingMode.HALF_UP);

		BigDecimal actual = order.deliveryTotal(false, "39999").setScale(2,RoundingMode.HALF_UP);
		assertEquals(expected, actual);
	}
	

	 

} 
