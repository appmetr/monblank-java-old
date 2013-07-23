package com.appmetr.monblank;

import java.util.HashMap;
import java.util.Map;

public class MonitorKey {

    private String name;
    private Map<String, String> properties;

    private final int precalcHash;

    public MonitorKey(String name) {
        this.name = name;
        this.properties = new HashMap<String, String>();
        precalcHash = precalcHash();
    }

    public MonitorKey(String name, Map<String, String> properties) {
        this.name = name;
        this.properties = properties == null ? new HashMap<String, String>() : properties;
        precalcHash = precalcHash();
    }

    public MonitorKey(String name, String... properties) {
        this.name = name;
        this.properties = new HashMap<String, String>();
        for (int i = 0; i < properties.length; i = i + 2) {
            String property = properties[i];
            String value = properties[i + 1];

            this.properties.put(property, value);
        }
        precalcHash = precalcHash();
    }

    public String getName() {
        return name;
    }

    public String get(String name) {
        return properties.get(name);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonitorKey that = (MonitorKey) o;

        if (!name.equals(that.name)) return false;
        if (!properties.equals(that.properties)) return false;

        return true;
    }

    private int precalcHash() {
        int result = name.hashCode();
        return 31 * result + properties.hashCode();
    }

    @Override
    public int hashCode() {
        return precalcHash;
    }
}
