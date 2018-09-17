package com.acme.code.gen;

import com.acme.code.gen.util.IDUtil;
import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {


        Set<Long> idContainer = new HashSet<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 200000; i++) {
            Long aLong = IDUtil.nextId();
            if (idContainer.contains(aLong)) {
                System.out.println("重复:" + aLong);
            } else {
                System.out.println(aLong);
                idContainer.add(aLong);
            }
        }
        stopWatch.stop();
        System.out.println("size:" + idContainer.size()+",time:"+stopWatch.getTime(TimeUnit.MILLISECONDS)+"ms" );
    }
}
