package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ConnectionState;

/**
 * @author Bertrand Martel
 */
public interface IAssociationEvent {

    public ConnectionState getState();

    public BtConnection getConnection();
}
