package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import biz.userBiz;
import pojo.user;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userBiz uBiz;
	
	public void setuBiz(userBiz uBiz) {
		this.uBiz = uBiz;
	}
	
	@RequestMapping("/login")
	public String fd() {
		return "login";
	}

	@RequestMapping(value="/dologin")
	public String login(@RequestParam String username,@RequestParam String password,HttpSession session) {
		user u=new user();
		u.setUsername(username);
		u.setPassword(password);
		if(uBiz.queryByName(u)!=null) {
			session.setAttribute("user", u);
			return "list";
		}else {
			return "redirect:/user/login";
		}
	}
}
