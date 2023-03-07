package project;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static boolean isLoggedIn = false;

    public static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();



    public static void loggingIn() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select from the following actions: \n Log in \n Sign up");
        String chosenOption = s.nextLine();
        if (chosenOption.equals("Log in")) {
            System.out.println("Please insert your login");
            String loginInput = s.nextLine();
            if (isAlreadySignedUp(loginInput).isEmpty()){
                System.out.println("There is no user with that email");
                return;
            }
            System.out.println("Please insert your password");
            String passwordInput = s.nextLine();
            User temporaryUser = loginUser(loginInput);
            if (temporaryUser.getPassword().equals(passwordInput)){
                isLoggedIn = true;
            } else {
                System.out.println("Incorrect password or login");
            }
        } else if (chosenOption.equals("Sign up")) {
            final String reqex = "^(.+)@(.+)$";   //^ - oznacza że na początku,(.+) - dowolny symbol użyty co najmniej raz, $ - sprawdzenie końca linii
            System.out.println("Enter your email: ");
            String newEmail = s.nextLine();
            Pattern pattern = Pattern.compile(reqex);
            Matcher matcher = pattern.matcher(newEmail);
            if (!matcher.matches()){
                System.out.println("Unacceptable email format");
                return;
            }
            if (!isAlreadySignedUp(newEmail).isEmpty()){
                System.out.println("There is already a user with that email: " + newEmail);
                return;
            }
            System.out.println("Enter password: ");
            String newPassword = s.nextLine();
            if (newPassword.isEmpty()){
                System.out.println("Please enter a password");
                return;
            }
            createNewUser(newEmail,newPassword);
            System.out.println("You have successfully created your account, you may now log in on main site");
        }else {
            System.out.println("Incorrect action");
        }
    }

    public static User loginUser(String loginInput){
        return entityManager.createQuery("from User u where u.login = :loginInput", User.class)
                .setParameter("loginInput", loginInput)
                .getSingleResult();
    }
    public static List<User> isAlreadySignedUp(String newEmail){
        return  entityManager.createQuery("from User u where u.login = :newEmail", User.class)
                .setParameter("newEmail",newEmail )
                .getResultList();
    }
    public static void createNewUser(String newEmail, String newPassword){
        entityManager.getTransaction().begin();
        User user = new User();
        user.setLogin(newEmail);
        user.setPassword(newPassword);
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }
    public static void main(String[] args) {
        entityManager.getTransaction().begin();
        User user1 = new User("jan@gmail.com","12345",2000,"jan","Kowalski","987654321", new ArrayList<>());
        User user2 = new User("adam@gmail.com","12345",2000,"jan","Kowalski","987654321", new ArrayList<>());
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        while(!isLoggedIn) {
            loggingIn();
        }
        System.out.println("Log in: " + isLoggedIn);




        entityManager.close();

    }
}
