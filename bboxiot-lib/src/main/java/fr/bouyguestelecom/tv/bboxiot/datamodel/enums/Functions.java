package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum Functions {

    NONE(0),
    SWITCH(1),
    SMART_METER(2),
    BATTERY(3),
    PLANT_MONITOR(4),
    RGB_LED(5),
    WHITE_LED(6),
    OIL_DIFFUSER(7),
    TEMPERATURE(8),
    HUMIDITY(9),
    BUTTON(10),
    BUZZER(11),
    PIXEL(12);

    private int value = 0;

    private Functions(int value) {
        this.value = value;
    }

    public static Functions getFunction(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return SWITCH;
            case 2:
                return SMART_METER;
            case 3:
                return BATTERY;
            case 4:
                return PLANT_MONITOR;
            case 5:
                return RGB_LED;
            case 6:
                return WHITE_LED;
            case 7:
                return OIL_DIFFUSER;
            case 8:
                return TEMPERATURE;
            case 9:
                return HUMIDITY;
            case 10:
                return BUTTON;
            case 11:
                return BUZZER;
            case 12:
                return PIXEL;
        }
        return NONE;
    }
}
