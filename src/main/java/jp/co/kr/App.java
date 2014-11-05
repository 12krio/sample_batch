package jp.co.kr;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jp.co.kr.persistence.Person;
import jp.co.kr.persistence.PersonExample;
import jp.co.kr.persistence.PersonMapper;
import jp.co.kr.service.CompanyService;
import jp.co.kr.service.PersonService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new CompanyService().selectCompanySum();

       // new CompanyService().doCompany();
//        new CompanyService().insertCompany();
//        new PersonService().doPerson();
    }
}
