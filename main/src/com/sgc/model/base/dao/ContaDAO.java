package com.sgc.model.base.dao;

import java.util.Date;
import java.util.List;

import com.sgc.model.BaseDAO;
import com.sgc.model.entity.Conta;

public interface ContaDAO extends BaseDAO<Conta>{
	public List<Conta> readByPeriodo(Date dataInicio, Date dataFim);
	public List<Conta> scheduleContasFixas(String data);
}
