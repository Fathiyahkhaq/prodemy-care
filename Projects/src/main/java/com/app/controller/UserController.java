package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.ListDonatur;
import com.app.service.DonaturService;

@Controller
@RequestMapping("/user1")
public class UserController {
	
	@GetMapping
    public String user1(Model model) {
        model.addAttribute("user", "Tes");
        return "donatur/index";
    }

//    @GetMapping("/donasi")
//    public String category(Model model) {
//        model.addAttribute("user", "Tes");
//        return "donatur/index";
//    }
    @Autowired
	private DonaturService service;
    
    @GetMapping("/donasi")
    public String showDonatur(Model model) throws Exception {
    	List<ListDonatur> list = service.findAll();
		model.addAttribute("dtrlist", list);

		return "donatur/listdonatur";
	}
    
//    @GetMapping("/edit")
//	public String edit(Model model, HttpServletRequest req) throws Exception {
//		ListDonatur donatur = service.findById((long) Integer.parseInt(req.getParameter("id")));
//		model.addAttribute("donatur", donatur);
//
//		List<ListDonatur> list = service.findAll();
//		model.addAttribute("dtrlist", list);
//
//		return "donatur/edit";
//	}
    
    @GetMapping("/edit")
    public String editData(Model model) {
    	model.addAttribute("coba",new ListDonatur());
    	return "donatur/edit";
    }
	
    @PostMapping("/edit")
    public String result(@ModelAttribute ListDonatur dtr, Model model) {
    	model.addAttribute("cobalagi",dtr);
    	return "donatur/result";
    }
    
    
	@PostMapping
	public String save(Model model, HttpServletRequest req) throws Exception {
		String mode = req.getParameter("mode");
		
		if ("tambah".equals(mode)) {
			ListDonatur dtr = new ListDonatur();
			dtr.setId((long) Integer.parseInt(req.getParameter("id")));
			dtr.setNama(req.getParameter("nama"));
			dtr.setEmail(req.getParameter("email"));
			dtr.setPhone(req.getParameter("phone"));
			dtr.setTotal(req.getParameter("total"));
			dtr.setAnonim(Integer.parseInt(req.getParameter("anonim")));
			service.insert(dtr);
		} else if ("hapus".equals(mode)) {
			service.deleteById((long) Integer.parseInt(req.getParameter("id")));
		} else {
			ListDonatur dtr = service.findById((long) Integer.parseInt(req.getParameter("id")));
			dtr.setNama(req.getParameter("nama"));
			dtr.setEmail(req.getParameter("email"));
			dtr.setPhone(req.getParameter("phone"));
			dtr.setTotal(req.getParameter("total"));
			dtr.setAnonim(Integer.parseInt(req.getParameter("anonim")));
			service.update(dtr);			
		}
		
		List<ListDonatur> list = service.findAll();
		model.addAttribute("dtrlist", list);
		
		return "donatur/index";
	}
}
