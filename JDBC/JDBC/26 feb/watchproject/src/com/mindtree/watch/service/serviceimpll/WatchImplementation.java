package com.mindtree.watch.service.serviceimpll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.mindtree.watch.DAO.DAOWatch;
import com.mindtree.watch.DAO.DAOImplementation.DAOImplementation;
import com.mindtree.watch.entity.Type;
import com.mindtree.watch.entity.Watch;
import com.mindtree.watch.exception.DAOException;
import com.mindtree.watch.exception.ServiceException;
import com.mindtree.watch.service.WatchService;
import com.mindtree.watch.service.serviceimpll.*;

public class WatchImplementation implements WatchService {

	DAOWatch obj = new DAOImplementation();

	@Override
	public int addType(int tid, String type) throws ServiceException {
		int k = 0;
		try {
			k = obj.addType(tid, type);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return k;
	}

	@Override
	public int addwatch(int wid, String wname, double wprice, int tid) throws ServiceException{
		int k;
		try {
			k = obj.addwatch(wid,wname,wprice,tid);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return k;
	}

	@Override
	public Set<Type> fetchTypes() throws ServiceException {
		Set<Type> type = new HashSet<Type>();
		try {
			type = obj.fetchTypes();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return type;
	}

	@Override
	public boolean check(Set<Type> type, int tid) throws ServiceException {
		boolean k = false;
		for(Type i : type)
		{
			if(i.getTid()==tid)
			{
				k=true;
			}
		}
		if(k==true)
			return k;
		else
		{
			throw new ServiceException("tid is not there");
		}
		
	}

	@Override
	public Set<Watch> fetchwatch() throws ServiceException {
		Set<Watch> watch = new HashSet<Watch>();
		try {
			watch = obj.fetchwatch();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return watch;
	}

	@Override
	public ArrayList<Watch> sort(Set<Watch> watch) throws ServiceException {
		ArrayList<Watch> w = new ArrayList<Watch>(watch);
		Collections.sort(w);
		return w;
	}

	@Override
	public int delete(String tname) throws ServiceException {
		int k;
		try {
			k = obj.delete(tname);
		} catch (DAOException e) {
		throw new ServiceException(e.getMessage());
		}
		return k;
	}

}
