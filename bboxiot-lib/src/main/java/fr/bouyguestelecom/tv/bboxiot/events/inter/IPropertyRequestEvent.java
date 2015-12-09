package fr.bouyguestelecom.tv.bboxiot.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;

/**
 * @author Bertrand Martel
 */
public interface IPropertyRequestEvent {

    public Properties getProperty();

    public Functions getFunction();

    public PropertyEventType getEventType();

    public String getDeviceUid();

    public Object getValue();

}
