package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmail is a Querydsl query type for Email
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmail extends EntityPathBase<Email> {

    private static final long serialVersionUID = 458053914L;

    public static final QEmail email = new QEmail("email");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userId = createString("userId");

    public QEmail(String variable) {
        super(Email.class, forVariable(variable));
    }

    public QEmail(Path<? extends Email> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmail(PathMetadata metadata) {
        super(Email.class, metadata);
    }

}

