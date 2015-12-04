package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;

/**
 * @author Bertrand Martel
 */
public interface IScanList {

    public Map<String, BluetoothSmartDevice> getList();

}
