package com.algonquincollege.oop_final_backend.Utils;

import java.util.Map;

public class GetUtil {
    public static String getValue(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof String) {
            String stringValue = (String) value;
            return stringValue.isEmpty() ? null : stringValue;
        }
        return null;
    }

    public static Integer getIntValue(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value != null) {
            try {
                if (value instanceof Integer) {
                    return (Integer) value;
                } else if (value instanceof String) {
                    return Integer.parseInt((String) value);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing Integer for key '" + key + "': " + e.getMessage());
            }
        }
        return null;
    }

    public static Integer getIntValue(Object value) {
        if (value != null) {
            try {
                if (value instanceof Integer) {
                    return (Integer) value;
                } else if (value instanceof String) {
                    return Integer.parseInt((String) value);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing Integer for value '" + value + "': " + e.getMessage());
            }
        }
        return null;
    }

    public static Double getDoubleValue(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value != null) {
            try {
                if (value instanceof Double) {
                    return (Double) value;
                } else if (value instanceof String) {
                    return Double.parseDouble((String) value);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing Double for key '" + key + "': " + e.getMessage());
            }
        }
        return null;
    }

    public static Double getDoubleValue(Object value) {
        if (value != null) {
            try {
                if (value instanceof Double) {
                    return (Double) value;
                } else if (value instanceof String) {
                    return Double.parseDouble((String) value);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing Double for value '" + value + "': " + e.getMessage());
            }
        }
        return null;
    }
}
