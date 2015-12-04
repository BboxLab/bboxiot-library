package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningType;

/**
 * @author Bertrand Martel
 */
public interface IScanningEvent {

    public ScanningAction getAction();

    public ScanningType getScanType();

    public String getTargetDeviceUid();

    public int getPeriod();

    public int getDutyCycle();
}
