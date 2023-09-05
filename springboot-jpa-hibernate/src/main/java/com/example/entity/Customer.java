package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Spring Data
 * 是Spring 的一个子项目, 旨在统一和简化对各类型持久化存储, 而不拘泥于是关系型数据库还是NoSQL 数据存储。
 *  Spring Data JPA是Spring Data项目的一部分，它是在ORM框架思想、JPA规范的基础上封装的一套JPA应用框架。
 *  使用Spring Data JPA只需要继承和扩展Spring Data 中统一的数据访问接口Repository接口无需编写SQL实现数据库访问。
 *
 * Java Persistence API
 * JPA（Java Persistence API， Java 持久化API）是SUN公司提出的Java持久化规范，
 * 它提供了一种对象/关系映射的管理工具来管理Java中的关系型数据库。
 * JPA的主要目的是简化现有的持久化开发工作并且整合ORM框架，JPA本身并不是ORM框架，它是一种规范，
 * 这种规范可以私下通过注解或者XML描述“对象-关系表”之间的映射关系，并将实体对象持久化到数据库中，
 * 从而极大地简化现有的持久化开发工作。
 * 实现JPA的框架有Hibernate, TopLink, 而我们前面介绍的MyBatis不属于实现JPA的框架
 * Mybatis：小巧、方便、高效、简单、直接、半自动
 * Hibernate：强大、方便、高效、复杂、绕弯子、全自动
 *
 * Spring Data是Spring提供的操作数据的框架，Spring Data JPA是Spring Data的一个模块，
 * 通过Spring data 基于jpa标准操作数据的模块。
 * Spring Data的核心能力，就是基于JPA操作数据，并且可以简化操作持久层的代码。
 * 它使用一个叫作Repository的接口类为基础，它被定义为访问底层数据模型的超级接口。而对于某种具体的数据访问操作，则在其子接口中定义。
 * Spring Data可以让我们只定义接口，只要遵循spring data的规范，就无需写实现类，不用写sql语句直接查询数据
 *
 * CRUD是Create、Read、Update和Delete
 * CrudRepository： 继承了Repository 提供了对数据的增删改查
 * PagingAndSortRepository ：
 * 继承了CrudRepository 提供了对数据的分页和排序，缺点是只能对所有的数据进行分页或者排序，不能做条件判断
 *
 * @ JoinColumn 注解的作用：用来指定与所操作实体或实体集合相关联的数据库表中的列字段。
 * 由于 @OneToOne（一对一）、@OneToMany（一对多）、@ManyToOne（多对一）、@ManyToMany（多对多）
 * 通常这种多对多关系都是通过创建中间表来进行关联处理，并使用@JoinTable注解来指定。
 * 注解只能确定实体之间几对几的关联关系，它们并不能指定与实体相对应的数据库表中的关联字段，
 * 因此，需要与 @JoinColumn 注解来配合使用。
 * OneToMany与JPA中ManyToMany关系的主要区别在于，ManyToMany总是使用中间关系连接表来存储关系，
 * OneToMany可以使用连接表或者目标对象的表引用中的外键源对象表的主键
 *
 * mappedBy ：类层面，关联的全都是【实体类】中的【属性名】
 * @ JoinColumn：字段层面，关联的全都是【表】中的【字段名】
 *  @ Transient：忽略属性,表示该属性并非一个到数据库表的字段的映射，ORM 框架将忽略该属性。
 *  @ JoinColumn：指定外键
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //必需，映射实体类。指出该 Java 类为实体类，将映射到指定的关系数据库表。
@ToString
public class Customer {
    @Id //@Id（必需），标注在实体类成员变量或getter方法之上。
    @GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue 用于标注主键的生成策略，通过 strategy 属性指定。
    private int id;
    private String name;
    private String email;
    private String gender;

    // cascade， 级联操作策略， CUD
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    //用来指定与所操作实体或实体集合相关联的数据库表中的列字段，Product表cp_fk字段与customer表id字段 对应
    // name ：【对方】实体的【数据库字段】,外键的一方
    //@JoinColumn 根本就不关心它所在的实体类是谁，它的 name 属性指向的，永远都是外键。
    //referencedColumnName ：【己方】实体的【数据库字段】（如果是主键，可以省略）
    @JoinColumn(name = "cp_fk", referencedColumnName = "id") // 指定外键
    private List<Product> products;

}
