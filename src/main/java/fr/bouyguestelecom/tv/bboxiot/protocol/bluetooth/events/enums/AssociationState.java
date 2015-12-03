package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum AssociationState {

    ASSOCIATION_UNDEFINED(0),
    ASSOCIATION_CONNECTED(1),
    ASSOCIATION_DISCONNECTED(2),
    ASSOCIATION_DEVICE_NOT_FOUND(3),
    ASSOCIATION_CONNECTION_ERROR(4);

    private int value;

    private AssociationState(int value) {
        this.value = value;
    }

    public static AssociationState getState(int value) {

        switch (value) {
            case 0:
                return ASSOCIATION_UNDEFINED;
            case 1:
                return ASSOCIATION_CONNECTED;
            case 2:
                return ASSOCIATION_DISCONNECTED;
            case 3:
                return ASSOCIATION_DEVICE_NOT_FOUND;
            case 4:
                return ASSOCIATION_CONNECTION_ERROR;
            default:
                return ASSOCIATION_UNDEFINED;
        }
    }
}
