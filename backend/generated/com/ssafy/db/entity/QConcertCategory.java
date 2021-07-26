package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcertCategory extends EntityPathBase<ConcertCategory>{
	private static final long serialVersionUID = 846542477L;

    public static final QConcertCategory concertCategory = new QConcertCategory("concerCategory");

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


