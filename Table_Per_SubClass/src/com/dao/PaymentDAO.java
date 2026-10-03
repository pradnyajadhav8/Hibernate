package com.dao;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;

public interface PaymentDAO {
	
	void saveCreditCard(CreditCard credit);
	
	void saveCheque(Cheque cheque);
	
	void deleteCreditCard(int id);
	
	void deleteCheque(int id);
	
	Payment getPaymentById(int id);
	
	CreditCard getCreditCard(int id);
	
	Cheque getCheque(int id);
}
