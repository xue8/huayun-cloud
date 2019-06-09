package cn.ddnd.huayun.log.scheduled;

import cn.ddnd.huayun.log.request.Execute.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogScheduled {

    /**
     * 一分钟执行一次
     */
    @Scheduled(cron = "0/60 * * * * *")
    public void oneMinutes() {
        ExecuteRequest cpu = new ExecuteRequestCpu();
        cpu.execute();

        ExecuteRequest ram = new ExecuteRequestRam();
        ram.execute();

        ExecuteRequest diskUsed = new ExecuteRequestDiskUsed();
        diskUsed.execute();

        ExecuteRequest ioRead = new ExecuteRequestIoRead();
        ioRead.execute();

        ExecuteRequest ioWrite = new ExecuteReuqestIoWrite();
        ioWrite.execute();

        ExecuteRequest iopsRead = new ExecuteRequestIopsRead();
        iopsRead.execute();

        ExecuteRequest iopsWrite = new ExecuteRequestIopsWrite();
        iopsWrite.execute();

        ExecuteRequest fipIn = new ExecuteRequestFipIn();
        fipIn.execute();

        ExecuteRequest fipOut = new ExecuteRequestFipOut();
        fipOut.execute();

        ExecuteRequest routerIn = new ExecuteReuqestRouterIn();
        routerIn.execute();

        ExecuteRequest routerOut = new ExecuteReuqestRouterOut();
        routerOut.execute();

        ExecuteRequest balancerIn = new ExecuteReuqestloadBalancerIn();
        balancerIn.execute();

        ExecuteRequest balancerOut = new ExecuteReuqestloadBalancerOut();
        balancerOut.execute();
    }


}
