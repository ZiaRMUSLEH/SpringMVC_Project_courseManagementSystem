package com.tpe.repository;

import com.tpe.domain.Course;
import com.tpe.exception.ResourceNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save (Course course) {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.saveOrUpdate(course);
    tx.commit();
    session.close();
    }

    @Override
    public List<Course> getAll () {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Course> coursesList = session.createQuery("FROM Course").getResultList();
        tx.commit();
        session.close();
        return coursesList;
    }

    @Override
    public Optional<Course> getById (Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.get(Course.class,id);
        Optional optionalCourse = Optional.ofNullable(course);
        tx.commit();
        session.close();
        return optionalCourse;
    }

    @Override
    public void delete (Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.load(Course.class,id);
        session.delete(course);
        tx.commit();
        session.close();
    }

//    @Override
//    public void update (Long id) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        Course course = session.get(Course.class,id);
//
//        session.update(course);
//        tx.commit();
//        session.close();
//    }
}
