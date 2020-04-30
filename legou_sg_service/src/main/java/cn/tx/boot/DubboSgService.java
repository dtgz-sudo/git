package cn.tx.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboSgService {
    public static void main(String[] args) throws IOException {
        // 只需要加载Spring的配置文件即可
        /**
         * classpath* 加载本地配置文件和jar包里面的配置文件
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
//        BrandServiceImpl brandServiceImpl = (BrandServiceImpl) ac.getBean("brandServiceImpl");
//        List<Brand> list = brandServiceImpl.findAll();
//        System.out.println(list);
//        SpecificationImpl service = (SpecificationImpl) ac.getBean("specificationImpl");
//        PageInfo<TbSpecification> page = service.findPage(1, 10);
//        System.out.println(page);
        System.out.println("dubbo提供端启动成功");
        System.in.read();
    }

}
