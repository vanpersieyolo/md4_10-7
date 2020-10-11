package com.codegym.service.customerService;

import com.codegym.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Map.Entry;

public class StudentService implements IStudentService {
    @Autowired
    private SessionFactory sessionFactory;

    public Iterable<Student> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT c FROM Student as c", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        String queryStr = "SELECT c FROM Student AS c WHERE c.id = :id";
        TypedQuery<Student> query = entityManager.createQuery(queryStr, Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Student save(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Student delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            Student student = findById(id);
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        return null;
    }
}
