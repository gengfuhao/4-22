package ltd.newbee.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("ltd.newbee.mall.newbeemall.dao")

//程序的入口SpringApplication.run（）方法

@SpringBootApplication
public class NewbeeMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewbeeMallApplication.class, args);
	}
}

//http://localhost:8080/recommendGoodses