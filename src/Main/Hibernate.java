package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lukak
 */
public class Hibernate {

    public static void main(String[] args) {
        //Create seession factory object and configure
        // Add name of class which you want co configue
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // Create session 
        try {
            Session sesija = factory.getCurrentSession();
            //Create object
            System.out.println("Creating the new user...");
            User korisnik = new User("Luka", "Kurcubic", "Luka92@gmail.com");
            //Begin transaction
            sesija.beginTransaction();
            //Commit transaction
            sesija.getTransaction().commit();
            System.out.println("Saving user....");
            sesija.save(korisnik);
            System.out.println("User is saved :)");

        } finally {
            factory.close();
        }
    }

}
