package com.sgc.model.base.dao;

import com.sgc.model.BaseDAO;
import com.sgc.model.entity.Usuario;

public interface UsuarioDAO extends BaseDAO<Usuario>{
	public Usuario findByLogin(String usuario, String password);
}
