package com.austin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.austin.model.FynarfinEntity;
import com.austin.srvice.FynarfinService;



@Controller
public class FynarfinController {

	@Autowired
	private FynarfinService service;


	@GetMapping("/form")
	public String form(Model model) {
		FynarfinEntity entity=new FynarfinEntity();
		model.addAttribute("fynarfinentity", entity);
		return "PlanForm.html";

	}
	
	@GetMapping("/view")
	public String getRecord(Model model) {
		List<FynarfinEntity> entity=service.getAllRecord();
		model.addAttribute("result", entity);
		return "ViewResult";

	}


	@PostMapping("/Add")
	public String SaveInterestRate(@ModelAttribute("fynarfinentity") FynarfinEntity fynarfinEntity, Model model) {

		System.out.println(fynarfinEntity.getOutstandingPrinciple());
		FynarfinEntity calculateSimpleInterest = service.calculateSimpleInterest(fynarfinEntity);
		if (calculateSimpleInterest != null) {
			model.addAttribute("SucessMsg", "calculateSimpleInterest Sucessfull");
		}
		else {
			model.addAttribute("errmsg", "calculateSimpleInterest is Not Sucessfull");
		}

		return "PlanForm.html";

	}

}
