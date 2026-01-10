package com.itheima.tlias;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    //日志对象
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        log.trace("trace");
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.error("error");
    }
}
