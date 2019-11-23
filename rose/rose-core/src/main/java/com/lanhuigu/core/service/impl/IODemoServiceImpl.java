package com.lanhuigu.core.service.impl;

import com.lanhuigu.core.service.IODemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 业务接口实现
 *
 * @author yihonglei
 * @date 2019/11/22 1:55 PM
 */
@Slf4j
@Service
public class IODemoServiceImpl implements IODemoService {
    @Override
    public void demo(String bizContext) {
        // 业务处理
        log.info("测试无返回值工作线程!bizContext={}", bizContext);
    }
}
