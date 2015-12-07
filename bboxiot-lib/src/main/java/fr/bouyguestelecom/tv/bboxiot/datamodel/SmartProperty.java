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
package fr.bouyguestelecom.tv.bboxiot.datamodel;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Capability;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * @author Bertrand Martel
 */
public class SmartProperty implements ICapable {

    private static String TAG = SmartProperty.class.getSimpleName();

    private String name = "";

    private Object value = null;

    private EnumSet<Capability> capabilities = null;

    public SmartProperty(String name, List<Capability> capabilities) {
        this.name = name;
        for (int i = 0; i < capabilities.size(); i++) {
            this.capabilities.add(capabilities.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public EnumSet<Capability> getCapabilities() {
        return capabilities;
    }

    @Override
    public boolean isPushAble() {
        return capabilities.contains(Capability.PUSH);
    }

    @Override
    public boolean isPullAble() {
        return capabilities.contains(Capability.PULL);
    }

    @Override
    public boolean isSetAble() {
        return capabilities.contains(Capability.SET);
    }

    @Override
    public boolean isGetAble() {
        return capabilities.contains(Capability.GET);
    }

    @Override
    public boolean isMonitorAble() {
        return capabilities.contains(Capability.MONITOR);
    }

    public static SmartProperty parse(JSONObject item) {
        try {
            if (item.has(BluetoothConst.BT_CONNECTION_SMART_NAME) &&
                    item.has(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES) &&
                    item.has(BluetoothConst.BT_CONNECTION_SMART_VALUE)) {

                String name = item.getString(BluetoothConst.BT_CONNECTION_SMART_NAME);

                JSONArray capabilitiesArray = item.getJSONArray(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES);

                List<Capability> capabilities = new ArrayList<>();
                for (int i = 0; i < capabilitiesArray.length(); i++) {
                    capabilities.add(Capability.getCapability(capabilitiesArray.getInt(i)));
                }

                Object value = item.get(BluetoothConst.BT_CONNECTION_SMART_VALUE);

                return new SmartProperty(name, capabilities);

            } else {
                Log.e(TAG, "Missing field for SmartFunction object");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject toJson() {

        JSONObject result = new JSONObject();

        try {
            result.put(BluetoothConst.BT_CONNECTION_SMART_NAME, name);

            Iterator it = capabilities.iterator();

            JSONArray array = new JSONArray();
            while (it.hasNext()) {
                Capability capability = (Capability) it.next();
                array.put(capability.ordinal());
            }

            result.put(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES, array);

            result.put(BluetoothConst.BT_CONNECTION_SMART_VALUE, value);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
