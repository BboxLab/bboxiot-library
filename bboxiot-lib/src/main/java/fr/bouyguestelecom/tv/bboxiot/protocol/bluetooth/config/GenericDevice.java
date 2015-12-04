/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 BboxLab
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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.config;

import android.os.RemoteException;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Structure for supported device
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public class GenericDevice {

    private final static String TAG = GenericDevice.class.getSimpleName();

    /**
     * device implementation class name
     */
    private String smartBuilderClassName = "";

    /**
     * list of device functions
     */
    private List<String> smartFunctionsList = new ArrayList<>();

    /**
     * manufacturer name
     */
    private String manufacturerName = "";

    /**
     * product name
     */
    private String productName = "";

    /**
     * radio protocol used
     */
    private String protocol = "";

    public GenericDevice() {

    }

    /**
     * Build supported bluetooth device structure
     *
     * @param manufacturerName
     * @param productName
     * @param smartBuilderClassName
     * @param smartFunctionsList
     */
    public GenericDevice(String protocol,
                         String manufacturerName,
                         String productName,
                         String smartBuilderClassName,
                         List<String> smartFunctionsList
    ) {
        this.protocol = protocol;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
        this.smartBuilderClassName = smartBuilderClassName;
        this.smartFunctionsList = smartFunctionsList;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getSmartBuilderClassName() {
        return smartBuilderClassName;
    }

    public List<String> getSmartFunctionsList() {
        return smartFunctionsList;
    }

    public String getProtocol() {
        return protocol;
    }

    public String toJsonString() throws RemoteException {

        JSONObject result = new JSONObject();
        try {
            result.put(GenericDeviceConst.JSON_CONFIG_MANUFACTURER_NAME, manufacturerName);
            result.put(GenericDeviceConst.JSON_CONFIG_PRODUCT_NAME, productName);
            JSONArray smartFunctionsArray = new JSONArray();
            for (int i = 0; i < smartFunctionsList.size(); i++) {
                smartFunctionsArray.put(smartFunctionsList.get(i));
            }
            result.put(GenericDeviceConst.JSON_CONFIG_SMART_FUNCTIONS, smartFunctionsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static GenericDevice parse(JSONObject item) {

        try {
            if (item.has(GenericDeviceConst.JSON_CONFIG_MANUFACTURER_NAME) &&
                    item.has(GenericDeviceConst.JSON_CONFIG_PRODUCT_NAME) &&
                    item.has(GenericDeviceConst.JSON_CONFIG_SMART_FUNCTIONS)) {

                String manufacturerName = item.getString(GenericDeviceConst.JSON_CONFIG_MANUFACTURER_NAME);
                String productName = item.getString(GenericDeviceConst.JSON_CONFIG_PRODUCT_NAME);

                List<String> smartFunctionList = new ArrayList<>();

                JSONArray array = item.getJSONArray(GenericDeviceConst.JSON_CONFIG_SMART_FUNCTIONS);

                for (int i = 0; i < array.length(); i++) {
                    smartFunctionList.add(array.get(i).toString());
                }

                return new GenericDevice("", manufacturerName, productName, "", smartFunctionList);
                
            } else {
                Log.e(TAG, "Error missing filed in Generic Device object");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
