package net.horvoje.querydsl.bugs.contains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.horvoje.querydsl.bugs.contains.enums.UserRole;
import net.horvoje.querydsl.bugs.contains.repository.UserExtendRepository;
import net.horvoje.querydsl.bugs.contains.repository.UserRepositoryImpl;

public class App {

    public static void main(final String[] args) {
    	try (final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPersistenceUnit")) {
			final UserExtendRepository repo = new UserRepositoryImpl(emf);
			final SessionFactory factory = SessionFactoryMaker.getFactory();
			try (final Session session = factory.openSession()) {
				final Transaction tx = session.beginTransaction();
				case1(repo);
				case2(repo);
				tx.commit();
			}
		}
    }

	private static void case1(final UserExtendRepository repo) {
		try {
			// org.hibernate.query.SemanticException:
			// Operand of 'member of' operator must be a plural path
			repo.findUsersByRoleQueryDSL1(UserRole.ROLE_ADMIN);
		}
		catch (final java.lang.IllegalArgumentException e) {
			System.out.println(); e.printStackTrace(); System.out.println();
		}
	}

	private static void case2(final UserExtendRepository repo) {
		try {
			// org.hibernate.query.QueryArgumentException:
			// Argument [ROLE_ADMIN] of type [net.horvoje.querydsl.bugs.contains.enums.UserRole] did not match parameter type [java.util.Set (n/a)]
			repo.findUsersByRoleQueryDSL2(UserRole.ROLE_ADMIN);
		}
		catch (final org.hibernate.query.QueryArgumentException e) {
			System.out.println(); e.printStackTrace(); System.out.println();
		}
	}

}
