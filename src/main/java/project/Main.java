package project;

import javax.persistence.EntityManager;

public class Main {
    static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    public static void main(String[] args) {

    }
}
