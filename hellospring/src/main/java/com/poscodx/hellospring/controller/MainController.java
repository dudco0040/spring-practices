package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@ResponseBody
	@RequestMapping({"/", "/main"})  // url 입력 시, 뒤에 안쓰면 /를 tomcat이 달아줌 (redirect) -> '/'찾아서 이 부분이 실행됨 
	public String main() {
		return "MainController.main()";
	}
}
