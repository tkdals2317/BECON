package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcertCategory is a Querydsl query type for ConcertCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcertCategory extends EntityPathBase<ConcertCategory> {

    private static final long serialVersionUID = -1421779518L;

    public static final QConcertCategory concertCategory = new QConcertCategory("concertCategory");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QConcertCategory(String variable) {
        super(ConcertCategory.class, forVariable(variable));
    }

    public QConcertCategory(Path<? extends ConcertCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcertCategory(PathMetadata metadata) {
        super(ConcertCategory.class, metadata);
    }

}

