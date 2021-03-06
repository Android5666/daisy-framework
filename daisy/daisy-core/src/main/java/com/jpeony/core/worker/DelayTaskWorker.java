package com.jpeony.core.worker;

import com.jpeony.common.concurrent.AbstractWorker;
import com.jpeony.common.pojo.dto.TraceItemDTO;
import com.jpeony.common.util.SpringBeanUtils;
import com.jpeony.core.service.DelayService;
import com.jpeony.core.service.delay.DelayServiceImpl;

import java.util.Date;

/**
 * @author yihonglei
 */
public class DelayTaskWorker extends AbstractWorker {
    private long passTime;
    private Date startTime;
    private DelayService delayService;
    /**
     * 日志追踪对象
     */
    private TraceItemDTO traceItemDTO;

    public DelayTaskWorker(long passTime, Date startTime) {
        this.passTime = passTime;
        this.startTime = startTime;
        traceItemDTO = TraceItemDTO.createByCurrentMDC();
        delayService = SpringBeanUtils.getBean(DelayServiceImpl.class);
    }

    /**
     * ignore
     */
    @Override
    protected TraceItemDTO getTraceItem() {
        return this.traceItemDTO;
    }

    /**
     * 模拟每个3秒执行一次任务，超过20秒后自动退出任务
     */
    @Override
    protected void execute() {
        delayService.delayTask(passTime, startTime);
    }
}
