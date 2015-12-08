package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum PropertyTypes {

    NONE(0),
    INTEGER(1),
    BOOLEAN(2),
    FLOAT(3),
    VOID(4),
    FLOAT_MAP(5),
    PIXEL(6),
    BUTTON_STATE(7);

    private int value = 0;

    private PropertyTypes(int value) {
        this.value = value;
    }

    public static PropertyTypes getPropertyType(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return INTEGER;
            case 2:
                return BOOLEAN;
            case 3:
                return FLOAT;
            case 4:
                return VOID;
            case 5:
                return FLOAT_MAP;
            case 6:
                return PIXEL;
            case 7:
                return BUTTON_STATE;
        }
        return NONE;
    }

}
