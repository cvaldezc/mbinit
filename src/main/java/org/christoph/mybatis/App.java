package org.christoph.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.christoph.mybatis.builder.PersonMapper;
import org.christoph.mybatis.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger log = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	SqlSessionFactory factory = null;
    	//Reader reader = null;
    	try(Reader reader = Resources.getResourceAsReader("mybatis-config.xml"))
    	{
    		factory = new SqlSessionFactoryBuilder().build(reader);
    	}catch(IOException ex) {
    		log.debug("Problems open file config mybatis ");
    		log.error(ex.getMessage());
    	}
    	
    	// insert first person
    	SqlSession sqlsession = factory.openSession();
    	try {
    		// creata new Person
    		Person person = new Person();
    		person.setNif("70492852A");
    		person.setName("Alexander Valdez Chavez");
    		person.setBirthdate(LocalDate.of(1990, 4, 13));
    		log.debug("This state Object  BEFORE COMMIT " + person);
    		// get instance class mapper
			PersonMapper personMapper = sqlsession.getMapper(PersonMapper.class);
			// pesistence object
			personMapper.insert(person);
			sqlsession.commit();
			log.error("This state AFTER COMMIT Object " + person);
    	}catch(Exception ex) {
    		log.debug("Problems with mappers of mybatis ");
    		log.error(ex.getMessage());
		} finally {
			sqlsession.close();
		}
    }
}
