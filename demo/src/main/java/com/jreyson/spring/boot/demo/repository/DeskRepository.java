package com.jreyson.spring.boot.demo.repository;

import java.util.List;

import com.jreyson.spring.boot.demo.domian.Desk;

/**
 * Desk Repository 接口
 * 
 * @author Administrator
 *
 */
public interface DeskRepository {

	Desk saveOrUpdateDesk(Desk desk);

	List<Desk> listDesk();
	
	Desk getDeskById(long id);
	
}
