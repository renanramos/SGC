package com.sgc.model.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.model.base.dao.UsuarioDAO;
import com.sgc.model.base.service.UsuarioService;
import com.sgc.model.entity.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public void create(Usuario e) {
		usuarioDAO.create(e);
	}

	@Override
	public void update(Usuario e) {
		usuarioDAO.update(e);		
	}

	@Override
	public Usuario readById(Long id) {
		return usuarioDAO.readById(id);
	}

	@Override
	public List<Usuario> readByAll() {		
		return usuarioDAO.readByAll();
	}

	@Override
	public void delete(Long id) {
		usuarioDAO.delete(id);
	}

	@Override
	public Usuario findByLogin(String usuario, String password) {
		return usuarioDAO.findByLogin(usuario, password);
	}

}
