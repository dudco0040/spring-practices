package com.poscodx.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poscodx.container.config.videosystem.DVDPlayerConfig;
import com.poscodx.container.config.videosystem.mixing.DVDConfig;

/**
 * <----- JavaCongig1, JavaCongig2
 * import 
 */

@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {
	
}
