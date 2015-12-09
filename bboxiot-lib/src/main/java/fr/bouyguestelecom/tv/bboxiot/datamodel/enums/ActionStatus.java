package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum ActionStatus {

    NONE(0),
    SUCCESS(1),
    ERROR(2);

    private int value = 0;

    private ActionStatus(int value) {
        this.value = value;
    }

    public static ActionStatus getStatus(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return SUCCESS;
            case 2:
                return ERROR;
        }
        return NONE;
    }
}
