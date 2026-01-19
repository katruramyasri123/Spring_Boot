package com.twg.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.twg.springboot.entities.Entry;

public interface EntryRepo extends JpaRepository<Entry, Long> {
	@Query(value="select * from entry where userid=:id", nativeQuery = true)
	public List<Entry> findByUserId(Long id);

}
