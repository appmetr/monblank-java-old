package com.appmetr.monblank;

import java.util.List;
import java.util.Map;

public class MonitoringStub implements Monitoring {

    @Override public StopWatch start(String group, String monitorName) {
        return null;
    }

    @Override public void add(String group, String monitorName, String units, double value) {
        //NOP
    }

    @Override public void inc(String group, String monitorName) {
        //NOP
    }

    @Override public StopWatch start(String group, String monitorName, Map<String, String> properties) {
        return null;
    }

    @Override public StopWatch start(MonitorKey key) {
        return null;
    }

    @Override public void add(String group, String monitorName, String units, double value, Map<String, String> properties) {
        //NOP
    }

    @Override public void add(MonitorKey key, double value) {
        //NOP
    }

    @Override public void inc(String group, String monitorName, Map<String, String> properties) {
        //NOP
    }

    @Override public void inc(MonitorKey key) {
        //NOP
    }

    @Override public List<Counter> reset() {
        return null;
    }
}
