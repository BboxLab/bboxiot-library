package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum Properties {

    NONE(0),
    ONOFF(1),
    CURRENT(2),
    TENSION(3),
    POWER_FACTOR(4),
    ACTIVE_POWER(5),
    REACTIVE_POWER(6),
    FREQUENCY_MEASUREMENT(7),
    STATE(8),
    SUNLIGHT(9),
    AIR_TEMPERATURE(10),
    SOIL_TEMPERATURE(11),
    SOIL_ELECTRODUCTIVITY(12),
    WATER_CONTENT(13),
    COLOR(14),
    INTENSITY(15),
    TEMPERATURE(16),
    SPEED(17),
    HUMIDITY(18);

    private int value = 0;

    private Properties(int value) {
        this.value = value;
    }

    public static Properties getProperty(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return ONOFF;
            case 2:
                return CURRENT;
            case 3:
                return TENSION;
            case 4:
                return POWER_FACTOR;
            case 5:
                return ACTIVE_POWER;
            case 6:
                return REACTIVE_POWER;
            case 7:
                return FREQUENCY_MEASUREMENT;
            case 8:
                return STATE;
            case 9:
                return SUNLIGHT;
            case 10:
                return AIR_TEMPERATURE;
            case 11:
                return SOIL_TEMPERATURE;
            case 12:
                return SOIL_ELECTRODUCTIVITY;
            case 13:
                return WATER_CONTENT;
            case 14:
                return COLOR;
            case 15:
                return INTENSITY;
            case 16:
                return TEMPERATURE;
            case 17:
                return SPEED;
            case 18:
                return HUMIDITY;
        }
        return NONE;
    }
}
