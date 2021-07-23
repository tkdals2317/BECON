package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcertThumbnail is a Querydsl query type for ConcertThumbnail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcertThumbnail extends EntityPathBase<ConcertThumbnail> {

    private static final long serialVersionUID = -1360803672L;

    public static final QConcertThumbnail concertThumbnail = new QConcertThumbnail("concertThumbnail");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath originName = createString("originName");

    public final StringPath path = createString("path");

    public QConcertThumbnail(String variable) {
        super(ConcertThumbnail.class, forVariable(variable));
    }

    public QConcertThumbnail(Path<? extends ConcertThumbnail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcertThumbnail(PathMetadata metadata) {
        super(ConcertThumbnail.class, metadata);
    }

}

