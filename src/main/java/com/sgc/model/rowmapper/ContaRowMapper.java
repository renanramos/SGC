package com.sgc.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sgc.model.constants.ContaConstants;
import com.sgc.model.entity.Conta;

public class ContaRowMapper implements RowMapper<Conta>{

	@Override
	public Conta mapRow(ResultSet rs, int numRow) throws SQLException {
		
		Conta conta = new Conta();
		conta.setId(rs.getLong(ContaConstants.ID));
		conta.setDescricao(rs.getString(ContaConstants.DESCRICAO));
		conta.setValor(rs.getDouble(ContaConstants.VALOR));
		conta.setDataPagamento(rs.getDate(ContaConstants.DATA_PAGAMENTO));
		conta.setDataVencimento(rs.getDate(ContaConstants.DATA_VENCIMENTO));
		conta.setDataInicio(rs.getDate(ContaConstants.DATA_INICIO));
		conta.setDataFim(rs.getDate(ContaConstants.DATA_FIM));
		conta.setParcela(rs.getInt(ContaConstants.PARCELA));
		conta.setFixa(rs.getBoolean(ContaConstants.FIXA));
		conta.setObservacao(rs.getString(ContaConstants.OBSERVACAO));
		return conta;
	}

}
