package com.practice.configuration;

import com.practice.function.ChainedMethod;
import com.practice.wysiwyg.Doc;
import com.practice.wysiwyg.processor.ImageProcessor;
import com.practice.wysiwyg.processor.MediaProcessor;
import org.juric.storage.service.StorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by Eric on 9/27/2015.
 */
@Configuration
public class WCMConfiguration {
    @Resource(name = "storageService")
    private StorageService storageService;

    @Bean(name="imageProcessor")
    public ImageProcessor imageProcessor() {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.setStorageService(storageService);
        return imageProcessor;
    }

    @Bean(name="mediaProcessors")
    public ChainedMethod mediaProcessors() throws NoSuchMethodException {
        ChainedMethod<MediaProcessor> cm = new ChainedMethod(MediaProcessor.class);
        cm.add(imageProcessor());
        return cm;
    }
}
