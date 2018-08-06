package com.sgc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sgc.model.base.service.UsuarioService;
import com.sgc.model.entity.Usuario;

@Controller
public class HomeController {
		
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "home/login", method = RequestMethod.POST)
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession session){
		
		String retorno = "redirect:/";
		
		Usuario user = (Usuario) session.getAttribute("usuarioLogado");
		
		if(user == null){
			user = usuarioService.findByLogin(usuario, password);
			if(user != null){
				session.setAttribute("usuarioLogado", user);
				retorno = "redirect:/conta/filtro";	
			}
		}		
		return retorno;
	}
		
	@RequestMapping("usuario/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model, HttpSession session){
		ModelAndView mv = new ModelAndView("/");
		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session){
		ModelAndView mv = new ModelAndView("home/home");
		return mv;
	}	
	
}
