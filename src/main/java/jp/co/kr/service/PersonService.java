package jp.co.kr.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import jp.co.kr.persistence.Person;
import jp.co.kr.persistence.PersonExample;
import jp.co.kr.persistence.PersonMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PersonService {
	public void doPerson() {
		String resource = "mybatis-config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		SqlSession session = sessionFactory.openSession();
		// SqlSession session = sqlSessionFactory.openSession();
		try {
			PersonMapper mapper = session.getMapper(PersonMapper.class);
			List<Person> blog = mapper.selectByExample(new PersonExample());
			System.out.println(blog.get(0).getName());
		} finally {
			session.close();
		}

	}
}
