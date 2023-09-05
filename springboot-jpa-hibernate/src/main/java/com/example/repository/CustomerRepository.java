package com.example.repository;

import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * JpaRepository ：
 * 继承了PagingAndSortRepository，开发中经常使用的接口，主要继承了PagingAndSortRepository，对返回值类型做了适配
 * It will take care of creating repository implementations automatically, at run-time,
 * from a repository interface.
 *
 * JpaRepository<T, Serializable> T: 实体类型   Serializable：主键类型
 *  1.Repository
 *
 *  通常用于修饰dao层的组件，@Repository注解属于Spring里面最先引入的一批注解，它用于将数据访问层 (DAO层 ) 的类标识为Spring Bean，
 *  具体只需将该注解标注在 DAO类上即可
 *
 *  JPQL语言（Java Persistence Query Language）是一种和SQL非常类似的中间性和对象化查询语言，
 *  它最终会被编译成针对不同底层数据库的SQL语言，从而屏蔽不同数据库的差异。
 *  在使用原生SQL查询时，也使用@Query注解。此时，nativeQuery参数需要设置为true。
 *
 *  JPA中自定义的插入、更新、删除方法 要添加@Modifying注解和@Transactional注解
 *  实质上@Modifying只是声明了这个操作是一个修改操作，但却没有修改这个方法的事务等级，
 *  因此这个方法依然不能进行修改操作。只有声明了@Transactional，本质上是
 *  声明了@Transactional(readOnly=false)，这样覆盖了默认的@Transactional配置便可以执行修改操作了
 *
 */
@Transactional  //声明了@Transactional，本质上是声明了@Transactional(readOnly=false)

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   // 使用 INNER JOIN（也可以省略 INNER 、直接使用 JOIN）
   //@Query("SELECT new com.example.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
   @Query("SELECT new com.example.dto.OrderResponse(c.name, p.productName) FROM Customer c, Product p WHERE c.id = p.pid")
   //1. By default, the query definition uses JPQL.
   // 2. We can use also native SQL to define our query.
   public List<OrderResponse> getJoinInformation();

   // @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)

    // 注意：JPA默认使用find, 不是get
     Optional<Customer> findCustomerByName(String name);


    @Query("SELECT  c from Customer c where c.name = ?1") // 第一个参数,u.status = ?1 and u.name = ?2
    Optional<Customer> getByName(String name);

    @Modifying //修改语句需要加上
    //使用原生SQL查询, nativeQuery = true
    //@Query(value = "UPDATE customer  set email = :email where name =:name",nativeQuery = true)
    @Query(value = "UPDATE Customer c set c.email = :email where c.name =:name")
    public int updateCustomerByName(@Param("name") String name, @Param("email") String email);



}
