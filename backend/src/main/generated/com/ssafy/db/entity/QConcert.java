package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConcert is a Querydsl query type for Concert
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcert extends EntityPathBase<Concert> {

    private static final long serialVersionUID = 397222052L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConcert concert = new QConcert("concert");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QConcertCategory category;

    public final StringPath description = createString("description");

    public final StringPath endTime = createString("endTime");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> isActive = createNumber("isActive", Integer.class);

    public final NumberPath<Integer> minAge = createNumber("minAge", Integer.class);

    public final QConcertPoster poster;

    public final NumberPath<Integer> priceStand = createNumber("priceStand", Integer.class);

    public final NumberPath<Integer> priceVip = createNumber("priceVip", Integer.class);

    public final StringPath startTime = createString("startTime");

    public final QConcertThumbnail thumbnail;

    public final StringPath title = createString("title");

    public final QUser user;

    public final ListPath<UserConcert, QUserConcert> userConcertLsit = this.<UserConcert, QUserConcert>createList("userConcertLsit", UserConcert.class, QUserConcert.class, PathInits.DIRECT2);

    public QConcert(String variable) {
        this(Concert.class, forVariable(variable), INITS);
    }

    public QConcert(Path<? extends Concert> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConcert(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConcert(PathMetadata metadata, PathInits inits) {
        this(Concert.class, metadata, inits);
    }

    public QConcert(Class<? extends Concert> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QConcertCategory(forProperty("category")) : null;
        this.poster = inits.isInitialized("poster") ? new QConcertPoster(forProperty("poster")) : null;
        this.thumbnail = inits.isInitialized("thumbnail") ? new QConcertThumbnail(forProperty("thumbnail")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

