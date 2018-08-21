package lk.ijse.comp.db;

import lk.ijse.comp.entity.AllocateStatus;
import lk.ijse.comp.entity.Branch;
import lk.ijse.comp.entity.Employee;
import lk.ijse.comp.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .loadProperties("application.properties").build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(AllocateStatus.class)

                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    }

