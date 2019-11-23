package com.lanhuigu.test.service.worker;

import com.lanhuigu.common.concurrent.ThreadUtils;
import com.lanhuigu.core.worker.CPUDemo2Worker;
import com.lanhuigu.core.worker.CPUDemo1Worker;
import com.lanhuigu.core.worker.IODemoWorker;
import com.lanhuigu.test.BaseServletTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * 来，老铁，测试下线程
 *
 * @author yihonglei
 * @date 2019/11/23 9:43 PM
 */
@Slf4j
public class WorkerTest extends BaseServletTest {

    /**
     * CPU密集，有返回值
     */
    @Test
    public void testCPUDemo1Worker() throws ExecutionException, InterruptedException {
        String bizContext = "CPU密集型";
        Integer result = ThreadUtils.submit(new CPUDemo1Worker(bizContext)).get();
        log.info("result={}", result);
    }

    /**
     * CPU密集，无返回值
     */
    @Test
    public void testCPUDemo2Worker() {
        String bizContext = "CPU密集型";
        ThreadUtils.execute(new CPUDemo2Worker(bizContext));
    }

    /**
     * IO密集，无有返回值
     */
    @Test
    public void testIODemoWorker() throws ExecutionException, InterruptedException {
        String bizContext = "IO密集型";
        ThreadUtils.executeStandard(new IODemoWorker(bizContext));
    }
}
