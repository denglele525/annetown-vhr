package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPoliticsstatus is a Querydsl query type for Politicsstatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPoliticsstatus extends EntityPathBase<Politicsstatus> {

    private static final long serialVersionUID = 1746059135L;

    public static final QPoliticsstatus politicsstatus = new QPoliticsstatus("politicsstatus");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QPoliticsstatus(String variable) {
        super(Politicsstatus.class, forVariable(variable));
    }

    public QPoliticsstatus(Path<? extends Politicsstatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPoliticsstatus(PathMetadata metadata) {
        super(Politicsstatus.class, metadata);
    }

}

