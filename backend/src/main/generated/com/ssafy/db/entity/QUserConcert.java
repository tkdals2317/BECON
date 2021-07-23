package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserConcert is a Querydsl query type for UserConcert
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserConcert extends EntityPathBase<UserConcert> {

    private static final long serialVersionUID = 1649398617L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserConcert userConcert = new QUserConcert("userConcert");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QConcert concert;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QUser user;

    public QUserConcert(String variable) {
        this(UserConcert.class, forVariable(variable), INITS);
    }

    public QUserConcert(Path<? extends UserConcert> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserConcert(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserConcert(PathMetadata metadata, PathInits inits) {
        this(UserConcert.class, metadata, inits);
    }

    public QUserConcert(Class<? extends UserConcert> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.concert = inits.isInitialized("concert") ? new QConcert(forProperty("concert"), inits.get("concert")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

