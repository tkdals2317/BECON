package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserConcert extends EntityPathBase<UserConcert> {

	private static final long serialVersionUID = 3437122155664059383L;
	
	private static final PathInits INITS = PathInits.DIRECT2;
	
	public static final QUserConcert userConcert = new QUserConcert("userConcert");
    
	public final QBaseEntity _super = new QBaseEntity(this);
	
	public final NumberPath<Long> id = _super.id;
    
    public final QUser user;
    //public final NumberPath<Long> userId = createNumber("userProfileId", Long.class);
    //public final NumberPath<Long> concertId = createNumber("userProfileId", Long.class);
    
    public final QConcert concert;
   

    public QUserConcert(String variable) {
		super(UserConcert.class, forVariable(variable), INITS);
    };

    public QUserConcert(Path<? extends UserConcert> path) {
		super(path.getType(), path.getMetadata(), INITS);
    };

    public QUserConcert(PathMetadata metadata) {
		super(UserConcert.class, metadata, INITS);
    };


}
