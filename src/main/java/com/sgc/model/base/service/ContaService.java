package com.sgc.model.base.service;

import java.util.Date;
import java.util.List;

import com.sgc.model.BaseService;
import com.sgc.model.entity.Conta;

public interface ContaService extends BaseService<Conta>{
	public List<Conta> readByPeriodo(Date dataInicio, Date dataFim);
	public List<Conta> scheduleContasFixas(String data);
}
