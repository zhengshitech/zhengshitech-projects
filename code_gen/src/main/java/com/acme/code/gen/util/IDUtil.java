package com.acme.code.gen.util;

/**
 * @author H
 */
public class IDUtil {
    static SnowFlake sf = new SnowFlake(1, 1);

    private IDUtil() {
    }

    public static Long nextId() {
        return sf.nextId();
    }


    /**
     * 雪花ID生成算法
     *
     * @author H
     */
    static class SnowFlake {

        /**
         * 起始的时间戳
         */
        private final static long START_STAMP = 1385093532988L;

        /**
         * 序列号占用的位数
         */
        private final static long SEQUENCE_BIT = 12;
        /**
         * 机器标识占用的位数
         */
        private final static long MACHINE_BIT = 5;
        /**
         * 数据中心占用的位数
         */
        private final static long DATA_CENTER_BIT = 5;

        /**
         * 最大数据中心31个
         */
        private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);
        /**
         * 最大机器数量 31个
         */
        private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
        /**
         * 最大序列4095
         */
        private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

        /**
         * 每一部分向左的位移
         */
        private final static long MACHINE_LEFT = SEQUENCE_BIT;
        private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
        private final static long TIME_STAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

        /**
         * 数据中心
         */
        private long dataCenterId;
        /**
         * 机器标识
         */
        private long machineId;
        /**
         * 序列号
         */
        private long sequence = 0L;
        /**
         * 上一次时间戳
         */
        private long lastStamp = -1L;

        SnowFlake(long dataCenterId, long machineId) {
            if (dataCenterId > MAX_DATACENTER_NUM || dataCenterId < 0) {
                throw new IllegalArgumentException("dataCenterId can't be greater than " + MAX_DATACENTER_NUM + " or less than 0");
            }
            if (machineId > MAX_MACHINE_NUM || machineId < 0) {
                throw new IllegalArgumentException("machineId can't be greater than " + MAX_MACHINE_NUM + " or less than 0");
            }
            this.dataCenterId = dataCenterId;
            this.machineId = machineId;
        }

        /**
         * 下一个生成的ID
         *
         * @return 生成的ID
         */
        synchronized long nextId() {
            long currentTimeStamp = getNewTimeStamp();
            if (currentTimeStamp < lastStamp) {
                throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
            }

            if (currentTimeStamp == lastStamp) {
                //相同毫秒内，序列号自增
                sequence = (sequence + 1) & MAX_SEQUENCE;
                //同一毫秒的序列数已经达到最大
                if (sequence == 0L) {
                    currentTimeStamp = getNextMill();
                }
            } else {
                //不同毫秒内，序列号置为0
                sequence = 0L;
            }

            lastStamp = currentTimeStamp;

            /**
             * line1.时间戳部分
             * line2.数据中心部分
             * line3.机器标识部分
             * line4.序列号部分
             */
            return (currentTimeStamp - START_STAMP) << TIME_STAMP_LEFT
                    | dataCenterId << DATA_CENTER_LEFT
                    | machineId << MACHINE_LEFT
                    | sequence;
        }

        private long getNextMill() {
            long mill = getNewTimeStamp();
            while (mill <= lastStamp) {
                mill = getNewTimeStamp();
            }
            return mill;
        }

        private long getNewTimeStamp() {
            return System.currentTimeMillis();
        }

    }
}
