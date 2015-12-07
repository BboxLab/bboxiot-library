package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection;

/**
 * @author Bertrand Martel
 */
public enum ConnectionMode {

    MODE_NONE(0),
    MODE_CONNECTION(1),
    MODE_ADVERTIZING(2),;

    private int value = 0;

    private ConnectionMode(int value) {
        this.value = value;
    }

    public static ConnectionMode getMode(int value) {

        switch (value) {
            case 0:
                return MODE_NONE;
            case 1:
                return MODE_CONNECTION;
            case 2:
                return MODE_ADVERTIZING;
        }
        return MODE_NONE;
    }

}
