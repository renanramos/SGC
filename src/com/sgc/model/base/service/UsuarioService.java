package com.sgc.model.base.service;

import com.sgc.model.BaseService;
import com.sgc.model.entity.Usuario;

public interface UsuarioService extends BaseService<Usuario>{
	public Usuario findByLogin(String usuario, String password);
}
