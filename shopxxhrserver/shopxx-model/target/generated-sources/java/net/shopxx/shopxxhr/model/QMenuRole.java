package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenuRole is a Querydsl query type for MenuRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenuRole extends EntityPathBase<MenuRole> {

    private static final long serialVersionUID = -1396673439L;

    public static final QMenuRole menuRole = new QMenuRole("menuRole");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> menuId = createNumber("menuId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QMenuRole(String variable) {
        super(MenuRole.class, forVariable(variable));
    }

    public QMenuRole(Path<? extends MenuRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuRole(PathMetadata metadata) {
        super(MenuRole.class, metadata);
    }

}

