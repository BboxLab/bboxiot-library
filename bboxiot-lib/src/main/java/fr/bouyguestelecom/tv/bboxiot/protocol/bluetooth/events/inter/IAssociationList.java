package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;

/**
 * @author Bertrand Martel
 */
public interface IAssociationList {

    public Map<String, BtConnection> getList();

}
