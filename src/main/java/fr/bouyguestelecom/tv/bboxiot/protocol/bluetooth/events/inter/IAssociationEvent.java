package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.AssociationState;

/**
 * @author Bertrand Martel
 */
public interface IAssociationEvent {

    public AssociationState getState();

    public BtConnection getConnection();
}
