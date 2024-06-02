package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping 클래스 단독 매핑
 * Spring MVC 4.x 지원
 */
// @Controller  // 이걸 주석처리 하면 컨트롤러가 생기지 않으면서 에러가 발생하지 않을 것 
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController.delete()";
		
	}
}
