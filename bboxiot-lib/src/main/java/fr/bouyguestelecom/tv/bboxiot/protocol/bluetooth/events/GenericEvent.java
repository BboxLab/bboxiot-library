package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;

/**
 * @author Bertrand Martel
 */
public class GenericEvent extends GenericEventAbstr {

    public GenericEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);
    }
}
