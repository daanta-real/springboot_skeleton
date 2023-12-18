package com.semi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @Value로 끌어온 값을 최상위 실행 클래스(Main 역할의 클래스)에서 쓰려면,
// Main 역할의 클래스에 CommandLineRunne 인터페이스를 추가로 implement 시켜놓고
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

	// run 메소드를 이렇게 Override한 다음 여기서 써야 한다.
	@Override
	public void run(String... args) {
		log.error("");
		log.error("\n서버가 시작되었습니다.\nhttp://localhost:{}{}", serverPort, contextPath);
		log.error("");
		log.error("");
	}

}
