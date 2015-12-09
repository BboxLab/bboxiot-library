package fr.bouyguestelecom.tv.bboxiot.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;

/**
 * @author Bertrand Martel
 */
public interface IPropertyIncomingEvent {

    public SmartProperty getProperty();

    public String getDeviceUid();
}
