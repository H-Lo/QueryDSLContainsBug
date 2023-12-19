package net.horvoje.querydsl.bugs.contains.repository;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import net.horvoje.querydsl.bugs.contains.entity.QUser;
import net.horvoje.querydsl.bugs.contains.entity.User;
import net.horvoje.querydsl.bugs.contains.enums.UserRole;

public class UserRepositoryImpl implements UserExtendRepository {

	private final EntityManager em;

	public UserRepositoryImpl(final EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}

    @Override
    public List<User> findUsersByRoleQueryDSL1(final UserRole userRole) {
        final QUser user = QUser.user;
        final JPAQuery<User> q =
            new JPAQueryFactory(this.em)
                .selectFrom(user)
                .where(
                    new BooleanBuilder().and(user.roles.contains(userRole)).getValue()
                );
        System.out.println();
        System.out.println("findUsersByRoleQueryDSL1() SQL = " + q);
        System.out.println();
        return q.fetch();
    }

    @Override
    public List<User> findUsersByRoleQueryDSL2(final UserRole userRole) {
        final QUser user = QUser.user;
        final JPAQuery<User> q =
            new JPAQueryFactory(this.em)
                .selectFrom(user)
                .where(
                    new BooleanBuilder().and(user.roles.any().eq(userRole)).getValue()
                );
        System.out.println();
        System.out.println("findUsersByRoleQueryDSL2() SQL = " + q);
        System.out.println();
        return q.fetch();
    }

}
