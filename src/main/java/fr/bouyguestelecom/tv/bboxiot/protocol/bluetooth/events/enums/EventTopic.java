package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventTopic {

    TOPIC_NONE(0),
    TOPIC_SCAN(1),
    TOPIC_CONNECTION(2),
    TOPIC_PROPERTIES(3),
    TOPIC_BLUETOOTH_STATE(4);

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
                return TOPIC_CONNECTION;
            case 3:
                return TOPIC_PROPERTIES;
            case 4:
                return TOPIC_BLUETOOTH_STATE;
            default:
                return TOPIC_NONE;
        }
    }
}
