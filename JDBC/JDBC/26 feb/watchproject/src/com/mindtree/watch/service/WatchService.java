package com.mindtree.watch.service;

import java.util.ArrayList;
import java.util.Set;

import com.mindtree.watch.entity.Type;
import com.mindtree.watch.entity.Watch;
import com.mindtree.watch.exception.ServiceException;

public interface WatchService {

	public int addType(int tid, String type)throws ServiceException;

	public int addwatch(int wid, String wname, double wprice, int tid) throws ServiceException;

	public Set<Type> fetchTypes()throws ServiceException;

	public boolean check(Set<Type> type, int tid)throws ServiceException;

	public Set<Watch> fetchwatch()throws ServiceException;

	public ArrayList<Watch> sort(Set<Watch> watch)throws ServiceException;

	public int delete(String tname)throws ServiceException;

//	public ArrayList<TypeWatch> fetch()throws ServiceException;
//
//	public ArrayList<TypeWatch> sortAllonPrice(ArrayList<TypeWatch> l)throws ServiceException;
//
//	public int delete(String wmodelname)throws ServiceException;

}
