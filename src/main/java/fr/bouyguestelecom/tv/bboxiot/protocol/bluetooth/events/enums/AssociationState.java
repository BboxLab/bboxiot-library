package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum AssociationState {

    UNDEFINED(0),
    ASSOCIATION_COMPLETE(1),
    CONNECTED(2),
    DISCONNECTED(3),
    DEVICE_NOT_FOUND(4),
    CONNECTION_ERROR(5);

    private int value;

    private AssociationState(int value) {
        this.value = value;
    }

    public static AssociationState getState(int value) {

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
            default:
                return UNDEFINED;
        }
    }
}
