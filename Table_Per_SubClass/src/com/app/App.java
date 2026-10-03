package com.app;

import java.time.LocalDate;

import com.dao.PaymentDAO;
import com.dao.PaymentDAOImpl;
import com.entity.Cheque;
import com.entity.CreditCard;

public class App {

	public static void main(String[] args) {

		PaymentDAO dao = new PaymentDAOImpl();

		Cheque cheque = new Cheque();
		
		cheque.setDate(LocalDate.of(2026, 10, 3));
		cheque.setAmount(100000);
		cheque.setChNo(234567);
		cheque.setChType("Order");

		dao.saveCheque(cheque);

		System.out.println("((()))");

		CreditCard card = new CreditCard();
		
		card.setDate(LocalDate.of(2026, 9, 30));
		card.setAmount(80000);
		card.setCcNo(98765);
		card.setCcType("VISA");

		dao.saveCreditCard(card);
//
//		System.out.println("Read Data Payment");
//		System.out.println(dao.getPaymentById(1));
//		System.out.println(dao.getPaymentById(2));
//		System.out.println(dao.getPaymentById(3));
//		System.out.println("----------------------------------");
//		System.out.println(dao.getCreditCard(1));
//		System.out.println(dao.getCreditCard(2));
//		System.out.println(dao.getCreditCard(3));
//		System.out.println("------------------------------------");
//		System.out.println(dao.getCheque(1));
//		System.out.println(dao.getCheque(2));
//		System.out.println(dao.getCheque(3));
		
		
	}

}
