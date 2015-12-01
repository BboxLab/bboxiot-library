package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventType {

    EVENT_UNKNOWN(0),
    EVENT_REQUEST(1),
    EVENT_RESPONSE(2),
    EVENT_REGISTRATION(3),
    EVENT_INCOMING(4);

    private int value;

    private EventType(int value) {
        this.value = value;
    }

    public static EventType getType(int value) {

        switch (value) {
            case 0:
                return EVENT_UNKNOWN;
            case 1:
                return EVENT_REQUEST;
            case 2:
                return EVENT_RESPONSE;
            case 3:
                return EVENT_REGISTRATION;
            case 4:
                return EVENT_INCOMING;
            default:
                return EVENT_UNKNOWN;
        }
    }
}
