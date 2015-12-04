package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum ScanRegistrationType {

    SCAN_EVENT_UNDEFINED(0),
    SCAN_EVENT_NEW_DEVICE_DISCOVERED(1),
    SCAN_EVENT_STATUS_CHANGE(2);

    private int value;

    private ScanRegistrationType(int value) {
        this.value = value;
    }

    public static ScanRegistrationType getType(int value) {

        switch (value) {
            case 0:
                return SCAN_EVENT_UNDEFINED;
            case 1:
                return SCAN_EVENT_NEW_DEVICE_DISCOVERED;
            case 2:
                return SCAN_EVENT_STATUS_CHANGE;
            default:
                return SCAN_EVENT_UNDEFINED;
        }
    }

}
