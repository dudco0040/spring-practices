package com.poscodx.container.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:com/poscodx/container/config/soundsystem/applicationContext.xml"}) // config 파일 위치를 알려줌, 여러 설정 파일을 쓸 수 있음 
public class CDPlayerXmlConfigTest {
	@Autowired
	CDPlayer cdPlayer;
	
	@Test
	public void testCDplayerNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlayer() {
		assertEquals("Playing 붕붕 by 김하온", cdPlayer.play());
	}
	
}
