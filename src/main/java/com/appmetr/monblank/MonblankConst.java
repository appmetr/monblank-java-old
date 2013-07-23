package com.appmetr.monblank;

public class MonblankConst {

    public static final int MONITOR_FLUSH_INTERVAL_MINUTES = 1;
    public static final int MONITOR_RESET_INTERVAL_MINUTES = 1;

    public static final String MONITORING_TOKEN = "monitoring";
    public static final String EVENT_DELIMITER = "/";
    public static final String UNIT_DELIMITER = " ";

    public static final String INSTANCE_FEATURE = "$instance";
    public static final String TOKEN_FEATURE = "$token";
    public static final String AVG_FEATURE = "$avg";
    public static final String STDDEV_FEATURE = "$stdDev";
    public static final String HITS_FEATURE = "$hits";
    public static final String TOTAL_FEATURE = "$total";
    public static final String MIN_FEATURE = "$min";
    public static final String MAX_FEATURE = "$max";
    public static final String SQUARES_SUM_FEATURES = "$sumOfSquares";


    public static final String BYTES = "bytes";
    public static final String COUNT = "count";
    public static final String MS = "ms";

    public static final String DELIMITER = "@";
    public static final String ALL = "any";

    public static final String HITS = "Hits";
    public static final String AVG = "Avg";
    public static final String TOTAL = "Total";
    public static final String STD_DEV = "StdDev";
    public static final String LAST_VALUE = "LastValue";
    public static final String MIN = "Min";
    public static final String MAX = "Max";
    public static final String ACTIVE = "Active";
    public static final String AVG_ACTIVE = "AvgActive";
    public static final String MAX_ACTIVE = "MaxActive";
    public static final String SQUARES_SUM = "sumOfSquares";

    public static final String[] indicators = {HITS, TOTAL, MIN, MAX};

}
