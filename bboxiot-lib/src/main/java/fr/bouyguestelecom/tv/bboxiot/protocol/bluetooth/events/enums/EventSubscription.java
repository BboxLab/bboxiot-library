package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventSubscription {

    NONE(0),
    SCANNING(1),
    CONNECTION(2),
    PROPERTIES(3),
    BLUETOOTH_STATE(4),
    BLUETOOTH_FLOW_STATE(5);

    private int value;

    private EventSubscription(int value) {
        this.value = value;
    }

    public static EventSubscription getRegistration(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return SCANNING;
            case 2:
                return CONNECTION;
            case 3:
                return PROPERTIES;
            case 4:
                return BLUETOOTH_STATE;
            case 5:
                return BLUETOOTH_FLOW_STATE;
            default:
                return NONE;
        }
    }
}
