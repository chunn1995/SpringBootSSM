package org.boot.cnn;

import java.util.Date;

import org.boot.cnn.dao.UserMapper;
import org.boot.cnn.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSsmApplicationTests {

	@Autowired
	UserMapper userMapper;
	
	
	@Test
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED) /**事务管理，在执行语句过程中出现异常时，回退。逻辑中之前成功的数据无效。**/
	/**
	 * 隔离级别（Isolation）:隔离级别是指若干个并发的事务之间的隔离程度，与我们开发时候主要相关的场景包括：脏读取、重复读、幻读。
	 * DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：READ_COMMITTED。
	 * READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。
	 * READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
	 * REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。
	 * SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
	 * 
	 * 传播行为（Propagation）：所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。
	 * REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
	 * SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
	 * MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
	 * REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
	 * NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
	 * NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
	 * NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于REQUIRED。
	 */
	public void contextLoads() {
		userMapper.insertUser("chunn", "SBqiaowen521", "褚宁宁", 24, "女", new Date("1995-03-13"), "河北省承德市");
		User user = userMapper.findUserByLoginName("chunn");
		System.out.println(user);
	}

}
