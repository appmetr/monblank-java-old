package com.appmetr.monblank;

import java.util.HashMap;
import java.util.Map;

public class MonitorProperties {
    private Map<String, String> properties = new HashMap<String, String>();

    public static MonitorProperties create() {
        return new MonitorProperties();
    }

    public static MonitorProperties create(String name, String value) {
        return create().add(name, value);
    }

    public static MonitorProperties create(Map<String, String> propertires) {
        MonitorProperties monitorProperties = new MonitorProperties();
        monitorProperties.properties = new HashMap<String, String>(propertires);

        return monitorProperties;
    }

    public MonitorProperties add(String name, String value) {
        properties.put(name, value);

        return this;
    }

    public Map<String, String> asMap() {
        return properties;
    }
}
