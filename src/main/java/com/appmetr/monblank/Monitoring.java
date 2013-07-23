package com.appmetr.monblank;

/*
    NOTE: do not remove service+implementation pair. Wicket's guice injection cant' instantiate services without interface!
 */

import java.util.List;

public interface Monitoring {

    /**
     *  Creates and starts monitor and returns it instance
     *
     * @param group       - group name
     * @param monitorName - name of monitor.<br/><b>Do not use character '@' in group or monitor name!</b>
     * @return - monitor instance to stop created monitor
     */
    public StopWatch start(String group, String monitorName);

    /**
     * Add value to monitor.
     *
     * @param group       - group name
     * @param monitorName - name.<br/> <b>Do not use character '@' in group or monitor name!</b>
     * @param units       - measuring units (should be one of BYTES\COUNT\MS constant from MonitoringService)
     * @param value       - value to add
     */
    public void add(String group, String monitorName, String units, double value);

    /**
     * Increment monitor's value by 1
     *
     * @param group       - group name
     * @param monitorName - name.<br/> <b>Do not use character '@' in group or monitor name!</b>
     */
    public void inc(String group, String monitorName);

    /**
     *  Creates and starts monitor and returns it instance
     *
     * @param monitorName - name of monitor.<br/><b>Do not use character '@' in group or monitor name!</b>
     * @return - monitor instance to stop created monitor
     */
    public StopWatch start(String monitorName);

    public StopWatch start(String monitorName, String propertyName, String propertyValue);

    public StopWatch start(String monitorName, String... properties);

    public StopWatch start(MonitorKey key);


    /**
     * Add value to monitor.
     *
     * @param monitorName - name.<br/> <b>Do not use character '@' in group or monitor name!</b>
     * @param units       - measuring units (should be one of BYTES\COUNT\MS constant from MonitoringService)
     * @param value       - value to add
     */
    public void add(String monitorName, String units, double value);

    public void add(String monitorName, String units, double value, String propertyName, String propertyValue);

    public void add(String monitorName, String units, double value, String... properties);

    public void add(MonitorKey key, double value);

    /**
     * Increment monitor's value by 1
     *
     * @param monitorName - name.<br/> <b>Do not use character '@' in group or monitor name!</b>
     */
    public void inc(String monitorName);

    public void inc(String monitorName, String propertyName, String propertyValue);

    public void inc(String monitorName, String... properties);

    public void inc(MonitorKey key);

    /**
     * Removes all currently active monitors and resets all counters.
     * @return List of all counters existed before reset
     */
    public List<Counter> reset();
}
