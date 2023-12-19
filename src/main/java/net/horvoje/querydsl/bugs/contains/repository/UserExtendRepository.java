package net.horvoje.querydsl.bugs.contains.repository;

import java.util.List;

import net.horvoje.querydsl.bugs.contains.entity.User;
import net.horvoje.querydsl.bugs.contains.enums.UserRole;

public interface UserExtendRepository {

	List<User> findUsersByRoleQueryDSL1(UserRole userRole);
	List<User> findUsersByRoleQueryDSL2(UserRole userRole);

}
