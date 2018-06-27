package com.jreyson.spring.boot.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.jreyson.spring.boot.demo.domian.Desk;

/**
 * 用户资源库的实现�?
 * 
 * @author Administrator
 *
 */
@Repository
public class DeskRepositoryImpl implements DeskRepository {

	//计数
	private static AtomicLong counter = new AtomicLong();
	//存储用的map
	private final ConcurrentMap<Long, Desk> deskMap = new ConcurrentHashMap<>();
	
	
	@Override
	public Desk saveOrUpdateDesk(Desk desk) {
		Long id = desk.getId();
		if (id == 0) {	//新建用户
			id = counter.incrementAndGet();
			desk.setId(id);
			System.out.println(id);
		}
		this.deskMap.put(id, desk);
		return desk;
	}

	@Override
	public List<Desk> listDesk() {
		
		return new ArrayList<Desk>(this.deskMap.values());
		
	}

	@Override
	public Desk getDeskById(long id) {
		
		return this.deskMap.get(id);
	}


	
}
