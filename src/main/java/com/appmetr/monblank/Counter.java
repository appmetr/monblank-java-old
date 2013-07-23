package com.appmetr.monblank;

import java.util.Map;

public class Counter {

    //copy of counter's key
    private MonitorKey key;

    /** the total for all values */
    protected double total = 0.0;
    /** The minimum of all values */
    protected double min = Double.MAX_VALUE;
    /** The maximum of all values */
    protected double max = -Double.MAX_VALUE;
    /** The total number of occurrences/calls to this object */
    protected long hits = 0;
    /** Intermediate value used to calculate std dev */
    protected double sumOfSquares = 0.0;

    /** The first time this object was accessed */
    protected long firstAccess = 0;
    /** The last time this object was accessed */
    protected long lastAccess = 0;

    public Counter(MonitorKey key) {
        this.key = key;
    }

    public Counter(String name, Map<String, String> properties) {
        this.key = new MonitorKey(name, properties);
    }

    public Counter(String name) {
        this.key = new MonitorKey(name);
    }

    public Counter(String monitorName, String... properties) {
        this.key = new MonitorKey(monitorName, properties);
    }

    public MonitorKey getKey() {
        return key;
    }

    public synchronized Counter update(double value) {
        total += value;
        hits++;
        if (value < min) min = value;
        if (value > max) max = value;
        sumOfSquares += value * value;
        if (firstAccess == 0) firstAccess = System.currentTimeMillis();
        lastAccess = System.currentTimeMillis();

        return this;
    }

    protected synchronized void reset() {
        total = 0.0;
        min = -Double.MAX_VALUE;
        max = Double.MAX_VALUE;
        hits = 0;
        sumOfSquares = 0.0;
        firstAccess = 0;
        lastAccess = 0;
    }

    public double getTotal() {
        return total;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public long getHits() {
        return hits;
    }

    public double getSumOfSquares() {
        return sumOfSquares;
    }

    public long getFirstAccess() {
        return firstAccess;
    }

    public long getLastAccess() {
        return lastAccess;
    }

    @Override public String toString() {
        return "Counter{" +
                "key=" + key +
                ", total=" + total +
                ", min=" + min +
                ", max=" + max +
                ", hits=" + hits +
                ", sumOfSquares=" + sumOfSquares +
                ", firstAccess=" + firstAccess +
                ", lastAccess=" + lastAccess +
                '}';
    }
}
