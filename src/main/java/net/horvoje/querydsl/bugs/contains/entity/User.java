package net.horvoje.querydsl.bugs.contains.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.horvoje.querydsl.bugs.contains.converter.UserRolesConverter;
import net.horvoje.querydsl.bugs.contains.enums.UserRole;

@Entity
@NoArgsConstructor @Getter @Setter
public class User implements Serializable {

	private static final long serialVersionUID = -8883659399300716000L;

	@GeneratedValue(
		strategy  = GenerationType.SEQUENCE,
		generator = "sequence-generator"
	)
	@SequenceGenerator(
		name           = "sequence-generator",
		sequenceName   = "hibernate_sequence",
		allocationSize = 50
	)
	@Id
	private Integer id;

	private String username;
	private String fullName;
	private String displayName;

	@Convert(converter = UserRolesConverter.class)
	@Column(columnDefinition = "TEXT")
	private Set<UserRole> roles;

}
