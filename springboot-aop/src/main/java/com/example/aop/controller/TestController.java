package com.example.aop.controller;

import com.example.aop.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@Log(module = "方法一",operate = "执行操作的方法一")
	@GetMapping("/one")
	public void methodOne(String name) {


		
	}

	@Log(module = "方法二",operate = "执行操作的方法三")
	@GetMapping("/two")
	public void methodTwo() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Log(module = "方法三",operate = "执行操作的方法三")
	@GetMapping("/three")
	public void methodThree(String name, String age) {
		
	}
}
