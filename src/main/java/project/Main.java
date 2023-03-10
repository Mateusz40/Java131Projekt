package project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static boolean isLoggedIn = false;
    static boolean isAdministrator = false;
    static boolean isServiceAssistant = false;
    static User loggedUser;

    public static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();



    public static void loggingIn() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select from the following actions: \n Log in \n Sign up");
        String chosenOption = s.nextLine();
        if (chosenOption.equalsIgnoreCase("Log in")) {

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
                switch (temporaryUser.getUserType()){
                    case SERVICEASSISTANT -> {
                        isServiceAssistant = true;
                        isLoggedIn = true;
                        loggedUser = temporaryUser;
                    }
                    case ADMINISTRATOR -> {
                        isAdministrator = true;
                        isLoggedIn = true;
                        loggedUser = temporaryUser;
                    }
                    default -> {
                        isLoggedIn = true;
                        loggedUser = temporaryUser;
                    }
                }
            } else {
                System.out.println("Incorrect password or login");
            }
        } else if (chosenOption.equalsIgnoreCase("Sign up")) {
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
    public static void userMenu(User loggedUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + loggedUser.getName() + " \n Select an action number from the following list: \n" +
                " 1. Change of account data \n 2. Purchase, or return of a ticket \n 3. Account crediting \n 4. Contact a flight assistant");
        System.out.print("Action number: ");
        int actionNumber = scanner.nextInt();
        switch (actionNumber){
            case 1 -> {
                System.out.println("Which information would you like to change: \n Name \n Surname \n Password \n Passport");
                String actionType = scanner.next();
                switch (actionType){
                    case "name" -> {
                        System.out.println("Please enter new name: ");
                        loggedUser.setName(scanner.next());
                        entityManager.getTransaction().begin();
                       Query query = entityManager.createQuery("update User u set u.name = :new where u.login = :login")
                                .setParameter("new", loggedUser.getName())
                                .setParameter("login", loggedUser.getLogin());
                       int result = query.executeUpdate();
                        entityManager.getTransaction().commit();
                        System.out.println("Your name was successfully changed");
                        System.out.println("Your name is from now: " + loggedUser.getName());
                    }
                    case "surname" ->{
                        System.out.println("Please enter new surname: ");
                        loggedUser.setSurname(scanner.next());
                        entityManager.getTransaction().begin();
                        Query query = entityManager.createQuery("update User u set u.surname = :new where u.login = :login")
                                .setParameter("new", loggedUser.getSurname())
                                .setParameter("login", loggedUser.getLogin());
                        entityManager.getTransaction().commit();
                        System.out.println("Your surname was successfully changed");
                        System.out.println("Your surname is from now: " + loggedUser.getSurname());
                    }
                    case "password" ->{
                        System.out.println("Please enter new password");
                        String temporaryPassword = scanner.next();
                        if (loggedUser.getPassword().equals(temporaryPassword)){
                            System.out.println("You already have this password");
                        }else loggedUser.setPassword(temporaryPassword);
                        entityManager.getTransaction().begin();
                        Query query = entityManager.createQuery("update User u set u.password = :new where u.login = :login")
                                .setParameter("new", loggedUser.getPassword())
                                .setParameter("login", loggedUser.getLogin());
                        int result = query.executeUpdate();
                        entityManager.getTransaction().commit();
                        System.out.println("Your password was successfully changed");
                        System.out.println("Your password is from now: " + loggedUser.getPassword());
                    }
                    case "passport" ->{
                        System.out.println("Please enter your passport number: ");
                        loggedUser.setPassportNumber(scanner.next());
                        entityManager.getTransaction().begin();
                        Query query = entityManager.createQuery("update User u set u.passportNumber = :new where u.login = :login")
                                .setParameter("new", loggedUser.getPassportNumber())
                                .setParameter("login", loggedUser.getLogin());
                        int result = query.executeUpdate();
                        entityManager.getTransaction().commit();
                        System.out.println("Your passport number was successfully changed");
                        System.out.println("Your passport number is from now: " + loggedUser.getPassportNumber());
                    }
                    default -> System.out.println("Declared incorrect action");
                }
            }
            case 2 -> {
                Ticket ticket = new Ticket();
                ticket.buyTicket(loggedUser);
            }
            case 3 -> {
                loggedUser.addToWallet(scanner.nextLong());
            }
            case 4 -> {

            }
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
        User user2 = new User("adam@gmail.com","12345",500,"adam","Siekera","123456789", new ArrayList<>());
        Administrator administrator = new Administrator();
        administrator.setLogin("admin");
        administrator.setPassword("admin");
        ServiceAssistant serviceAssistant = new ServiceAssistant();
        serviceAssistant.setLogin("service");
        serviceAssistant.setPassword("service");
        entityManager.persist(serviceAssistant);
        entityManager.persist(administrator);
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        while(!isLoggedIn) {
            loggingIn();
        }
        while(isLoggedIn && !isServiceAssistant && !isAdministrator){
            userMenu(loggedUser);
        }
        System.out.println("Log in: " + isLoggedIn);
        System.out.println("service assistant = " + isServiceAssistant);
        System.out.println("administrator = " + isAdministrator);




        entityManager.close();

    }
}
