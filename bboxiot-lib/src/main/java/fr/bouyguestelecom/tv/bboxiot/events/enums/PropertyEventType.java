package fr.bouyguestelecom.tv.bboxiot.events.enums;

/**
 * @author Bertrand Martel
 */
public enum PropertyEventType {

    NONE(0),
    PULL(1),
    PUSH(2),
    PROPERTY(3),
    INCOMING(4);

    private int value;

    private PropertyEventType(int value) {
        this.value = value;
    }

    public static PropertyEventType getPropertyEventType(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return PULL;
            case 2:
                return PUSH;
            case 3:
                return PROPERTY;
            case 4:
                return INCOMING;
            default:
                return NONE;
        }
    }

}
