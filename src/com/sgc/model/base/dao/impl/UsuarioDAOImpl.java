package com.sgc.model.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sgc.model.base.dao.UsuarioDAO;
import com.sgc.model.constants.UsuarioConstants;
import com.sgc.model.entity.Usuario;
import com.sgc.model.rowmapper.UsuarioRowMapper;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Usuario e) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO ").append(UsuarioConstants.TABELA).append(" (")
		.append(UsuarioConstants.NOME + ", ")
		.append(UsuarioConstants.PASSWORD + ", ")
		.append(UsuarioConstants.USUARIO).append(") ")
		.append(" VALUES (?, ?, ?) RETURNING ").append(UsuarioConstants.ID);
		Object args[] = {e.getNome(), e.getPassword(), e.getUsuario()};		
		e.setId(jdbcTemplate.queryForObject(sql.toString(), args, Long.class));
	}

	@Override
	public void update(Usuario e) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE ").append(UsuarioConstants.TABELA)
		.append(" SET ").append(UsuarioConstants.NOME).append(" = ?, ")
		.append(UsuarioConstants.USUARIO).append(" = ?, ")
		.append(UsuarioConstants.PASSWORD).append(" = ? ")
		.append(" WHERE ").append(UsuarioConstants.ID).append(" = ? ");
		Object args[] = {e.getNome(), e.getUsuario(), e.getPassword(), e.getId()};
		jdbcTemplate.update(sql.toString(), args);
	}

	@Override
	public Usuario readById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(UsuarioConstants.TABELA)
		.append(" WHERE ").append(UsuarioConstants.ID).append(" = ? ");	
		Object arg[] = {id};
		return jdbcTemplate.queryForObject(sql.toString(), arg, new UsuarioRowMapper());
	}

	@Override
	public List<Usuario> readByAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(UsuarioConstants.TABELA)
		.append(" ORDER BY ").append(UsuarioConstants.ID);
		return jdbcTemplate.query(sql.toString(), new UsuarioRowMapper());
	}

	@Override
	public void delete(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM ").append(UsuarioConstants.TABELA)
		.append(" WHERE ").append(UsuarioConstants.ID).append(" = ?");
		Object args[] = {id};
		jdbcTemplate.update(sql.toString(), args);
	}

	@Override
	public Usuario findByLogin(String usuario, String password) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(UsuarioConstants.TABELA)
		.append(" WHERE ").append(UsuarioConstants.USUARIO).append(" = ? ").append(" AND ")
		.append(UsuarioConstants.PASSWORD).append(" = ? ");
		Object args[] = {usuario, password};		
		return jdbcTemplate.queryForObject(sql.toString(), args, new UsuarioRowMapper());
	}

}
