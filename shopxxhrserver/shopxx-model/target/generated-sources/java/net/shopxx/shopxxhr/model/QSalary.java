package net.shopxx.shopxxhr.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSalary is a Querydsl query type for Salary
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSalary extends EntityPathBase<Salary> {

    private static final long serialVersionUID = -1040152906L;

    public static final QSalary salary = new QSalary("salary");

    public final NumberPath<Integer> accumulationFundBase = createNumber("accumulationFundBase", Integer.class);

    public final NumberPath<Float> accumulationFundPer = createNumber("accumulationFundPer", Float.class);

    public final NumberPath<Integer> allSalary = createNumber("allSalary", Integer.class);

    public final NumberPath<Integer> basicSalary = createNumber("basicSalary", Integer.class);

    public final NumberPath<Integer> bonus = createNumber("bonus", Integer.class);

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final ListPath<Employee, QEmployee> employee = this.<Employee, QEmployee>createList("employee", Employee.class, QEmployee.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> lunchSalary = createNumber("lunchSalary", Integer.class);

    public final NumberPath<Integer> medicalBase = createNumber("medicalBase", Integer.class);

    public final NumberPath<Float> medicalPer = createNumber("medicalPer", Float.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> pensionBase = createNumber("pensionBase", Integer.class);

    public final NumberPath<Float> pensionPer = createNumber("pensionPer", Float.class);

    public final NumberPath<Integer> trafficSalary = createNumber("trafficSalary", Integer.class);

    public QSalary(String variable) {
        super(Salary.class, forVariable(variable));
    }

    public QSalary(Path<? extends Salary> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSalary(PathMetadata metadata) {
        super(Salary.class, metadata);
    }

}

