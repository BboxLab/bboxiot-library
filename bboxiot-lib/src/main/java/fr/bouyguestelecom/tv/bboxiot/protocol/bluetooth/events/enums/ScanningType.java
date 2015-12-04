package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum ScanningType {

    SCANNING_TYPE_UNDEFINED(0),
    SCANNING_TYPE_CONTINUOUS(1),
    SCANNING_TYPE_PERMANENT(2),
    SCANNING_TYPE_PERIODIC(3);

    private int value;

    private ScanningType(int value) {
        this.value = value;
    }

    public static ScanningType getType(int value) {

        switch (value) {
            case 0:
                return SCANNING_TYPE_UNDEFINED;
            case 1:
                return SCANNING_TYPE_CONTINUOUS;
            case 2:
                return SCANNING_TYPE_PERMANENT;
            case 3:
                return SCANNING_TYPE_PERIODIC;
            default:
                return SCANNING_TYPE_UNDEFINED;
        }
    }
}
