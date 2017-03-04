package com.sgc.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sgc.model.constants.UsuarioConstants;
import com.sgc.model.entity.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int numRow) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getLong(UsuarioConstants.ID));
		u.setNome(rs.getString(UsuarioConstants.NOME));
		u.setPassword(rs.getString(UsuarioConstants.PASSWORD));
		u.setUsuario(rs.getString(UsuarioConstants.USUARIO));
		return u;
	}

}
