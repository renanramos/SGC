package com.sgc.model.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.model.base.dao.ContaDAO;
import com.sgc.model.base.service.ContaService;
import com.sgc.model.entity.Conta;

@Service("contaService")
public class ContaServiceImpl implements ContaService{

	@Autowired
	private ContaDAO contaDao;
	
	@Override
	public void create(Conta e) {
		contaDao.create(e);
	}

	@Override
	public void update(Conta e) {
		contaDao.update(e);
	}

	@Override
	public Conta readById(Long id) {
		return contaDao.readById(id);
	}

	@Override
	public List<Conta> readByAll() {
		return contaDao.readByAll();
	}

	@Override
	public void delete(Long id) {
		contaDao.delete(id);
	}

	@Override
	public List<Conta> readByPeriodo(Date dataInicio, Date dataFim) {
		return contaDao.readByPeriodo(dataInicio, dataFim);
	}

	@Override
	public List<Conta> scheduleContasFixas(String data) {
		return contaDao.scheduleContasFixas(data);
	}

}
