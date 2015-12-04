package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IScanningEvent;

/**
 * @author Bertrand Martel
 */
public class ScanStatusEvent extends GenericEventAbstr implements IScanningEvent {

    private final static String TAG = ScanStatusEvent.class.getSimpleName();

    private ScanningAction action = ScanningAction.SCANNING_ACTION_UNDEFINED;

    private ScanningType scanType = ScanningType.SCANNING_TYPE_UNDEFINED;

    private String targetDeviceUid = "";

    private int period = -1;

    private int dutyCycle = -1;

    public ScanStatusEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {

            if (data.has(ScanningEventConstant.SCANNING_EVENT_ACTION)) {
                action = ScanningAction.getAction(data.getInt(ScanningEventConstant.SCANNING_EVENT_ACTION));
            }
            if (data.has(ScanningEventConstant.SCANNING_EVENT_TYPE)) {
                scanType = ScanningType.getType(data.getInt(ScanningEventConstant.SCANNING_EVENT_TYPE));
            }
            if (data.has(ScanningEventConstant.SCANNING_EVENT_TARGET_DEVICE_UID)) {
                targetDeviceUid = data.getString(ScanningEventConstant.SCANNING_EVENT_TARGET_DEVICE_UID);
            }
            if (data.has(ScanningEventConstant.SCANNING_EVENT_PERIOD)) {
                period = data.getInt(ScanningEventConstant.SCANNING_EVENT_PERIOD);
            }
            if (data.has(ScanningEventConstant.SCANNING_EVENT_DUTY)) {
                dutyCycle = data.getInt(ScanningEventConstant.SCANNING_EVENT_DUTY);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ScanningAction getAction() {
        return action;
    }

    @Override
    public ScanningType getScanType() {
        return scanType;
    }

    @Override
    public String getTargetDeviceUid() {
        return targetDeviceUid;
    }

    @Override
    public int getPeriod() {
        return period;
    }

    @Override
    public int getDutyCycle() {
        return dutyCycle;
    }
}
