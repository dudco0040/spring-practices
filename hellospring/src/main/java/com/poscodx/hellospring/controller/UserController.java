package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @RequstMapping 클래스 + 메소드 매핑 - 추천하는 방법
 */

@Controller
@RequestMapping("/uesr")  // 공통된 URL - 클래스에서 지정
public class UserController {
	
	@ResponseBody
	@RequestMapping("/join")  // 기능에 따른 URL - 메소드에서 지정
	public String join() {
		return "UserController.join()";
		
	}	
}
