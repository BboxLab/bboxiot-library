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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Structure for supported device
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public class GenericDevice {

    private final static String TAG = GenericDevice.class.getSimpleName();

    private SupportedDevices supportedDevice = SupportedDevices.UNDEFINED;

    /**
     * radio protocol used
     */
    private Protocols protocol = Protocols.UNDEFINED;

    public GenericDevice() {
    }

    /**
     * Build supported bluetooth device structure
     */
    public GenericDevice(Protocols protocol,
                         SupportedDevices supportedDevice
    ) {
        this.protocol = protocol;
        this.supportedDevice = supportedDevice;
    }

    public Protocols getProtocol() {
        return protocol;
    }

    public SupportedDevices getSupportedDevice() {
        return supportedDevice;
    }

    public String toJsonString() throws RemoteException {

        JSONObject result = new JSONObject();
        try {
            result.put(GenericDeviceConst.JSON_CONFIG_SUPPORTED_DEVICE, supportedDevice.ordinal());
            result.put(GenericDeviceConst.JSON_CONFIG_PROTOCOL, protocol.ordinal());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static GenericDevice parse(JSONObject item) {

        try {
            if (item.has(GenericDeviceConst.JSON_CONFIG_SUPPORTED_DEVICE) &&
                    item.has(GenericDeviceConst.JSON_CONFIG_PROTOCOL)) {

                SupportedDevices supportedDevice = SupportedDevices.getDevice(item.getInt(GenericDeviceConst.JSON_CONFIG_SUPPORTED_DEVICE));
                Protocols btProtocol = Protocols.getProtocol(item.getInt(GenericDeviceConst.JSON_CONFIG_PROTOCOL));

                return new GenericDevice(btProtocol, supportedDevice);

            } else {
                Log.e(TAG, "Error missing filed in Generic Device object");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
