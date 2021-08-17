package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmail extends EntityPathBase<Email> {

    private static final long serialVersionUID = 846542477L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmail email = new QEmail("email");

    public final QBaseEntity _super = new QBaseEntity(this);




    //inherited
    public final NumberPath<Long> id = _super.id;
    
    public final StringPath code = createString("code");

    public final StringPath userEmail = createString("userEmail");
    
    public final StringPath userId = createString("userId");

    public QEmail(String variable) {
        super(Email.class, forVariable(variable), INITS);
    }

    public QEmail(Path<? extends Email> path) {
    	super(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmail(PathMetadata metadata) {
    	super(Email.class, metadata);
    }


}

