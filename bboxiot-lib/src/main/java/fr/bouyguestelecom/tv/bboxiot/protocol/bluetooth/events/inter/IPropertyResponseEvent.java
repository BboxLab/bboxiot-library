package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ActionStatus;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.PropertyEventType;

/**
 * @author Bertrand Martel
 */
public interface IPropertyResponseEvent {

    public SmartProperty getProperty();

    public String getDeviceUid();

    public ActionStatus getStatus();

    public PropertyEventType getActionType();

    public String getActionId();

}
