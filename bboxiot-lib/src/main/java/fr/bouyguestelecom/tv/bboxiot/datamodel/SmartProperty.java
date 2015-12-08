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
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Capability;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.PropertyTypes;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.EventBuilder;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.PropertiesEventConstant;

/**
 * @author Bertrand Martel
 */
public class SmartProperty<T> implements IProperty {

    private static String TAG = SmartProperty.class.getSimpleName();

    private Properties property = Properties.NONE;

    private Functions function = Functions.NONE;

    private T value = null;

    private PropertyTypes type = PropertyTypes.NONE;

    private EnumSet<Capability> capabilities = EnumSet.noneOf(Capability.class);

    public SmartProperty(Functions function, Properties property, PropertyTypes type, T initValue) {
        this.property = property;
        this.function = function;
        this.capabilities.addAll(capabilities);
        this.type = type;
        this.value = initValue;
    }

    public SmartProperty(Functions function, Properties property, List<Capability> capabilities, PropertyTypes type, T value) {
        this.property = property;
        this.function = function;
        this.capabilities.addAll(capabilities);
        this.type = type;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return -1;
    }

    @Override
    public boolean getBoolValue() {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }

    @Override
    public float getFloatValue() {
        if (value instanceof Float) {
            return (Float) value;
        }
        return -1;
    }

    public PropertyTypes getType() {
        return this.type;
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
    public boolean isGetAble() {
        return capabilities.contains(Capability.GET);
    }

    public Properties getProperty() {
        return property;
    }

    public Functions getFunction() {
        return function;
    }

    public void set(T value) {
        this.value = value;
    }

    public String push(T value) {
        return EventBuilder.buildPushRequest(property, function, value);
    }

    public String pull() {
        return EventBuilder.buildPullRequest(property, function);
    }

    public EnumSet<Capability> getCapabilities() {
        return capabilities;
    }
}
