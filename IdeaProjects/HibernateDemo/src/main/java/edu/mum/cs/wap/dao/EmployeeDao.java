package edu.mum.cs.wap.dao;

import com.fasterxml.classmate.AnnotationConfiguration;
import edu.mum.cs.wap.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class EmployeeDao {
    private static SessionFactory sessionFactory;
    public void addEmployee(String employeeName, int salary){
        try{
            // 3. Get Session object
            Session session = getSessionFactory().openSession();

            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            Employee emp = new Employee();
            emp.setEmployeeName(employeeName);
            emp.setSalary(salary);

            session.save(emp);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
        }
        catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }
    public static SessionFactory getSessionFactory() {

        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(edu.mum.cs.wap.model.Employee.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactory;
    }
}
