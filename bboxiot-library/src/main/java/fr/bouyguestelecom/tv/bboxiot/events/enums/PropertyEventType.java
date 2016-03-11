package fr.bouyguestelecom.tv.bboxiot.events.enums;

/**
 * Property event type enum
 *
 * @author Bertrand Martel
 */
public enum PropertyEventType {

    NONE("none"),
    PULL("pull"),
    PUSH("push"),
    PROPERTY("property"),
    INCOMING("incoming");

    private String valueStr = "";

    private PropertyEventType(String valueStr) {
        this.valueStr = valueStr;
    }

    public static PropertyEventType getPropertyEventTypeStr(String value) {

        for (PropertyEventType propertyEventType : PropertyEventType.values()) {
            if (value.equals(propertyEventType.valueStr))
                return propertyEventType;
        }
        return NONE;
    }

    public String getValueStr() {
        return valueStr;
    }
}
