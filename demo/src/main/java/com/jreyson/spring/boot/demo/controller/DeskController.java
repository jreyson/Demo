package com.jreyson.spring.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jreyson.spring.boot.demo.domian.Desk;
import com.jreyson.spring.boot.demo.repository.DeskRepository;

@RestController
@RequestMapping("/demo")
public class DeskController {

	@Autowired
	private DeskRepository deskRepository;
	
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("deskList", deskRepository.listDesk());
		model.addAttribute("title","资产管理");
		return new ModelAndView("demo/list","deskModel",model);
	}
	
	/**
	 * 获取创建表单页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("desk", new Desk());
		model.addAttribute("title","创建桌子");
		return new ModelAndView("demo/form","deskModel",model);
	}
	
	@PostMapping
	public ModelAndView saveOrUpdateUser(Desk desk) {
		desk = deskRepository.saveOrUpdateDesk(desk);
		return new ModelAndView("redirect:/demo");//重定向到list页面
	}

	@PostMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, String office) {
		Desk desk = deskRepository.getDeskById(id);
		desk.setOffice(office);
		desk.setStatus("使用中");
		deskRepository.saveOrUpdateDesk(desk);
		return new ModelAndView("redirect:/demo");
	}
	
	@GetMapping("/fix/{id}")
	public ModelAndView fix(@PathVariable("id") Long id) {
		Desk desk = deskRepository.getDeskById(id);
		desk.setOffice("");
		desk.setStatus("维修中");
		deskRepository.saveOrUpdateDesk(desk);
		return new ModelAndView("redirect:/demo");
	}
	
	@GetMapping("/fixed/{id}")
	public ModelAndView fixed(@PathVariable("id") Long id) {
		Desk desk = deskRepository.getDeskById(id);
		desk.setOffice("");
		desk.setStatus("可用");
		deskRepository.saveOrUpdateDesk(desk);
		return new ModelAndView("redirect:/demo");
	}
	
	@GetMapping("/use/{id}")
	public ModelAndView use(@PathVariable("id") Long id ,Model model) {
		Desk desk = deskRepository.getDeskById(id);
		model.addAttribute("desk", desk);
		model.addAttribute("title", "资源使用");
		return new ModelAndView("demo/use","deskModel",model);
	}
	
}
