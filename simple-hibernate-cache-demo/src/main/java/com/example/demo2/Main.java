package com.example.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Book.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb")
                .setProperty("hibernate.hbm2ddl.auto", "create-drop")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                 .setProperty("hibernate.cache.use_second_level_cache", "true")
                .setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory")
                .setProperty("net.sf.ehcache.configurationResourceName", "/ehcache.xml");


        SessionFactory factory = cfg.buildSessionFactory();


        Session session1 = factory.openSession();
        session1.beginTransaction();
        Book book = new Book("Hibernate in Action");
        session1.persist(book);
        session1.getTransaction().commit();

        // L1 кэш демо
        Session session2 = factory.openSession();
        session2.beginTransaction();
        System.out.println("\nL1 cache test:");
        Book b3 = session2.find(Book.class, book.getId()); // из бд, SQL будет
        System.out.println(b3);
        Book b4 = session2.find(Book.class, book.getId()); // из L1 кэша
        System.out.println(b4);
        System.out.println("b3 == b4: " + (b3 == b4)); // true
        session2.getTransaction().commit();
        session2.close();

        // L2
        Session session3 = factory.openSession();
        session3.beginTransaction();
        System.out.println("\nL2 cache test:");
        Book b5 = session3.find(Book.class, book.getId()); // SQL НЕ будет, берётся из L2
        System.out.println(b5);
        session3.getTransaction().commit();
        session3.close();

        factory.close();
    }
}
