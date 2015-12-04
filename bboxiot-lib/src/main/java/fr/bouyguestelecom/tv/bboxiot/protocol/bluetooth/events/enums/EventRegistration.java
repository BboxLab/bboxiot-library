package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventRegistration {

    REGISTRATION_NONE(0),
    REGISTRATION_SCANNING(1),
    REGISTRATION_CONNECTION(2),
    REGISTRATION_PROPERTIES(3),
    REGISTRATION_BLUETOOTH_STATE(4),
    REGISTRATION_BLUETOOTH_FLOW_STATE(5);

    private int value;

    private EventRegistration(int value) {
        this.value = value;
    }

    public static EventRegistration getRegistration(int value) {

        switch (value) {
            case 0:
                return REGISTRATION_NONE;
            case 1:
                return REGISTRATION_SCANNING;
            case 2:
                return REGISTRATION_CONNECTION;
            case 3:
                return REGISTRATION_PROPERTIES;
            case 4:
                return REGISTRATION_BLUETOOTH_STATE;
            case 5:
                return REGISTRATION_BLUETOOTH_FLOW_STATE;
            default:
                return REGISTRATION_NONE;
        }
    }
}
