package com.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.BankAccount;
import com.example.demo.service.DemoService;

@Controller
public class HomeController {
	@Value("${home.message}")
	private String message;

	@Autowired
	private DemoService demoService;

//	@ResponseBody
	@RequestMapping("/")
	public String welcome(Map<String, Object> model, HttpServletRequest req) {
		model.put("message", this.message);
		return "/home";
	}

	@RequestMapping("/error2")
	public String error(Map<String, Object> model) {
		demoService.test();
		System.out.println(demoService.getPage(new BankAccount(), 0, 2).get(0).getFullName());
		System.out.println(demoService.getPage(new BankAccount(), 1, 2).get(0).getFullName());
		model.put("message", this.message);
		return "/home";
	}

	@RequestMapping("/trans.sample")
	public String testTransaction(@RequestParam(value = "test", required = false) String test) throws Exception {
		System.out.println(test);
//		try {
//			demoService.testTransaction();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "/home";
	}

	@RequestMapping("/add")
	public String addAdminUser() {
		try {
			demoService.testAdminUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
}
