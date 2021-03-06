package fr.bouyguestelecom.tv.bboxiot.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.events.constant.PropertiesEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;
import fr.bouyguestelecom.tv.bboxiot.events.inter.IPropertyRequestEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * Property request event type
 * <p/>
 * for requesting an action on a specific property/function
 *
 * @author Bertrand Martel
 */
public class PropertyRequestEvent extends GenericEventAbstr implements IPropertyRequestEvent {

    private static String TAG = PropertyRequestEvent.class.getSimpleName();

    /**
     * property enum
     */
    private Properties property = Properties.NONE;

    /**
     * function enum
     */
    private Functions function = Functions.NONE;

    /**
     * device uid which own the property
     */
    private String deviceUuid = "";

    /**
     * value to be sent
     */
    private Object value = null;

    private PropertyEventType eventType = PropertyEventType.NONE;

    public PropertyRequestEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY) &&
                    data.has(BluetoothConst.BLUETOOTH_DEVICE_UUID) &&
                    data.has(PropertiesEventConstant.PROPERTIES_EVENT_TYPE) &&
                    data.has(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION)) {

                deviceUuid = data.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);

                property = Properties.getPropertyStr(data.getString(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY));

                eventType = PropertyEventType.getPropertyEventTypeStr(data.getString(PropertiesEventConstant.PROPERTIES_EVENT_TYPE));

                function = Functions.getFunctionStr(data.getString(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION));

                if (eventType == PropertyEventType.PUSH) {

                    if (data.has(PropertiesEventConstant.PROPERTIES_EVENT_VALUE)) {

                        value = data.get(PropertiesEventConstant.PROPERTIES_EVENT_VALUE);

                    } else {
                        Log.e(TAG, "Error push must have value attribute");
                    }
                }
            } else {
                Log.e(TAG, "Error in association item event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Properties getProperty() {
        return property;
    }

    @Override
    public Functions getFunction() {
        return function;
    }

    @Override
    public PropertyEventType getEventType() {
        return eventType;
    }

    @Override
    public String getDeviceUid() {
        return deviceUuid;
    }

    @Override
    public Object getValue() {
        return value;
    }

}
