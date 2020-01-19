package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobLevel is a Querydsl query type for JobLevel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobLevel extends EntityPathBase<JobLevel> {

    private static final long serialVersionUID = 1869090739L;

    public static final QJobLevel jobLevel = new QJobLevel("jobLevel");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final EnumPath<JobLevel.TitleLevel> titleLevel = createEnum("titleLevel", JobLevel.TitleLevel.class);

    public QJobLevel(String variable) {
        super(JobLevel.class, forVariable(variable));
    }

    public QJobLevel(Path<? extends JobLevel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobLevel(PathMetadata metadata) {
        super(JobLevel.class, metadata);
    }

}

