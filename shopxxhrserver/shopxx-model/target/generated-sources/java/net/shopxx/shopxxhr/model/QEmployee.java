package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = 400627866L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final StringPath address = createString("address");

    public final DateTimePath<java.util.Date> beginContract = createDateTime("beginContract", java.util.Date.class);

    public final DateTimePath<java.util.Date> beginDate = createDateTime("beginDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> birthday = createDateTime("birthday", java.util.Date.class);

    public final NumberPath<Double> contractTerm = createNumber("contractTerm", Double.class);

    public final DateTimePath<java.util.Date> conversionTime = createDateTime("conversionTime", java.util.Date.class);

    public final QDepartment department;

    public final StringPath email = createString("email");

    public final DateTimePath<java.util.Date> endContract = createDateTime("endContract", java.util.Date.class);

    public final StringPath engageForm = createString("engageForm");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath idCard = createString("idCard");

    public final QJobLevel joblevel;

    public final StringPath name = createString("name");

    public final QNation nation;

    public final StringPath nativePlace = createString("nativePlace");

    public final DateTimePath<java.util.Date> notworkDate = createDateTime("notworkDate", java.util.Date.class);

    public final StringPath phone = createString("phone");

    public final QPoliticsstatus politic;

    public final QPosition pos;

    public final StringPath school = createString("school");

    public final StringPath specialty = createString("specialty");

    public final EnumPath<Employee.TiptopDegree> tiptopDegree = createEnum("tiptopDegree", Employee.TiptopDegree.class);

    public final EnumPath<Employee.Wedlock> wedlock = createEnum("wedlock", Employee.Wedlock.class);

    public final NumberPath<Integer> workAge = createNumber("workAge", Integer.class);

    public final NumberPath<Integer> workId = createNumber("workId", Integer.class);

    public final EnumPath<Employee.WorkState> workState = createEnum("workState", Employee.WorkState.class);

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.joblevel = inits.isInitialized("joblevel") ? new QJobLevel(forProperty("joblevel")) : null;
        this.nation = inits.isInitialized("nation") ? new QNation(forProperty("nation")) : null;
        this.politic = inits.isInitialized("politic") ? new QPoliticsstatus(forProperty("politic")) : null;
        this.pos = inits.isInitialized("pos") ? new QPosition(forProperty("pos")) : null;
    }

}

