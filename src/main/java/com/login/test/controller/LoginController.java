package com.login.test.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.test.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@GetMapping("/form")
	public String openForm(Model model)
	{
		System.out.println("Opening Form...");
		model.addAttribute("loginData",new LoginData());
		return "form";
	}
	
	//handler for process form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result)
	{
		if(result.hasErrors())
		{
			 
			System.out.println(result);
			return "form";
		}
		
		// Return to the form page to display the empty form error
//		if (loginData.getUserName().isEmpty() || loginData.getEmail().isEmpty()) {
//	        return "form"; 
//	    }
		System.out.println("Opening process..."+"\n" + loginData);
		//data process
		return "success";
	}
}
