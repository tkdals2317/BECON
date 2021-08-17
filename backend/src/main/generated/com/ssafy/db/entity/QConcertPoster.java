package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcertPoster is a Querydsl query type for ConcertPoster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcertPoster extends EntityPathBase<ConcertPoster> {

    private static final long serialVersionUID = 464060177L;

    public static final QConcertPoster concertPoster = new QConcertPoster("concertPoster");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath originName = createString("originName");

    public final StringPath path = createString("path");

    public QConcertPoster(String variable) {
        super(ConcertPoster.class, forVariable(variable));
    }

    public QConcertPoster(Path<? extends ConcertPoster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcertPoster(PathMetadata metadata) {
        super(ConcertPoster.class, metadata);
    }

}

