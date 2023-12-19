package net.horvoje.querydsl.bugs.contains.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1230205917L;

    public static final QUser user = new QUser("user");

    public final StringPath displayName = createString("displayName");

    public final StringPath fullName = createString("fullName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<net.horvoje.querydsl.bugs.contains.enums.UserRole, EnumPath<net.horvoje.querydsl.bugs.contains.enums.UserRole>> roles = this.<net.horvoje.querydsl.bugs.contains.enums.UserRole, EnumPath<net.horvoje.querydsl.bugs.contains.enums.UserRole>>createSet("roles", net.horvoje.querydsl.bugs.contains.enums.UserRole.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

