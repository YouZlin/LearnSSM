package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.AnswerMapper;
import com.mybatis.mapper.QuestionMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.Answer;
import com.mybatis.pojo.Question;
import com.mybatis.pojo.User;

public class MybatisTest {
	private SqlSessionFactory sessionFactory;

	@Before
	public void init() {
		InputStream inputStream=MybatisTest.class.getResourceAsStream("/mybatis-config.xml");
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		sessionFactory=sqlSessionFactoryBuilder.build(inputStream);
		
	}
	
	@Test
	public void test1() {
		SqlSession sqlSession=sessionFactory.openSession();
		//openSession()不带参数,默认是不自动提交,需要手动提交增删改操作的事务
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		List<User>userList=userMapper.selectAll();
		
		System.out.println(userList);
		sqlSession.close();
		
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		User user=new User();
		user.setName("insertName");
		user.setAge(18);
		
//		int result=userMapper.insert(user);
		int result=userMapper.insert2("insert2Name");
		System.out.println(result+"---------");
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdate() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		User user=new User();
		user.setId(1L);
		user.setName("张珊珊1");
		user.setAge(13);
		
		int result=userMapper.update(user);
		System.out.println(result+"-----------------");
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
//		int result=userMapper.delete(1L);
		int result=userMapper.delete2(2L);
		System.out.println(result+"-----------------");
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectById() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		List<User> userList=userMapper.selectById(3L);
		System.out.println(userList);
		
		sqlSession.close();
	}
	
	@Test
	public void testHasA() {
		SqlSession sqlSession=sessionFactory.openSession();
		AnswerMapper answerMapper=sqlSession.getMapper(AnswerMapper.class);
		
		Answer answer=answerMapper.selectById(1L);
		System.out.println(answer);
		
		sqlSession.close();
	}
	
	@Test
	public void testHasMany() {
		SqlSession sqlSession=sessionFactory.openSession();
		QuestionMapper questionMapper=sqlSession.getMapper(QuestionMapper.class);
		
		Question question=questionMapper.selectById(1L);
		System.out.println(question);
		
		sqlSession.close();
	}
	
	@Test
	public void testSelect() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=new User();
//		user.setId(3L);
		user.setAge(3);
		user.setName("蛋蛋");
		List<User> userList=userMapper.select(user);
		System.out.println(userList);
		
		sqlSession.close();
	}
	
	@Test
	public void testSelect2() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=new User();
//		user.setId(3L);
		user.setAge(3);
//		user.setName("蛋蛋3");
		List<User> userList=userMapper.select(user);
		System.out.println(userList);
		
		sqlSession.close();
	}
	
	@Test
	public void testPageHelper() {
		SqlSession sqlSession=sessionFactory.openSession();
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		PageHelper.startPage(1, 10);//分页查询,设置每页10条数据,查询第1页
		
		PageHelper.orderBy("age.desc");
		
		List<User>userList=userMapper.selectAll();
		
		//获取分页后相关的数据
		PageInfo<User>pageInfo=new PageInfo<User>(userList);
		userList=pageInfo.getList();
		
		for (User user : userList) {
			System.out.println(user);
		}
		
		System.out.println(userList);
		sqlSession.close();
		
	}
	
	//mybatis一级缓存
	//session级别的缓存
	//不可禁用
	//select语句的结果将被缓存
	//当同一个session的两次查询生成的最终sql语句和参数值完全一样时第二次查询才会使用第一次查询的一级缓存
	//insert等更新语句会清空一级缓存

	@Test
	public void testCache1() {
		SqlSession sqlSession=sessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		List<User>userList=userMapper.selectAll();
		System.out.println(userList);
		
		System.out.println("---------------------------");
		User user=new User();
		user.setName("testCache");
		user.setAge(18);
		userMapper.insert(user);
		System.out.println("---------------------------");
		userList=userMapper.selectAll();
		System.out.println(userList);
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	
	//mybatis二级缓存
	//mybatis的二级缓存是命名空间级别的缓存，即同一个mapper接口执行过的所有查询语句以及查询结果都会被缓存到此命名空间下
	//只需要在映射文件使用<cache/>就会开启此命名空间的二级缓存，默认会对此命名空间下的所有的<select>使用二级缓存（如果指定某个<select>的useCache属性为false，此sql语句将不会使用二级缓存）
	//insert等更新语句会清空所属命名空间下的所有二级缓存
	//执行查询时，mybatis会先在二级缓存中查找，如果没找到再在一级缓存中查找，如果还没找到才会查询数据库，并会把查询结果存放到一级缓存和二级缓存中

	
	@Test
	public void testCache2() {
		SqlSession sqlSession1=sessionFactory.openSession();
		UserMapper userMapper=sqlSession1.getMapper(UserMapper.class);
		
		List<User>userList=userMapper.selectAll();
		System.out.println(userList);
		
		System.out.println("---------------------------");
//		User user =new User();
//		user.setName("testCache2");
//		user.setAge(18);
//		userMapper.insert(user);
		
		sqlSession1.commit();
		sqlSession1.close();
		
		SqlSession sqlSession2=sessionFactory.openSession();
		userMapper=sqlSession2.getMapper(UserMapper.class);
		
		System.out.println("---------------------------");
		
		userList=userMapper.selectAll();
		System.out.println(userList);
		
		sqlSession2.close();
		
	}
}
