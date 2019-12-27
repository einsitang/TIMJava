package com.sevlow.sdk.tim.api.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.impl.TIMServiceImpl;
import com.sevlow.sdk.tim.config.TIMConfig;
import org.yaml.snakeyaml.Yaml;

/**
 * 测试模块
 * @author element
 */
public class TestModule implements Module {

    @Override
    public void configure(Binder binder) {

        Yaml yaml = new Yaml();
        TIMConfig config = yaml.loadAs(TestModule.class.getClassLoader().getResourceAsStream("config.test.yml"), TIMConfig.class);

        TIMService timService = new TIMServiceImpl(config);

        binder.bind(TIMConfig.class).toInstance(config);
        binder.bind(TIMService.class).toInstance(timService);

    }
}
