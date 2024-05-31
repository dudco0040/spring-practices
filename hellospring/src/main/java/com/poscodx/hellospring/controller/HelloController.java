package com.poscodx.hellospring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")   // 요청과 메소드를 매핑 
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")   // 요청과 메소드를 매핑 
	public String hello2(String name) {
		System.out.println("name:" + name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")   // 요청과 메소드를 매핑 
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");  // Hello: leeyc
		
		return mav;
	}
	
	@RequestMapping("/hello4")   // 요청과 메소드를 매핑 
	public String hello4(String name, Model model) {
		// jsp로 넘길 것으로 name 받아서 출력 X - 파라미터에 모델이 있는 경우 case4
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")   // String을 리턴 - 한글이 깨짐(빈 설정이 필요)
	public String hello5() {
		return "<h1>Hello World</h1>";
	}
	
	@RequestMapping("/hello6")   // redirect
	public String hello6() {
		return "redirect:/hello";  // url-내가 매핑한 링크 그대로 작성 => Contextpath 기능 
	}
	
	public void hello7(HttpServletResponse response) throws IOException {  // void 불순한 의도..? - 가능하지만 좋지 않은 예시
		response.getWriter().print("<h1>Hello World</h1>");
	}
	
}