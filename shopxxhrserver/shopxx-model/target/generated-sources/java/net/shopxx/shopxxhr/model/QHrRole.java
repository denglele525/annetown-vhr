package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHrRole is a Querydsl query type for HrRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHrRole extends EntityPathBase<HrRole> {

    private static final long serialVersionUID = -1340135028L;

    public static final QHrRole hrRole = new QHrRole("hrRole");

    public final NumberPath<Integer> hrId = createNumber("hrId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QHrRole(String variable) {
        super(HrRole.class, forVariable(variable));
    }

    public QHrRole(Path<? extends HrRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHrRole(PathMetadata metadata) {
        super(HrRole.class, metadata);
    }

}

