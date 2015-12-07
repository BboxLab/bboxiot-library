package fr.bouyguestelecom.tv.bboxiot.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.config.GenericDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.ConnectionMode;

/**
 * @author Bertrand Martel
 */
public class BluetoothSmartDeviceTest {

    @Test
    public void BluetoothSmartDeviceTest() {

        String address = "address";
        String deviceUid = "deviceUid";
        List<String> deviceName = new ArrayList<>();
        deviceName.add("device1");
        deviceName.add("device2");
        byte[] manufacturerData = new byte[]{1, 2, 3, 4, 5};
        long time = 0;
        GenericDevice device = null;
        ConnectionMode deviceMode = ConnectionMode.MODE_ADVERTIZING;

        Assert.assertTrue(new BluetoothSmartDevice(address, deviceUid, deviceName, manufacturerData, time, device, deviceMode) != null);

        BluetoothSmartDevice btSmartDevice = new BluetoothSmartDevice(address, deviceUid, deviceName, manufacturerData, time, device, deviceMode);

        Assert.assertTrue(btSmartDevice.getDeviceAddress().equals(address));
        Assert.assertTrue(btSmartDevice.getDeviceUuid().equals(deviceUid));
        Assert.assertTrue(btSmartDevice.getDeviceMode().equals(deviceMode));
        Assert.assertTrue(btSmartDevice.getDeviceNameList().size() == deviceName.size());
        Assert.assertTrue(btSmartDevice.getManufacturerData().length == manufacturerData.length);
        Assert.assertTrue(btSmartDevice.getLastActivityTime() == time);
        Assert.assertTrue(btSmartDevice.getGenericDevice() == null);
    }

    @Test
    public void toJsonTest() {

    }

}
