package com.twg.springboot.services;

import java.util.List;

import com.twg.springboot.entities.Entry;

public interface EntryService {
	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findById(Long id);
	public List<Entry> findAll();
	public List<Entry> findByUserId(Long id);

}
