package com.xworkz.vacccine.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vacccine.dto.VaccineDTO;
import com.xworkz.vacccine.entity.VaccineEntity;
import com.xworkz.vacccine.service.VaccinerService;
import com.xworkz.vacccine.util.MailDispatcher;
import com.xworkz.vacccine.util.OtpGenerator;

@Controller
public class VaccineController {

	@Autowired
	private VaccinerService vaccinerService;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public VaccineController() {
		LOGGER.log(Level.INFO,getClass().getSimpleName() + "object is created");
		//System.out.println(getClass().getSimpleName() + "object is created");
	}
	
	@RequestMapping(value = "/clickregister.do")
	public String onClickRegister() {
		return "optpage";
		
	}

	@RequestMapping(value = "/register.do")
	public String onRegister(@Valid@ModelAttribute VaccineDTO dto, Model model)
	{
		LOGGER.log(Level.INFO,"Invoked onRegister Method");
		//System.out.println("Invoked onRegister Method");
		LOGGER.log(Level.INFO,"dto");
		//System.out.println(dto);
		boolean outcome = this.vaccinerService.registerVacciner(dto);
		if (outcome) {
			model.addAttribute("vaccinemessage", "vaccine Application Successfull done");
			return "success";
		} else {
			model.addAttribute("vaccinemessage", " Application Failed try again later");
			return "fail";

		}

	}

}