package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Donation;
import com.app.model.ListDonatur;
import com.app.service.DonationService;
import com.app.service.DonaturService;

@Controller
@RequestMapping("/user1")
public class UserController {
	
	@Autowired
	private DonaturService service;
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping("/")
	public String user1(Model model) {
		model.addAttribute("user","tes");
		return "donatur/index";
	}
	
	@GetMapping("/donasi")
	public String listDonasi(Model model) throws Exception {
		List<ListDonatur> list = service.findAll();
		model.addAttribute("list",list);
		return "donatur/listdonatur";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam long id, Model model) throws Exception {
		ListDonatur dtr = service.findById(id);
		model.addAttribute("coba",dtr);
		return "donatur/edit";
	}
	
	@PostMapping("/update/{id}")
	public String save(Model model, HttpServletRequest req, @RequestParam long id) throws Exception {
		ListDonatur dtr = service.findById(id);
		dtr.setId((long) Integer.parseInt(req.getParameter("id")));
		dtr.setNama(req.getParameter("nama"));
		dtr.setEmail(req.getParameter("email"));
		dtr.setPhone(req.getParameter("phone"));
		dtr.setTotal(req.getParameter("total"));
		dtr.setAnonim(Integer.parseInt(req.getParameter("anonim")));
		service.update(dtr);
		
		return "redirect:/user1/donasi";
	}
	
	@GetMapping("/tambah")
	public String viewAdd(Model model) {
		return "donatur/add";
	}
	
	@PostMapping("/tambah")
	public String addDonasi(Model model, HttpServletRequest req) throws Exception {
		ListDonatur dtr = new ListDonatur();
		dtr.setNama(req.getParameter("nama"));
		dtr.setEmail(req.getParameter("email"));
		dtr.setPhone(req.getParameter("phone"));
		dtr.setTotal(req.getParameter("total"));
		dtr.setAnonim(Integer.parseInt(req.getParameter("anonim")));
		service.insert(dtr);
		
		return "redirect:/user1/donasi";
	}
	
	@GetMapping("/ajuan")
	public String listAjuan(Model model) throws Exception {
		List<Donation> list = donationService.findAll();
		model.addAttribute("list",list);
		return "donatur/listajuan";
	}
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	 
	private Date parseDate(String date){
	    try {
	        return DATE_FORMAT.parse(date);
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	@GetMapping("/editAjuan")
	public String editAjuan(@RequestParam long id, Model model) throws Exception {
		Donation ajuan = donationService.findById(id);
		model.addAttribute("cobalagi",ajuan);
		return "donatur/editAjuan";
	}
	
	@PostMapping("/updateAjuan/{id}")
	public String saveAjuan(Model model, HttpServletRequest req, @RequestParam long id) throws Exception {
		Donation dtr = donationService.findById(id);
		dtr.setId((long) Integer.parseInt(req.getParameter("id")));
		dtr.setTitle(req.getParameter("title"));
		dtr.setTarget(req.getParameter("target"));
		dtr.setStatus(Integer.parseInt(req.getParameter("status")));
		dtr.setFile(req.getParameter("file"));
		dtr.setPhoto(req.getParameter("photo"));
		dtr.setEventId(req.getParameter("eventId"));
		dtr.setPayment(req.getParameter("payment"));
		dtr.setDeadline(parseDate(req.getParameter("deadline")));
		donationService.update(dtr);
		
		return "redirect:/user1/ajuan";
	}
	
	@GetMapping("/tambahAjuan")
	public String viewAddAjuan(Model model) {
		return "donatur/addAjuan";
	}
	
	@PostMapping("/tambahAjuan")
	public String addDonasiAjuan(Model model, HttpServletRequest req) throws Exception {
		Donation dtr = new Donation();
		dtr.setTitle(req.getParameter("title"));
		dtr.setTarget(req.getParameter("target"));
		dtr.setStatus(Integer.parseInt(req.getParameter("status")));
		dtr.setFile(req.getParameter("file"));
		dtr.setPhoto(req.getParameter("photo"));
		dtr.setEventId(req.getParameter("eventId"));
		dtr.setPayment(req.getParameter("payment"));
		dtr.setDeadline(parseDate(req.getParameter("deadline")));
		donationService.insert(dtr);
		
		return "redirect:/user1/ajuan";
	}
}
