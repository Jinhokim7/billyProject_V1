package com.billy.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userLoginController {
	
//	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
//	public String loginAction(HttpSession session,
//						@RequestParam("id") String id, 
//						@RequestParam("pwd") String pwd) {
//		System.out.println(id+"--로그인 아이디넘어가는지 디버깅");
//		System.out.println(pwd+"--로그인 비밀번호넘어가는지 디버깅");
//		
//		
//		
//		/*
//		 * if(id.equals("ttt")) { if(session.getAttribute("login") !=null) {
//		 * session.removeAttribute("login"); } session.setAttribute("login", id); }else
//		 * { System.out.println("로그인 실패"); }
//		 */
//		return "redirect:/home";
//	}
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/home";
//	}
}
