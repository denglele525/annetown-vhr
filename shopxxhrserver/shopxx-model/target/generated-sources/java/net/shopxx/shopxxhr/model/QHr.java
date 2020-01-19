package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHr is a Querydsl query type for Hr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHr extends EntityPathBase<Hr> {

    private static final long serialVersionUID = 1384438L;

    public static final QHr hr = new QHr("hr");

    public final StringPath address = createString("address");

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath remark = createString("remark");

    public final ListPath<Role, QRole> role = this.<Role, QRole>createList("role", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath telephone = createString("telephone");

    public final StringPath userface = createString("userface");

    public final StringPath username = createString("username");

    public QHr(String variable) {
        super(Hr.class, forVariable(variable));
    }

    public QHr(Path<? extends Hr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHr(PathMetadata metadata) {
        super(Hr.class, metadata);
    }

}

