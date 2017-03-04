package com.sgc.model;

import java.util.List;

public interface BaseService<E> {
	public void create(E e);
	public void update(E e);
	public E readById(Long id);
	public List<E> readByAll();	
	public void delete(Long id);
}
