package fr.bouyguestelecom.tv.bboxiot.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ActionStatus;
import fr.bouyguestelecom.tv.bboxiot.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.events.constant.PropertiesEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;
import fr.bouyguestelecom.tv.bboxiot.events.inter.IPropertyResponseEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * @author Bertrand Martel
 */
public class PropertyResponseEvent extends GenericEventAbstr implements IPropertyResponseEvent {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private SmartProperty property = null;

    private String deviceUuid = "";

    private ActionStatus status = ActionStatus.NONE;

    private PropertyEventType eventType = PropertyEventType.NONE;

    private String actionId = "";

    public PropertyResponseEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY) &&
                    data.has(BluetoothConst.BLUETOOTH_DEVICE_UUID) &&
                    data.has(PropertiesEventConstant.PROPERTIES_ACTION_STATUS) &&
                    data.has(PropertiesEventConstant.PROPERTIES_EVENT_TYPE) &&
                    data.has(PropertiesEventConstant.PROPERTIES_ACTION_ID)) {

                deviceUuid = data.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);

                status = ActionStatus.getActionStatusStr(data.getString(PropertiesEventConstant.PROPERTIES_ACTION_STATUS));

                actionId = data.getString(PropertiesEventConstant.PROPERTIES_ACTION_ID);

                eventType = PropertyEventType.getPropertyEventTypeStr(data.getString(PropertiesEventConstant.PROPERTIES_EVENT_TYPE));

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

    @Override
    public ActionStatus getStatus() {
        return status;
    }

    @Override
    public PropertyEventType getActionType() {
        return eventType;
    }

    @Override
    public String getActionId() {
        return actionId;
    }
}
