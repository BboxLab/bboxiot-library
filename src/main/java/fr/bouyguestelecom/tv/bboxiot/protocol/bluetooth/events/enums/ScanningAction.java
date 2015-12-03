package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum ScanningAction {

    SCANNING_ACTION_UNDEFINED(0),
    SCANNING_ACTION_START(1),
    SCANNING_ACTION_STOP(2);

    private int value;

    private ScanningAction(int value) {
        this.value = value;
    }

    public static ScanningAction getAction(int value) {

        switch (value) {
            case 0:
                return SCANNING_ACTION_UNDEFINED;
            case 1:
                return SCANNING_ACTION_START;
            case 2:
                return SCANNING_ACTION_STOP;
            default:
                return SCANNING_ACTION_UNDEFINED;
        }
    }
}
