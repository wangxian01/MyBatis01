package com.wangxian.mybatis01.dao;

import com.wangxian.mybatis01.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 保存学生信息
     * @param student
     */
    void SaveStudent(Student student);

    /**
     * 更新学生信息
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 根据id删除学生信息
     * @param integer
     */
    void deleteStudent(Integer integer);

}
