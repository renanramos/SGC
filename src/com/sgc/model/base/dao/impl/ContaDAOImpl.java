package com.sgc.model.base.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sgc.model.base.dao.ContaDAO;
import com.sgc.model.constants.ContaConstants;
import com.sgc.model.entity.Conta;
import com.sgc.model.rowmapper.ContaRowMapper;

@Repository
public class ContaDAOImpl implements ContaDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Conta e) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO ").append(ContaConstants.TABELA).append(" (")
		.append(ContaConstants.DESCRICAO).append(", ")
		.append(ContaConstants.VALOR).append(", ")
		.append(ContaConstants.DATA_PAGAMENTO).append(", ")
		.append(ContaConstants.DATA_VENCIMENTO).append(", ")
		.append(ContaConstants.DATA_INICIO).append(", ")
		.append(ContaConstants.DATA_FIM).append(", ")
		.append(ContaConstants.PARCELA).append(", ")
		.append(ContaConstants.FIXA).append(", ")
		.append(ContaConstants.OBSERVACAO).append(") ") 
		.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING ").append(ContaConstants.ID);
		Object args[] = {e.getDescricao(), e.getValor(), e.getDataPagamento(), e.getDataVencimento(), e.getDataInicio(), e.getDataFim(), e.getParcela(), e.isFixa(), e.getObservacao()};
		e.setId(jdbcTemplate.queryForObject(sql.toString(), args, Long.class));
	}

	@Override
	public void update(Conta e) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE ").append(ContaConstants.TABELA)
		.append(" SET ").append(ContaConstants.DESCRICAO).append(" = ?, ")
		.append(ContaConstants.VALOR).append(" = ?, ")
		.append(ContaConstants.DATA_PAGAMENTO).append(" = ?, ")
		.append(ContaConstants.DATA_VENCIMENTO).append(" = ?, ")
		.append(ContaConstants.DATA_INICIO).append(" = ?, ")
		.append(ContaConstants.DATA_FIM).append(" = ?, ")
		.append(ContaConstants.PARCELA).append(" = ?, ")
		.append(ContaConstants.FIXA).append(" = ?, ")
		.append(ContaConstants.OBSERVACAO).append(" = ? ")
		.append(" WHERE ").append(ContaConstants.ID).append(" = ? ");
		Object args[] = {e.getDescricao(), e.getValor(), e.getDataPagamento(), e.getDataVencimento(), e.getDataInicio(), e.getDataFim(), e.getParcela(), e.isFixa(), e.getObservacao(), e.getId()};
		jdbcTemplate.update(sql.toString(), args);
	}

	@Override
	public Conta readById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(ContaConstants.TABELA)
		.append(" WHERE ").append(ContaConstants.ID).append(" = ? ");
		Object args[] = {id};
		return jdbcTemplate.queryForObject(sql.toString(), args, new ContaRowMapper());
	}

	@Override
	public List<Conta> readByAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(ContaConstants.TABELA);		
		return jdbcTemplate.query(sql.toString(), new ContaRowMapper());
	}

	@Override
	public void delete(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM ").append(ContaConstants.TABELA)
		.append(" WHERE ").append(ContaConstants.ID).append(" = ? ");
		Object args[] = {id};
		jdbcTemplate.update(sql.toString(), args);
	}

	@Override
	public List<Conta> readByPeriodo(Date dataInicio, Date dataFim) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(ContaConstants.TABELA)
		.append(" WHERE ").append(" ( ").append(ContaConstants.DATA_PAGAMENTO).append(" >= ? ") // IS NULL AND (
		.append(" AND ").append(ContaConstants.DATA_PAGAMENTO).append(" <= ? ")
		.append(" ) OR ( ").append(ContaConstants.DATA_VENCIMENTO).append(" >= ? ")
		.append(" AND ").append(ContaConstants.DATA_VENCIMENTO).append(" <= ? )")
		.append(" ORDER BY ").append(ContaConstants.DATA_VENCIMENTO);
		Object args[] = {dataInicio, dataFim, dataInicio, dataFim};
		return jdbcTemplate.query(sql.toString(), args, new ContaRowMapper());
	}

	@Override
	public List<Conta> scheduleContasFixas(String data) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ").append(ContaConstants.TABELA)
		.append(" WHERE ").append("  EXTRACT( MONTH FROM ").append(ContaConstants.DATA_VENCIMENTO).append(") ")
		.append(" = EXTRACT ( MONTH FROM to_date(? ,'yyyy-MM-dd'))").append(" AND ").append(ContaConstants.FIXA).append(" =  ? ");
		Object args [] = {data, true};		
		return jdbcTemplate.query(sql.toString(), args, new ContaRowMapper());
	}
	
}
