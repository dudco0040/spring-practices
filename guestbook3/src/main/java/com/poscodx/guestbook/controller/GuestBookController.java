package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscodx.guestbook.repository.GuestBookRepository;
import com.poscodx.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookRepository guestbookRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	// 나머지 기능도 구현하기 (to do)

}
