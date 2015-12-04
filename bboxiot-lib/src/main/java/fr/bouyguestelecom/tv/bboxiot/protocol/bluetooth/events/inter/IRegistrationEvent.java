package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter;

import java.util.Set;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventSubscription;

/**
 * @author Bertrand Martel
 */
public interface IRegistrationEvent {

    public Set<EventSubscription> getRegistrationType();
}
