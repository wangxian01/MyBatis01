package com.wangxian.mybatis01.dao;

import com.wangxian.mybatis01.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDaoTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private StudentDao studentDao;

    @Before
    public void before() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象
        sqlSession = factory.openSession();
        //获取dao代理对象
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void after() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void findAllStudent() {
        //查询学生信息
        List<Student> studentList = studentDao.findAllStudent();
        for (Student student:studentList) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void saveStudent() {
        Student student = new Student();
        student.setName("李四");
        student.setAge("16");
        student.setSex("女");
        student.setAddress("北京市朝阳区");
        studentDao.SaveStudent(student);
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("张五");
        student.setAge("50");
        student.setSex("女");
        student.setAddress("成都市武侯区");
        studentDao.updateStudent(student);
    }

    @Test
    public void deleteStudent() {
        studentDao.deleteStudent(1);
    }
}
