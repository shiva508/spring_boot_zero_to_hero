package com.pool.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.pool.formmodel.RegistrationForm;
import com.pool.formmodel.RoleForm;
import com.pool.model.onetoone.AccountEntity;
import com.pool.model.onetoone.EmployeeEntity;
import com.pool.model.onetoone.ParentSPK;
import com.pool.service.EmployeeEntityService;
import com.pool.service.RegistrationService;

@Controller
public class LoginController {

	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private EmployeeEntityService employeeEntityService;
	@Autowired
	private com.shiva.reports.ReportGenerator reportGenerator;
	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		RegistrationForm registration = new RegistrationForm();
		model.addAttribute("registration", registration);
		return "welcome";
	}

	@GetMapping("/users")
	public String usersList(Model model) {
		model.addAttribute("users",registrationService.usersList());
		return "usersList";
	}
	@GetMapping("/user/{userid}")
	public String getUser(@PathVariable("userid")Integer userid,Model model) {
		model.addAttribute("registration",registrationService.getUserByUserId(userid));
		return "updateuser";
	}
	@GetMapping("/deleteuser/{userid}")
	public String deleteUser(@PathVariable("userid")Integer userid,Model model) {
		registrationService.deleteUser(userid);
		return "redirect:/users";	
	}
	@GetMapping("/viewuser/{userid}")
	public String viewUser(@PathVariable("userid")Integer userid,Model model) {
		model.addAttribute("user",registrationService.getUserByUserId(userid));
		return "viewUser";	
	}
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("registration") RegistrationForm registration, Model model ) {
		registrationService.updateUser(registration);
		return "redirect:/users";
	}
	@PostMapping("/formregistration")
	public String registration(@Valid @ModelAttribute("registration") RegistrationForm registration, Model model,
			BindingResult result) {
		String view = "";
		System.out.println(registration);
		model.addAttribute("registration", registration);
	
		if (result.hasErrors()) {
			view = "welcome";
		} else {
			Long userid=registrationService.isUserExist(registration.getEmail());
			view = "redirect:/users";
			if(userid>0) {
				view="UserExist";
			}else {
				if(registration.getDummyRoles().size()>0) {
					for (String role :registration.getDummyRoles() ) {
						registration.getRoles().add(new RoleForm("ROLE_"+role.trim()));	
					}
				}
				//registration.setRoles(Arrays.asList(new RoleForm("ROLE_USER"),new RoleForm("ROLE_ADMIN")));
				registrationService.saveUser(registration);	
			}
		}
		
		
		return view;
	}

	@GetMapping("/customlogin")
	public String loginpage() {
		return "login";
	}

	@GetMapping("/myform")
	public String myform() {
		return "MyForm";
	}

	@GetMapping("/fromexp")
	public String fromexp(HttpServletRequest request, Model model, @RequestParam("myname") String myName) {
		String name1 = request.getParameter("myname");
		model.addAttribute("name1", name1);
		model.addAttribute("myName", myName);
		return "ParamExe";
	}
	@GetMapping("/saveAccount")
	public String saveAccount() {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountNumber("asdgadgsadas");

		//Integer accountid=employeeEntityService.saveAccount(accountEntity);
		//System.out.println("ACC ID:"+accountid);
		accountEntity.setAccountId(1);
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setFirstName("SHIVA_ID");
		employeeEntity.setLastName("DASARI");
		employeeEntity.setEmail("dasarishiva1@gmail.com");
		employeeEntity.setAccount(accountEntity);
		System.out.println(	"EMP SAVE:"+employeeEntityService.saveEmploye(employeeEntity));
	
		return "OK";
	}
	@GetMapping("/listemp")
	@ResponseBody
	public ResponseEntity<List<EmployeeEntity>> getEmp(){
		return new ResponseEntity<List<EmployeeEntity>>(employeeEntityService.employeeEntities(), HttpStatus.OK);
	}
	
	public ResponseEntity<List<ParentSPK>> spk(){
		return null;
	}
	@GetMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response) {
		reportGenerator.preparePdf(request,response );
	}
}
