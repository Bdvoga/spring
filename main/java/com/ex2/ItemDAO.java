package com.ex2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemDAO {
    SessionFactory sessionFactory;
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public Item update(Item item) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            session.get(Item.class, item.getId()).setName(item.getName());
            session.get(Item.class, item.getId()).setDescription(item.getDescription());
            session.get(Item.class, item.getId()).setLastUpdateDate(item.getLastUpdateDate());

            tr.commit();

            return findById(item.getId());
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }

        return null;
    }

    public Item save(Item item) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(item);
            tr.commit();

            return findById(item.getId());
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }

        return null;
    }

    public void delete(Long id) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            if (findById(id) != null) {
                session.delete(findById(id));
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
    }

    public Item findById(Long id) {
        Session session = createSessionFactory().openSession();

        Item item = session.get(Item.class, id);
        session.close();

        return item;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            //регистрируем драйвер
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class" + JDBC_DRIVER + " not found");
            }

            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }
}