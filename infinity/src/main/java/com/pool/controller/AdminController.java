package com.infinity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infinity.form.RolesForm;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@GetMapping("roles")
public String rolesPage(Model model) {
		RolesForm role=new RolesForm();
		model.addAttribute("role", role);
		
	return "Roles";
}
	@PostMapping("saveroles")
	public String saveRoles() {
		return "redirect:admin/roles";
	}
	
}
