package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum ButtonState {

    NONE(0),
    RELEASED(1),
    PUSHED(2),
    DOUBLE_PUSH(3),
    LONG_PUSH(4);

    private final int value;

    private ButtonState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ButtonState getState(int value) {

        switch (value) {
            case 1:
                return RELEASED;
            case 2:
                return PUSHED;
            case 3:
                return DOUBLE_PUSH;
            case 4:
                return LONG_PUSH;
        }
        return NONE;
    }
}
