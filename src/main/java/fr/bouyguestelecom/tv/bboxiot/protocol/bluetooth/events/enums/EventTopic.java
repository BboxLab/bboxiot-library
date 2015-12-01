package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventTopic {

    TOPIC_NONE(0),
    TOPIC_SCAN(1),
    TOPIC_ASSOCIATION(2),
    TOPIC_CONNECTION(3),
    TOPIC_PROPERTIES(4),
    TOPIC_BLUETOOTH_STATE(5);

    private int value;

    private EventTopic(int value) {
        this.value = value;
    }

    public static EventTopic getTopic(int value) {

        switch (value) {
            case 0:
                return TOPIC_NONE;
            case 1:
                return TOPIC_SCAN;
            case 2:
                return TOPIC_ASSOCIATION;
            case 3:
                return TOPIC_CONNECTION;
            case 4:
                return TOPIC_PROPERTIES;
            case 5:
                return TOPIC_BLUETOOTH_STATE;
            default:
                return TOPIC_NONE;
        }
    }
}
