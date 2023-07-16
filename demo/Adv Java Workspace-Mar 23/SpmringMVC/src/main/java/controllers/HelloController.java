package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String sayHello()
	{
		return "hello";   //view name
	}
	
	/*
	@RequestMapping(value="/hello",method = RequestMethod.POST)
	public String sayHello1()
	{
		return "hello";
	}
	*/
	
	@RequestMapping("/info")
	public ModelAndView getInfo(HttpServletRequest request)
	{
		String msg="Welcome "+request.getParameter("name");
		return new ModelAndView("info","msg",msg);  //
	}
	
	@RequestMapping("/req_info")
	public String getRequestInfo(HttpServletRequest req, ModelMap map)
	{
		map.addAttribute("r_path", req.getContextPath());
		map.addAttribute("r_method", req.getMethod());
		map.addAttribute("r_ctype", req.getContentType());
		map.addAttribute("r_header", req.getHeader("user-agent"));
		return "req_info";
	}
	
	
	
	
}
