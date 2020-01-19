package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 1330584907L;

    public static final QMenu menu = new QMenu("menu");

    public final StringPath component = createString("component");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath iconCls = createString("iconCls");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath keepAlive = createBoolean("keepAlive");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath path = createString("path");

    public final BooleanPath requireAuth = createBoolean("requireAuth");

    public final ListPath<Role, QRole> role = this.<Role, QRole>createList("role", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath url = createString("url");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

