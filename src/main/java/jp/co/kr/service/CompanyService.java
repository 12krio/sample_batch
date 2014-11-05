package jp.co.kr.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import jp.co.kr.persistence.Company;
import jp.co.kr.persistence.CompanyExample;
import jp.co.kr.persistence.CompanyMapper;
import jp.co.kr.persistence.Person;
import jp.co.kr.persistence.PersonExample;
import jp.co.kr.persistence.PersonMapper;
import jp.co.kr.velocity.CompanyCSVOut;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CompanyService {
	public void doCompany() {
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
			List<Object> map = session.selectList("jp.co.kr.persistence.CompanyMapper.selectUsers");
			System.out.println(map);
			CompanyCSVOut ccout = new CompanyCSVOut();
			ccout.writeCSV(map);
/*			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			//mapper.deleteByExample(new CompanyExample()
			mapper.selectByPrimaryKey(1);
			List<Company> blog = mapper.selectByExample(new CompanyExample());
			System.out.println(blog.get(0).getName());
*/			
		} finally {
			session.close();
		}
	}
	
	public void selectCompanySum() {
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
			List<Object> map = session.selectList("jp.co.kr.persistence.CompanyMapper.selectUsersSum");
			System.out.println(map.get(0));
			System.out.println(map.get(1));
			System.out.println(map.get(2));
			System.out.println(map.get(3));
			System.out.println(map.get(4));

			//CompanyCSVOut ccout = new CompanyCSVOut();
			//ccout.writeCSV(map);
/*			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			//mapper.deleteByExample(new CompanyExample()
			mapper.selectByPrimaryKey(1);
			List<Company> blog = mapper.selectByExample(new CompanyExample());
			System.out.println(blog.get(0).getName());
*/			
		} finally {
			session.close();
		}
	}

	
	public void insertCompany(){
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
			HashMap parameter = new HashMap();
			parameter.put("NAME", "aaaa");
			int result = session.insert("jp.co.kr.persistence.CompanyMapper.insertUsers");
			System.out.println(result);
			CompanyCSVOut ccout = new CompanyCSVOut();
			//ccout.writeCSV(result);
/*			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			//mapper.deleteByExample(new CompanyExample()
			mapper.selectByPrimaryKey(1);
			List<Company> blog = mapper.selectByExample(new CompanyExample());
			System.out.println(blog.get(0).getName());
*/			
			session.commit();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		
	}
}
