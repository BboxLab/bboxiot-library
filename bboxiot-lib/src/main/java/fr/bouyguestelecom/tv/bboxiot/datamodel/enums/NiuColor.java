package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * Created by akinaru on 27/01/16.
 */
public enum NiuColor {

    NONE(0),
    WHITE(1),
    TECH_BLUE(2),
    COZY_GREY(3),
    WAZABI(4),
    LAGOON(5),
    SOFTBERRY(6);

    private final int value;

    private NiuColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NiuColor getColor(int value) {

        switch (value) {
            case 1:
                return WHITE;
            case 2:
                return TECH_BLUE;
            case 3:
                return COZY_GREY;
            case 4:
                return WAZABI;
            case 5:
                return LAGOON;
            case 6:
                return SOFTBERRY;
        }
        return NONE;
    }
}
