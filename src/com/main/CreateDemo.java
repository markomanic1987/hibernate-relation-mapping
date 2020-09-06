package com.main;

import com.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.nio.charset.CoderResult;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstuctorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session= factory.getCurrentSession();

        try{
            session.beginTransaction();
            /*
            Course tempCourse = new Course("Java begginer");
           session.save(tempCourse);
            Student tempStudent1= new Student("Marko","manic","marko@gmail.co,");
            Student tempStudent2= new Student("Jovana","zarkov","jovana@gmail.co,");
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("saved students "+tempCourse.getStudents());
            int theId=2;
            Student tempStudent = session.get(Student.class,theId);
            System.out.println(tempStudent);
            System.out.println("course "+ tempStudent.getCourses());
            Course tempCourse =new Course("Rubics cube");
            Course tempCourse1 =new Course("Learnig to play world of tanks");
            tempCourse.addStudent(tempStudent);
            tempCourse1.addStudent(tempStudent);
            session.save(tempCourse);
            session.save(tempCourse1); */
            int theId=1;
            Student tempStudent = session.get(Student.class,theId);
            session.delete(tempStudent);


            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }


    }
}
