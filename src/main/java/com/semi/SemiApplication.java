package com.semi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @Value로 끌어온 값을 최상위 실행 클래스(Main 역할의 클래스)에서 쓰려면,
// Main 역할의 클래스에 CommandLineRunner 혹은 ApplicationRunner 인터페이스를 implement 해서 붙여놓고
// run 메소드를 이렇게 Override한 다음! 그 안에 가서 써야 한다.
// 왜냐면 main() 메소드가 실행되는 시점에서는 스프링이 로딩이 제대로 안 됐기 때문이다.
// 컨텍스트 초기화도 안 됐고 Bean의 생성도 안 되어있는 상태니까,
// 어노테이션으로 Bean을 끌어와 값을 출력해 봤자 null만 출력된다고 함.
// https://www.daleseo.com/spring-boot-runners/
@SpringBootApplication
public class SemiApplication implements CommandLineRunner {

	@Value("${server.port}")
	private String serverPort;

	@Value("${server.servlet.context-path}")
	private String contextPath;

	private static final Logger log = LoggerFactory.getLogger(SemiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SemiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.error("");
		log.error("\n서버가 시작되었습니다.\nhttp://localhost:{}{}", serverPort, contextPath);
		log.error("");
		log.error("");
	}

}
