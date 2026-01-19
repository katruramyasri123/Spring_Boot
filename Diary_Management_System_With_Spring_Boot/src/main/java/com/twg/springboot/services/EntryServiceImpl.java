package com.twg.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.entities.Entry;
import com.twg.springboot.repository.EntryRepo;
@Service
public class EntryServiceImpl implements EntryService {
	@Autowired
	private EntryRepo entryRepo;

	public EntryRepo getEntryRepo() {
		return entryRepo;
	}

	public void setEntryRepo(EntryRepo entryRepo) {
		this.entryRepo = entryRepo;
	}

	@Override
	public void save(Entry entry) {
		 entryRepo.save(entry);
	}
	

	@Override
	public void update(Entry entry) {
 entryRepo.save(entry);

	}

	@Override
	public void delete(Entry entry) {
entryRepo.delete(entry);		
	}

	@Override
	public Entry findById(Long id) {
		return entryRepo.findById(id).get();
	}

	@Override
	public List<Entry> findAll() {
		return entryRepo.findAll();
	}

	@Override
	public List<Entry> findByUserId(Long id) {
		return entryRepo.findByUserId(id);
	}

}
