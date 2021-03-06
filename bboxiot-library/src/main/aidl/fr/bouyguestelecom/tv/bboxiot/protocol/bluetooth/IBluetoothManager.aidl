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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener;


/**
 * Features all api exposed by bluetooth device manager
 *
 * @author Bertrand Martel
 */
interface IBluetoothManager {

    /**
    * set Bluetooth state (ON/OFF)
    */
    boolean setBluetoothState(boolean state);

    /**
     * get Bluetooth state (ON/OFF)
     */
    boolean getBluetoothState();

    /**
     * start/stop scan with specified parameters in JSON format
     */
    boolean setScanStatus(String request);

    /**
     * retrieve scanning status
     */
    boolean isScanning();

    /**
     * Retrieve bluetooth scanning list in JSON format
     *
     * @return
     */
    String getScanningList();

    /**
     * Clear bluetooth scanning list
     */
    void clearScanningList();

    /**
     * Associate a device with specified uid
     *
     * @param deviceUid device unique identifier
     */
    boolean associateDevice(String deviceUid);

    /**
     * Disassociate device with specified uid
     *
     * @param deviceUid device unique identifier
     */
    boolean disassociateDevice(String deviceUid);

    /**
    * disassociate all device in connection list / in waiting list
    */
    boolean disassociateAll();

    /**
    * Retrieve association list in JSON format
    */
    String getAssociationList();

    /**
     * connect to device with given uid
     */
    String connect(String deviceUuid);

    /**
     * disconnect from device with given uid
     */
    boolean disconnect(String deviceUuid);

    /**
     * Retrieve a connection for a given device Uid (JSON format)
     */
    String getConnection(String deviceUid);

    /**
     * check if connection with given device uid exists or not
     */
    boolean hasConnection(String deviceUid);

    /**
     * delete connection waiting to connect from the waiting list
     */
    void deleteWaitingConnections();

    /**
     * keep a device connected (so device cant be disconnected due to maximum device number reached)
     */
    void keepConnected(String deviceUid);

    /**
     * subscribe to events featured in input request in JSON format
     */
    String subscribe(String request,IBluetoothEventListener listener);

    /**
     * unsubscribe event listener
     */
    void unsubscribe(String listenerId);

    /**
     * force a device with given uid to be added to association list
     */
    boolean addDeviceToAssociationList(String request);

    /**
     * check if device with given device uid features function name
     */
    boolean hasDeviceFunction(String deviceUid,String function);

    /**
     * check if device with given device uid features property name for given function name
     */
    boolean hasDeviceProperty(String deviceUid,String function,String property);

    /**
     * get device property object in json format
     */
    String getDeviceProperty(String deviceUid,String function,String property);

    /**
     * push a value to a property according to JSON input request
     */
    boolean pushValue(String request);

    /**
     * pull a value from a proeprty according to JSON input request
     */
    boolean pullValue(String request);

}
