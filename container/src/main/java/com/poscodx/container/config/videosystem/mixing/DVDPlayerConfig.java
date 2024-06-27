package com.poscodx.container.config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poscodx.container.videosystem.DVDPlayer;
import com.poscodx.container.videosystem.DigitalVideoDisc;

/**
 * JavaConfig2  <---- JavaConfig1
 * 				import 
 */

@Configuration
@Import({DVDConfig.class})  // JavaConfig1 가져오기 
public class DVDPlayerConfig {
	public DVDPlayer dvdPlayer(@Qualifier("avengers") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd); // 생성자 주입
	}
	
}
