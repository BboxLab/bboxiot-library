/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 InnovationLab BboxLab
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IScanList;

/**
 * @author Bertrand Martel
 */
public class ScanListItem extends GenericEventAbstr implements IScanList {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private Map<String, BluetoothSmartDevice> deviceList = new HashMap<>();

    public ScanListItem(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(ScanningEventConstant.SCANNING_EVENT_ITEMS)) {

                JSONArray array = data.getJSONArray(ScanningEventConstant.SCANNING_EVENT_ITEMS);

                for (int i = 0; i < array.length(); i++) {

                    BluetoothSmartDevice device = BluetoothSmartDevice.parse(array.getJSONObject(i));
                    if (device != null) {
                        deviceList.put(device.getDeviceUuid(), device);
                    } else {
                        Log.e(TAG, "Error smart device parsed is null");
                    }

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
