package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = -863524290L;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath depPath = createString("depPath");

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isParent = createBoolean("isParent");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable));
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartment(PathMetadata metadata) {
        super(Department.class, metadata);
    }

}

