package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcert extends EntityPathBase<Concert>{

	private static final long serialVersionUID = -3266627394207968342L;
    public static final QConcert concert = new QConcert("concert");
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final NumberPath<Long> thumbnailId = createNumber("thumbnailId", Long.class);
    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);
    public final NumberPath<Long> ownerId = createNumber("ownerId", Long.class);
    
    //inherited
    public final NumberPath<Long> id = _super.id;
    public final StringPath startTime = createString("startTime");
    public final StringPath endTime = createString("endTime");
    public final StringPath title = createString("title");
    public final StringPath description = createString("description");
    public final NumberPath<Integer> priceVip = createNumber("priceVip", Integer.class);
    public final NumberPath<Integer> priceStand = createNumber("priceStand", Integer.class);
    public final StringPath isActive = createString("isActive");
	
	public QConcert(String variable) {
        super(Concert.class, forVariable(variable));
    }

    public QConcert(Path<? extends Concert> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcert(PathMetadata metadata) {
        super(Concert.class, metadata);
    }

}
