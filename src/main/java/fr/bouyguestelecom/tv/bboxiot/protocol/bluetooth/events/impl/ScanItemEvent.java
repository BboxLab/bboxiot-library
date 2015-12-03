package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IScanItemEvent;

/**
 * @author Bertrand Martel
 */
public class ScanItemEvent extends GenericEventAbstr implements IScanItemEvent {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private BluetoothSmartDevice device = null;

    public ScanItemEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(ScanningEventConstant.SCANNING_EVENT_ITEMS)) {

                JSONObject value = data.getJSONObject(ScanningEventConstant.SCANNING_EVENT_ITEMS);

                device = BluetoothSmartDevice.parse(value);
            } else {
                Log.e(TAG, "Error in scan item event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BluetoothSmartDevice getItem() {
        return device;
    }
}
