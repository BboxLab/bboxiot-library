package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;

/**
 * @author Bertrand Martel
 */
public interface IPropertyEvent {

    public SmartProperty getProperty();

    public String getDeviceUid();

}
