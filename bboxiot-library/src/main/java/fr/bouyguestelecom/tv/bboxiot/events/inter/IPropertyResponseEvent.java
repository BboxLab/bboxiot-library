package fr.bouyguestelecom.tv.bboxiot.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ActionStatus;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;

/**
 * Property response event
 *
 * @author Bertrand Martel
 */
public interface IPropertyResponseEvent {

    /**
     * get smart property object
     *
     * @return
     */
    SmartProperty getProperty();

    /**
     * get device uid
     *
     * @return
     */
    String getDeviceUid();

    /**
     * get action status for this event
     *
     * @return
     */
    ActionStatus getStatus();

    /**
     * get property event type
     *
     * @return
     */
    PropertyEventType getActionType();

    /**
     * get action id for this event
     *
     * @return
     */
    String getActionId();

}
