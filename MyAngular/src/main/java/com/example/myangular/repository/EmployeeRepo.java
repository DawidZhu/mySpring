package com.example.myangular.repository;

import com.example.myangular.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

/**
 * JpaRepository<T, ID>,
 * T 需要类型化为实体类(Entity)User，ID需要实体类User中Id的类型
 * Spring Data JPA focuses on using JPA to store data in a relational database.
 * Its most compelling feature is the ability to create repository implementations automatically,
 * at runtime, from a repository interface.
 *
 *  PagingAndSortingRepository 继承 CrudRepository
 *  JpaRepository 继承 PagingAndSortingRepository
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    // 继承了 JpaRepository 的所有 CRUD 方法

    /**
     *新增方法
     * Optional 类是一个可以为null的容器对象。
     * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，
     * 这样我们就不用显式进行空值检测。
     */

    Optional<Employee>  findEmployeeById(Long id);

}
