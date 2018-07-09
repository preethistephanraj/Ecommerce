package com.niit.test;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.OrderDetailDAO;
import com.niit.model.OrderDetail;

public class OrderTest {
	static OrderDetailDAO orderDetailDao;
	
	@SuppressWarnings("resource")
	@BeforeClass	
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDetailDao = (OrderDetailDAO)context.getBean("orderDetailDAO");
	}

	
	@Test
	public void addOrderTest() {
		OrderDetail order = new OrderDetail();
		order.setCartId(1005);		
		order.setUsername("koushika01");
		order.setTotalAmount(10000.0f);
		order.setOrderDate(new Date());		
		assertNotEquals(0,orderDetailDao.addOrder(order));
	}
	
	@Ignore
	@Test
	public void getOrderTest() {
		assertNotNull("Error fetching the order details",orderDetailDao.getOrder(1));
		OrderDetail orderDetail = orderDetailDao.getOrder(1);
		System.out.println("Order Details: ");
		System.out.println(orderDetail.getUsername()+"::::"+orderDetail.getShippingAddress());
	}	
	
	@Ignore
	@Test
	public void listOrderTest() {
		List<OrderDetail> listOrder = orderDetailDao.orderList("U1001");
		assertNotNull("Problem in retrieving order list",orderDetailDao.orderList("U1001"));
		System.out.println("Order ID\tOrder Date\t\t\tTotal Amount");
		for(OrderDetail order:listOrder) {
			System.out.print(order.getOrderId()+"\t\t");
			System.out.print(order.getOrderDate()+"\t\t");
			System.out.println(order.getTotalAmount());
		}
	}
}
