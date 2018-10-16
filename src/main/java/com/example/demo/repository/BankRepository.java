package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Long> , CustomizedBankRepository{
	Long countByFullName(String fullName);
	
}
