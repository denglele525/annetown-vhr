package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPosition is a Querydsl query type for Position
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPosition extends EntityPathBase<Position> {

    private static final long serialVersionUID = -45036779L;

    public static final QPosition position = new QPosition("position1");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QPosition(String variable) {
        super(Position.class, forVariable(variable));
    }

    public QPosition(Path<? extends Position> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPosition(PathMetadata metadata) {
        super(Position.class, metadata);
    }

}

