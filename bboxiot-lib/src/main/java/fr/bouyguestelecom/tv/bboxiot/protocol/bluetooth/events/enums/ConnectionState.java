package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum ConnectionState {

    UNDEFINED(0),
    ASSOCIATION_COMPLETE(1),
    CONNECTED(2),
    DISCONNECTED(3),
    DEVICE_NOT_FOUND(4),
    CONNECTION_ERROR(5),
    CONNECTION_IDLE(6);

    private int value;

    private ConnectionState(int value) {
        this.value = value;
    }

    public static ConnectionState getState(int value) {

        switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return ASSOCIATION_COMPLETE;
            case 2:
                return CONNECTED;
            case 3:
                return DISCONNECTED;
            case 4:
                return DEVICE_NOT_FOUND;
            case 5:
                return CONNECTION_ERROR;
            case 6:
                return CONNECTION_IDLE;
            default:
                return UNDEFINED;
        }
    }
}
