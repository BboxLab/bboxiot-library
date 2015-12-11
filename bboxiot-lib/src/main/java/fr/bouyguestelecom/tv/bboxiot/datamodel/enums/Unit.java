package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum Unit {

    NONE(0),
    CELSIUS(1),
    PURCENT(2),
    VOLTAGE(3),
    AMPERE(4),
    SECOND(5),
    WATT(6);

    private int value = 0;

    private Unit(int value) {
        this.value = value;
    }

    public static Unit getUnit(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return CELSIUS;
            case 2:
                return PURCENT;
            case 3:
                return VOLTAGE;
            case 4:
                return AMPERE;
            case 5:
                return SECOND;
            case 6:
                return WATT;
        }
        return NONE;
    }

    public static String getUnitStr(Unit value) {

        switch (value) {
            case CELSIUS:
                return "°C";
            case PURCENT:
                return "%";
            case VOLTAGE:
                return "V";
            case AMPERE:
                return "A";
            case SECOND:
                return "s";
            case WATT:
                return "W";
        }
        return "";
    }

}
