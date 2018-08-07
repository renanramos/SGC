package com.sgc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sgc.model.base.service.UsuarioService;
import com.sgc.model.entity.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@RequestMapping(value = "usuario", method = RequestMethod.GET)
	public ModelAndView findAllUsuarios(HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		ModelAndView mv = new ModelAndView("index");
		
		if (usuario != null){
			mv = new ModelAndView("usuario/usuarioList");
			List<Usuario> usuarios = usuarioService.readByAll();		
			mv.addObject("usuarios", usuarios);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "usuario/novo")
	public ModelAndView novoUsuario(HttpSession session){
		ModelAndView mv = new ModelAndView("usuario/usuarioForm");		
		return mv;
	}
	
	@RequestMapping(value = "usuario/novo", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute Usuario user, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		String retorno = "redirect:/";
		if(usuario != null){
			retorno = "redirect:/usuario/novo";
			if (user != null){
				usuarioService.create(user);
				retorno = "redirect:/usuario";
			}
		}		
		return retorno;
	}

	@RequestMapping(value = "usuario/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarUsuario(@PathVariable Long id, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		ModelAndView mv = new ModelAndView("index");
		if (usuario != null){
			mv = new ModelAndView("usuario/usuarioForm");
			Usuario user = usuarioService.readById(id);
			if (user != null){
				mv.addObject("usuario", user);
			}else{
				mv = new ModelAndView("usuario/usuarioList");
			}
		}		
		return mv;
	}
	
	@RequestMapping(value = "usuario/{id}/editar", method = RequestMethod.POST)
	public String updateUsuario(@ModelAttribute Usuario user, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		String retorno = "redirect:/index";
		if (usuario != null){
			if (user != null){
				usuarioService.update(user);
			}
			retorno = "redirect:/usuario";
		}		
		return retorno;
	}
		
	@RequestMapping(value = "usuario/{id}/excluir", method = RequestMethod.GET)
	public String deleteUsuario(@PathVariable Long id, HttpSession session){
		usuarioService.delete(id);
		return "redirect:/usuario";
	}
	
}
