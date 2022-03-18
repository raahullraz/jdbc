package com.mindtree.watch.client;


import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.watch.entity.Type;
import com.mindtree.watch.entity.Watch;
import com.mindtree.watch.exception.ApplicationException;
import com.mindtree.watch.exception.ServiceException;
import com.mindtree.watch.exception.TypeNotFoundException;
import com.mindtree.watch.service.WatchService;
import com.mindtree.watch.service.serviceimpll.WatchImplementation;;
public class ApplicationUser 
{
	public static void main(String [] rahul) throws ApplicationException
	{
		WatchService obj = new WatchImplementation();
		
		Set<Type> type = new HashSet<Type>();
		
		Set<Watch> watch = new HashSet<Watch>();
		
		Scanner s = new Scanner(System.in);
		
		int v=0;
		while(v==0)
	{
			
		System.out.println("1.add type");
		System.out.println("2.add (update)watch(perticular type) and ask TYPE of watch,if not throw exception");
		System.out.println("3.sort all watch based on price");
		System.out.println("4.delete perticular type and all types of that user given shold be deleted");
		System.out.println("5.exit");

		System.out.println("-------enter your choice-------");
		
		int opt = s.nextInt();
		switch(opt)
		{
		case 1:
		{
			
		try {
			System.out.println("Enter tid");
			int tid = s.nextInt();
			s.nextLine();
			
			System.out.println("Enter type to insert");
			String watchtype = s.nextLine();

	
			int k = obj.addType(tid,watchtype);
			
			System.out.println(k+" rows effected");
		}
		catch(ServiceException t)
		{
			throw new ApplicationException(t.getMessage());	
		}
			break;
		}
		case 2:
		{
			type = obj.fetchTypes();

			System.out.println("Enter tid");
			int tid = s.nextInt();
			
			try {
					boolean b = obj.check(type,tid);
					if(b==true)
					{		
								System.out.println("Enter watch id");
								int wid = s.nextInt();
								s.nextLine();
								
								System.out.println("Enter watch name");
								String wname = s.nextLine();
								
								System.out.println("Enter price");
								double wprice = s.nextDouble();
								
								try {		
										int k = obj.addwatch(wid,wname,wprice,tid);
										System.out.println(k+" rows effected");
									}
									catch(ServiceException t)
									{
											throw new ApplicationException(t.getMessage());
									}
					}
				}
			catch(ServiceException e)
			{
					try {
							throw new TypeNotFoundException(e.getMessage());
						}
					catch(ApplicationException y)
					{
						System.out.println("not there that tid");
					}
			}

			break;
		}
		case 3:
		{
			watch = obj.fetchwatch();
			ArrayList<Watch> w = new ArrayList<Watch>();
			w = obj.sort(watch);
			System.out.println(w);
			break;
		}
		case 4:
		{
			s.nextLine();
			watch = obj.fetchwatch();
			System.out.println("Enter typename");
			String tname = s.nextLine();
			
			try {
				int k = obj.delete(tname);
				System.out.println(k+" rows effected");
			}
			catch(ServiceException p)
			{
				try {
					throw new ApplicationException(p.getMessage());
				}
				catch(ApplicationException i)
				{
					System.out.println(i.getMessage());
				}
			}
			
			break;
		}

		case 5:
		{
			System.out.println("Exit Successfully");
			v++;
			break;
		}
		default :
		{
			System.out.println("enter valid input");
		}
	}
	}
	}

	}

