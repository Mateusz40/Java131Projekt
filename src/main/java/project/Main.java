package project;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean isLoggedIn = false;

    public static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public static void loggingIn() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select 1 of the following actions \n Log in \n Sign up");
        String chosenOption = s.nextLine();
        if (chosenOption.equals("Log in")) {
            System.out.println("Please insert your login");
            String loginInput = s.nextLine();
            System.out.println("Please insert your password");
            String passwordInput = s.nextLine();
            User temporaryUser = loginUser(loginInput);
            if (temporaryUser.getPassword().equals(passwordInput)){
                isLoggedIn = true;
            } else {
                System.out.println("Incorrect password or login");
            }
        } else if (chosenOption.equals("Sign up")) {

        }else {
            System.out.println("Incorrect action");
        }
    }


    public static User loginUser(String loginInput){
        return entityManager.createQuery("from User u where u.login = :loginInput", User.class)
                .setParameter("loginInput", loginInput)
                .getSingleResult();
    }
    public static void main(String[] args) {
        entityManager.getTransaction().begin();
        User user1 = new User("jan@gmail.com","12345",2000,"jan","Kowalski","987654321", new ArrayList<>());
        User user2 = new User("adam@gmail.com","12345",2000,"jan","Kowalski","987654321", new ArrayList<>());
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        loggingIn();
        System.out.println(isLoggedIn);



        entityManager.close();

    }
}
