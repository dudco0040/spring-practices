package com.poscodx.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscodx.container.videosystem.Avengers;
import com.poscodx.container.videosystem.DVDPlayer;
import com.poscodx.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	public void hello() {
		System.out.println("hello container");
	}
	
	@Bean  // 빈 생성
	public DigitalVideoDisc avengers() {  // 
		return new Avengers();  // return 값을 빈으로 등록 시킴
	}
	
	
	// bean 메소드를 사용!
	// 주입(Injection) 하기 1
	// Bean 생성 메소드를 직접 호출하는 방법 
	@Bean("dvdPalyer01")
	public DVDPlayer dvdPlayer1() {
		return  new DVDPlayer(avengers());  // method를 직접 주입 - 명시를 생략하면 메소드 이름으로
	}
	
	// 주입(Injection) 하기 2
	// 파라미터로 Bean을 전달
	// 생성자 주입
	@Bean
	public DVDPlayer dvdPlayer2(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// 주입(Injection) 하기 2
		// 파라미터로 Bean을 전달
		// setter 주입
		@Bean("dvdPlayer03")
		public DVDPlayer dvdPlayer3(DigitalVideoDisc dvd) {
			DVDPlayer dvdPlayer = new DVDPlayer(dvd);
			dvdPlayer.setDvd(dvd);
			
			return dvdPlayer;
		}
}
