package com.appmetr.monblank;

abstract class AbstractMonitor {
    /** the total for all values */
    protected double total = 0.0;
    /** The minimum of all values */
    protected double min = -Double.MAX_VALUE;
    /** The maximum of all values */
    protected double max = Double.MAX_VALUE;
    /** The total number of occurrences/calls to this object */
    protected long hits = 0;
    /** Intermediate value used to calculate std dev */
    protected double sumOfSquares = 0.0;

    /** The first time this object was accessed */
    protected long firstAccess = 0;
    /** The last time this object was accessed */
    protected long lastAccess = 0;

    protected void resetCounters() {
        total = 0.0;
        min = -Double.MAX_VALUE;
        max = Double.MAX_VALUE;
        hits = 0;
        sumOfSquares = 0.0;
        firstAccess = 0;
        lastAccess = 0;
    }

    public abstract boolean isStopWatch();

}
