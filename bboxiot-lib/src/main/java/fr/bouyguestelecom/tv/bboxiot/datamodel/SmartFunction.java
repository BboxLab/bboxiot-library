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
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * @author Bertrand Martel
 */
public class SmartFunction {

    private static String TAG = SmartFunction.class.getSimpleName();

    private List<SmartProperty> properties = new ArrayList<>();

    private String name = "";

    public SmartFunction(List<SmartProperty> properties, String name) {
        this.properties = properties;
        this.name = name;
    }

    public List<SmartProperty> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    public static SmartFunction parse(JSONObject item) {

        try {
            if (item.has(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY) &&
                    item.has(BluetoothConst.BT_CONNECTION_SMART_NAME)) {

                List<SmartProperty> smartPropertyList = new ArrayList<>();

                JSONArray properties = item.getJSONArray(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY);

                for (int i = 0; i < properties.length(); i++) {
                    SmartProperty property = SmartProperty.parse(properties.getJSONObject(i));

                    if (property != null)
                        smartPropertyList.add(SmartProperty.parse(properties.getJSONObject(i)));
                    else
                        Log.e(TAG, "Error occured when parsing Smart property object");
                }

                String name = item.getString(BluetoothConst.BT_CONNECTION_SMART_NAME);

                return new SmartFunction(smartPropertyList, name);

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

            JSONArray array = new JSONArray();
            for (int i = 0; i < properties.size(); i++) {
                JSONObject parsedProperty = properties.get(i).toJson();
                if (parsedProperty != null)
                    array.put(parsedProperty);
                else
                    Log.e(TAG, "Error device function item is null");
            }
            result.put(BluetoothConst.BT_CONNECTION_SMART_FUNCTION_ARRAY, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
