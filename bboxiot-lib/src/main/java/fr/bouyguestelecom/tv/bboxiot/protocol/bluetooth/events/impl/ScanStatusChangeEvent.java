package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IScanStatusChangeEvent;

/**
 * @author Bertrand Martel
 */
public class ScanStatusChangeEvent extends GenericEventAbstr implements IScanStatusChangeEvent {

    private static String TAG = ScanStatusChangeEvent.class.getSimpleName();

    private ScanningAction action = ScanningAction.SCANNING_ACTION_UNDEFINED;

    public ScanStatusChangeEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {

            if (data.has(ScanningEventConstant.SCANNING_EVENT_ACTION)) {
                action = ScanningAction.getAction(data.getInt(ScanningEventConstant.SCANNING_EVENT_ACTION));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ScanningAction getAction() {
        return action;
    }
}
