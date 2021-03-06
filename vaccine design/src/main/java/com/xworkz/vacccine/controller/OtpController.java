package com.xworkz.vacccine.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vacccine.util.MailDispatcher;
import com.xworkz.vacccine.util.OtpGenerator;

@Controller
public class OtpController {

	private static Integer otppNumber;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private MailDispatcher mailDispatcher;

	public OtpController() {
		LOGGER.log(Level.INFO,getClass().getSimpleName() + "object is created");
		//System.out.println(getClass().getSimpleName() + "object is created");
	}

	@RequestMapping(value = "/startotp.do")
	public String getOtp(@RequestParam String email, Model model,HttpServletRequest req) {
		LOGGER.log(Level.INFO,"invoked getOTP");
		System.out.println("invoked getOTP");
		otppNumber = OtpGenerator.randomNumberGenerator(1000, 9999);
		boolean outcome=this.mailDispatcher.SendOTP(email, "OTP_Message", "Hi Your OTP for Vaccination is  " + otppNumber);
		model.addAttribute("OtpSuccessMessage", "Your Otp sent to mail id");
		LOGGER.log(Level.INFO,"OTP is generated");
		//System.out.println("OTP is generated");
		if(outcome) {
			HttpSession session=req.openSession(true);
			session.addAttribute("email",email);
			return "home";
		}else {
			model.addAttribute("OtpSuccessMessage", "invalid email");
		}
		return "startotp.do";
	}

//	@RequestMapping(value = "/veriffyOtp.do")
//	public String verifyOtp(@RequestParam Integer otpNumber, Model model) {
//		System.out.println("invoked verifyOtp");
//		Object object=otpNumber;
//		if (otppNumber.equals(object.equals(object))) {
//			model.addAttribute("errormessage", "valid otp");
//			return "home";
//		} else {
//			model.addAttribute("errormessage", "invalid_otp try again later");
//
//			return "home2";
//		}
//
//	}

}
