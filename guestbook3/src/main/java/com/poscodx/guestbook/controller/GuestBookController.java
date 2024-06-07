package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.guestbook.service.GuestbookService;
import com.poscodx.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestbookService guestbookService;

	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookService.getContentsList();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	// 나머지 기능도 구현하기 (to do)

	// add
	@RequestMapping("/add")
	public String add(GuestBookVo vo) {
		guestbookService.addContents(vo);
		
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
		guestbookService.daleteContents(no, password);
		return "redirect:/";
	}
	
}
