package com.example.hibernate.exercise.hibexercise;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Event;
import com.example.model.EventDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
    	final Logger log = Logger.getLogger(App.class.getName());
    	ApplicationContext appCntxt = new ClassPathXmlApplicationContext("Beans.xml");
        EventDaoImpl eve = appCntxt.getBean("eveDaoImpl", EventDaoImpl.class);
        Event demoEve=new Event("abcd","movie","bangalore",500,100);
        eve.insertEvent(demoEve); 
        List<Event> eveList=eve.getAllEvents();
    	System.out.println("\nPrinting all the events");
        for(int i=0;i<eveList.size();i++)
        {
        	log.info(eveList.get(i).toString());
        	System.out.println(eveList.get(i).toString());
        }
        
        List<Event> eveList1=eve.getByEventType("sports");
    	System.out.println("\nPrinting all the events by type equals sports");
        for(int i=0;i<eveList1.size();i++)
        {
        	log.info(eveList1.get(i).toString());
        	System.out.println(eveList1.get(i).toString());
        }
        
        List<Event> eveList2=eve.getByCity("kolkata");
    	System.out.println("\nPrinting all the events by city equals kolkata");
        for(int i=0;i<eveList2.size();i++)
        {
        	log.info(eveList2.get(i).toString());
        	System.out.println(eveList2.get(i).toString());
        }
        
        List<Event> eveList3=eve.getById(1);
    	System.out.println("\nPrinting the event with id");
        for(int i=0;i<eveList3.size();i++)
        {
        	log.info(eveList3.get(i).toString());
        	System.out.println(eveList3.get(i).toString());
        }
        eve.updateEvent("abcd", "pk");
        eve.deleteEvent("pk");
    }
}
