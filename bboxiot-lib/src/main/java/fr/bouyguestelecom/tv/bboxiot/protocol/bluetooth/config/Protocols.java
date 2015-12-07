package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.config;

/**
 * @author Bertrand Martel
 */
public enum Protocols {

    UNDEFINED(0),
    BLUETOOTH(1),
    WIFI(2);

    private int value;

    private Protocols(int value) {
        this.value = value;
    }

    public static Protocols getProtocol(int value) {

        switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return BLUETOOTH;
            case 2:
                return WIFI;
            default:
                return UNDEFINED;
        }
    }
}
