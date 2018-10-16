package com.example.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AdminUser;
import com.example.demo.model.BankAccount;
import com.example.demo.repository.AdminUserRepository;
import com.example.demo.repository.BankRepository;

@Service
@Transactional(rollbackFor=Exception.class)
public class DemoService {
	
	private static final Logger logger = LogManager.getLogger();
//	private static final Log log = LogFactory.getLog(DemoService.class);
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private AdminUserRepository adminUserRepository;

	public void test() {
		BankAccount account = new BankAccount();
		account.setFullName("Tom");
		Example<BankAccount> example = Example.of(account);
		System.out.println(bankRepository.count(example));
		bankRepository.someCustomMethod("fuck");
//		logger.info("hello", new Exception("I like it"));
		logger.info("hello");
	}
	
	public List<BankAccount> getPage(BankAccount bankAccount, int pageNum, int pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		List<BankAccount> bankAccountList = bankRepository.findAll(pageable).getContent();
		
		return bankAccountList;
	}
	
	public void testTransaction() throws Exception {
		BankAccount account = new BankAccount();
		account.setFullName("Transfer");
		account.setBalance(35.03);
		bankRepository.save(account);
//		throw new Exception("i like it");
	}
	
	public void testAdminUser() {
//		
//		AdminUser adminUser = new AdminUser();
//		adminUser.setAdminLevel((byte)5);
//		adminUser.setUsername("fireinthehole");
//		adminUserRepository.save(adminUser);
		AdminUser adminUser = adminUserRepository.findById(5).get();
		adminUser.setUsername("lyrics");
		adminUserRepository.save(adminUser);
	}
}
