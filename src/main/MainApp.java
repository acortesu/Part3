package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testbean.MySpringWriterBeanWithDependency;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");
        BeanFactory factory = context;
        MySpringWriterBeanWithDependency test = (MySpringWriterBeanWithDependency) factory
                .getBean("MySpringWriterBeanWithDependency");
        test.run();
    }
}
