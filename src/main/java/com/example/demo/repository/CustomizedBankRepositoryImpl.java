package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.BankAccount;

public class CustomizedBankRepositoryImpl implements CustomizedBankRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void someCustomMethod(String test) {
//		System.out.println("HIHI" + entityManager);
//		List<BankAccount> result = 
//				(List<BankAccount>)entityManager.createNamedQuery("select * from bankAccount").setMaxResults(10).getResultList();
		System.out.println(entityManager.find(BankAccount.class, 1L, LockModeType.PESSIMISTIC_WRITE).getFullName());
		List<BankAccount> resultList = entityManager.createNativeQuery("select * from BANK_ACCOUNT", BankAccount.class).getResultList();
		System.out.println(resultList.size());
		
	}

	@Override
	public void another(String test) {
//		entityManager.createQuery(qlString)
	}

}
