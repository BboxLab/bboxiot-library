package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;

/**
 * @author Bertrand Martel
 */
public interface IScanStatusChangeEvent {

    public ScanningAction getAction();

}
