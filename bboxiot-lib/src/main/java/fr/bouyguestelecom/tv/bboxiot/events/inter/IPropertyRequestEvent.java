package fr.bouyguestelecom.tv.bboxiot.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;

/**
 * Property request event
 *
 * @author Bertrand Martel
 */
public interface IPropertyRequestEvent {

    /**
     * retrieve Property enum value
     *
     * @return
     */
    Properties getProperty();

    /**
     * retrieve Function enum value
     *
     * @return
     */
    Functions getFunction();

    /**
     * retrieve property type
     *
     * @return
     */
    PropertyEventType getEventType();

    /**
     * retrieve device uid
     *
     * @return
     */
    String getDeviceUid();

    /**
     * retrieve property value
     *
     * @return
     */
    Object getValue();

}
