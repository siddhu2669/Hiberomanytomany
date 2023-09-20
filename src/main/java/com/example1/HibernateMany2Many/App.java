package com.example1.HibernateMany2Many;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example1.HibernateMany2Many.HibernateUtil;
import com.example1.model.Course;
import com.example1.model.Student;



/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        try 
        {
        session.beginTransaction();
        Student s1=new Student();
        s1.setName("John");
        Student s2=new Student();
        s2.setName("Emma");
        
        Course c1=new Course();
        c1.setCourseName("Java");
        Course c2=new Course();
        c2.setCourseName("C++");
        
       s1.getCourses().add(c1);
       s1.getCourses().add(c2);
       s2.getCourses().add(c2);
        
        session.save(s1);
        session.save(s2);
        session.save(c1);
        session.save(c2);
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	sessionFactory.close();
        }    
    }
}

