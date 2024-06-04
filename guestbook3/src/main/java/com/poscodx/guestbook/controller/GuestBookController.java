package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.guestbook.repository.GuestBookRepositoryWithRawJdbc;
import com.poscodx.guestbook.repository.GuestbookRepositoryWithJdbcContext;
import com.poscodx.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookRepositoryWithRawJdbc guestbookRepository1;

	@Autowired
	private GuestbookRepositoryWithJdbcContext guestbookRepository2;

	//@Autowired
	//private GuestbookRepositoryWithJdbcTemplate guestbookRepository3;
	
	
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookRepository1.findAll();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	// 나머지 기능도 구현하기 (to do)

	// add
	@RequestMapping("/add")
	public String add(GuestBookVo vo) {
		guestbookRepository2.insert(vo);
		
		return "redirect:/";
	}
	
	// delete
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, @RequestParam(value="password", required=true, defaultValue="") String password) {
		guestbookRepository2.deleteByNoAndPassword(no, password);
		return "redirect:/";
	}
	
}
