package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IScanListItemEvent;

/**
 * @author Bertrand Martel
 */
public class ScanListItem extends GenericEventAbstr implements IScanListItemEvent {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private Map<String, BluetoothSmartDevice> deviceList = new HashMap<>();

    public ScanListItem(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(ScanningEventConstant.SCANNING_EVENT_ITEMS)) {

                JSONArray array = data.getJSONArray(ScanningEventConstant.SCANNING_EVENT_ITEMS);

                for (int i = 0; i < array.length(); i++) {

                    BluetoothSmartDevice device = BluetoothSmartDevice.parse(array.getJSONObject(i));
                    deviceList.put(device.getDeviceUuid(), device);

                }
            } else {
                Log.e(TAG, "Error in scan list event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, BluetoothSmartDevice> getList() {
        return deviceList;
    }
}
