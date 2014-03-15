package com.appmetr.monblank;

import java.util.List;

public class MonitoringStub implements Monitoring {

    @Override public StopWatch start(String group, String monitorName) {
        return new StopWatch().start();
    }

    @Override public void add(String group, String monitorName, String units, double value) {
        //NOP
    }

    @Override public void inc(String group, String monitorName) {
        //NOP
    }

    @Override public StopWatch start(String group, String monitorName, String propertyName, String propertyValue) {
        return new StopWatch().start();
    }

    @Override public StopWatch start(String group, String monitorName, String... properties) {
        return new StopWatch().start();
    }

    @Override public StopWatch start(MonitorKey key) {
        return new StopWatch().start();
    }

    @Override
    public void add(String group, String monitorName, String units, double value, String propertyName, String propertyValue) {
        //NOP
    }

    @Override public void add(String group, String monitorName, String units, double value, String... properties) {
        //NOP
    }

    @Override public void add(MonitorKey key, double value) {
        //NOP
    }


    @Override public void inc(String group, String monitorName, String propertyName, String propertyValue) {
        //NOP
    }

    @Override public void inc(String group, String monitorName, String... properties) {
        //NOP
    }

    @Override public void inc(MonitorKey key) {
        //NOP
    }

    @Override public List<Counter> reset() {
        return null;
    }

}
