package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.PropertiesEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IPropertyEvent;

/**
 * @author Bertrand Martel
 */
public class PropertyIncomingEvent extends GenericEventAbstr implements IPropertyEvent {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private SmartProperty property = null;

    private String deviceUuid = "";

    public PropertyIncomingEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY) &&
                    data.has(BluetoothConst.BLUETOOTH_DEVICE_UUID)) {

                deviceUuid = data.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);

                JSONObject propertyJson = data.getJSONObject(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY);

                property = SmartProperty.parse(propertyJson);

            } else {
                Log.e(TAG, "Error in association item event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SmartProperty getProperty() {
        return property;
    }

    @Override
    public String getDeviceUid() {
        return deviceUuid;
    }

}
