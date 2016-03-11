package fr.bouyguestelecom.tv.bboxiot.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;

/**
 * Incoming property change event
 *
 * @author Bertrand Martel
 */
public interface IPropertyIncomingEvent {

    /**
     * retrieve Smart property object
     *
     * @return
     */
    SmartProperty getProperty();

    /**
     * retrieve device uid
     *
     * @return
     */
    String getDeviceUid();
}
