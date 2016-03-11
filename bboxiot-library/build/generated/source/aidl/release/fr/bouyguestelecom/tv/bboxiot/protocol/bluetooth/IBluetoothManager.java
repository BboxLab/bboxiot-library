/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/akinaru/bboxiot/bboxiot-library/bboxiot-library/src/main/aidl/fr/bouyguestelecom/tv/bboxiot/protocol/bluetooth/IBluetoothManager.aidl
 */
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth;
/**
 * Features all api exposed by bluetooth device manager
 *
 * @author Bertrand Martel
 */
public interface IBluetoothManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager
{
private static final java.lang.String DESCRIPTOR = "fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager interface,
 * generating a proxy if needed.
 */
public static fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager))) {
return ((fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager)iin);
}
return new fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setBluetoothState:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setBluetoothState(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBluetoothState:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getBluetoothState();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setScanStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setScanStatus(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isScanning:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isScanning();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getScanningList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getScanningList();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_clearScanningList:
{
data.enforceInterface(DESCRIPTOR);
this.clearScanningList();
reply.writeNoException();
return true;
}
case TRANSACTION_associateDevice:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.associateDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disassociateDevice:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.disassociateDevice(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disassociateAll:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.disassociateAll();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAssociationList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getAssociationList();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.connect(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.disconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getConnection:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getConnection(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_hasConnection:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.hasConnection(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_deleteWaitingConnections:
{
data.enforceInterface(DESCRIPTOR);
this.deleteWaitingConnections();
reply.writeNoException();
return true;
}
case TRANSACTION_keepConnected:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.keepConnected(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_subscribe:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener _arg1;
_arg1 = fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener.Stub.asInterface(data.readStrongBinder());
java.lang.String _result = this.subscribe(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_unsubscribe:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.unsubscribe(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addDeviceToAssociationList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.addDeviceToAssociationList(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_hasDeviceFunction:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.hasDeviceFunction(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_hasDeviceProperty:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.hasDeviceProperty(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getDeviceProperty:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _result = this.getDeviceProperty(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_pushValue:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.pushValue(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pullValue:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.pullValue(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
    * set Bluetooth state (ON/OFF)
    */
@Override public boolean setBluetoothState(boolean state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((state)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBluetoothState, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * get Bluetooth state (ON/OFF)
     */
@Override public boolean getBluetoothState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBluetoothState, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * start/stop scan with specified parameters in JSON format
     */
@Override public boolean setScanStatus(java.lang.String request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
mRemote.transact(Stub.TRANSACTION_setScanStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * retrieve scanning status
     */
@Override public boolean isScanning() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isScanning, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieve bluetooth scanning list in JSON format
     *
     * @return
     */
@Override public java.lang.String getScanningList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getScanningList, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Clear bluetooth scanning list
     */
@Override public void clearScanningList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearScanningList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Associate a device with specified uid
     *
     * @param deviceUid device unique identifier
     */
@Override public boolean associateDevice(java.lang.String deviceUid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
mRemote.transact(Stub.TRANSACTION_associateDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Disassociate device with specified uid
     *
     * @param deviceUid device unique identifier
     */
@Override public boolean disassociateDevice(java.lang.String deviceUid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
mRemote.transact(Stub.TRANSACTION_disassociateDevice, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
    * disassociate all device in connection list / in waiting list
    */
@Override public boolean disassociateAll() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disassociateAll, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
    * Retrieve association list in JSON format
    */
@Override public java.lang.String getAssociationList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAssociationList, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * connect to device with given uid
     */
@Override public java.lang.String connect(java.lang.String deviceUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUuid);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * disconnect from device with given uid
     */
@Override public boolean disconnect(java.lang.String deviceUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUuid);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieve a connection for a given device Uid (JSON format)
     */
@Override public java.lang.String getConnection(java.lang.String deviceUid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
mRemote.transact(Stub.TRANSACTION_getConnection, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * check if connection with given device uid exists or not
     */
@Override public boolean hasConnection(java.lang.String deviceUid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
mRemote.transact(Stub.TRANSACTION_hasConnection, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * delete connection waiting to connect from the waiting list
     */
@Override public void deleteWaitingConnections() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_deleteWaitingConnections, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * keep a device connected (so device cant be disconnected due to maximum device number reached)
     */
@Override public void keepConnected(java.lang.String deviceUid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
mRemote.transact(Stub.TRANSACTION_keepConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * subscribe to events featured in input request in JSON format
     */
@Override public java.lang.String subscribe(java.lang.String request, fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_subscribe, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * unsubscribe event listener
     */
@Override public void unsubscribe(java.lang.String listenerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(listenerId);
mRemote.transact(Stub.TRANSACTION_unsubscribe, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * force a device with given uid to be added to association list
     */
@Override public boolean addDeviceToAssociationList(java.lang.String request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
mRemote.transact(Stub.TRANSACTION_addDeviceToAssociationList, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * check if device with given device uid features function name
     */
@Override public boolean hasDeviceFunction(java.lang.String deviceUid, java.lang.String function) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
_data.writeString(function);
mRemote.transact(Stub.TRANSACTION_hasDeviceFunction, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * check if device with given device uid features property name for given function name
     */
@Override public boolean hasDeviceProperty(java.lang.String deviceUid, java.lang.String function, java.lang.String property) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
_data.writeString(function);
_data.writeString(property);
mRemote.transact(Stub.TRANSACTION_hasDeviceProperty, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * get device property object in json format
     */
@Override public java.lang.String getDeviceProperty(java.lang.String deviceUid, java.lang.String function, java.lang.String property) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceUid);
_data.writeString(function);
_data.writeString(property);
mRemote.transact(Stub.TRANSACTION_getDeviceProperty, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * push a value to a property according to JSON input request
     */
@Override public boolean pushValue(java.lang.String request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
mRemote.transact(Stub.TRANSACTION_pushValue, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * pull a value from a proeprty according to JSON input request
     */
@Override public boolean pullValue(java.lang.String request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
mRemote.transact(Stub.TRANSACTION_pullValue, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_setBluetoothState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getBluetoothState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setScanStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_isScanning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getScanningList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_clearScanningList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_associateDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_disassociateDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_disassociateAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getAssociationList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_hasConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_deleteWaitingConnections = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_keepConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_subscribe = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_unsubscribe = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_addDeviceToAssociationList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_hasDeviceFunction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_hasDeviceProperty = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getDeviceProperty = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_pushValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_pullValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
}
/**
    * set Bluetooth state (ON/OFF)
    */
public boolean setBluetoothState(boolean state) throws android.os.RemoteException;
/**
     * get Bluetooth state (ON/OFF)
     */
public boolean getBluetoothState() throws android.os.RemoteException;
/**
     * start/stop scan with specified parameters in JSON format
     */
public boolean setScanStatus(java.lang.String request) throws android.os.RemoteException;
/**
     * retrieve scanning status
     */
public boolean isScanning() throws android.os.RemoteException;
/**
     * Retrieve bluetooth scanning list in JSON format
     *
     * @return
     */
public java.lang.String getScanningList() throws android.os.RemoteException;
/**
     * Clear bluetooth scanning list
     */
public void clearScanningList() throws android.os.RemoteException;
/**
     * Associate a device with specified uid
     *
     * @param deviceUid device unique identifier
     */
public boolean associateDevice(java.lang.String deviceUid) throws android.os.RemoteException;
/**
     * Disassociate device with specified uid
     *
     * @param deviceUid device unique identifier
     */
public boolean disassociateDevice(java.lang.String deviceUid) throws android.os.RemoteException;
/**
    * disassociate all device in connection list / in waiting list
    */
public boolean disassociateAll() throws android.os.RemoteException;
/**
    * Retrieve association list in JSON format
    */
public java.lang.String getAssociationList() throws android.os.RemoteException;
/**
     * connect to device with given uid
     */
public java.lang.String connect(java.lang.String deviceUuid) throws android.os.RemoteException;
/**
     * disconnect from device with given uid
     */
public boolean disconnect(java.lang.String deviceUuid) throws android.os.RemoteException;
/**
     * Retrieve a connection for a given device Uid (JSON format)
     */
public java.lang.String getConnection(java.lang.String deviceUid) throws android.os.RemoteException;
/**
     * check if connection with given device uid exists or not
     */
public boolean hasConnection(java.lang.String deviceUid) throws android.os.RemoteException;
/**
     * delete connection waiting to connect from the waiting list
     */
public void deleteWaitingConnections() throws android.os.RemoteException;
/**
     * keep a device connected (so device cant be disconnected due to maximum device number reached)
     */
public void keepConnected(java.lang.String deviceUid) throws android.os.RemoteException;
/**
     * subscribe to events featured in input request in JSON format
     */
public java.lang.String subscribe(java.lang.String request, fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener listener) throws android.os.RemoteException;
/**
     * unsubscribe event listener
     */
public void unsubscribe(java.lang.String listenerId) throws android.os.RemoteException;
/**
     * force a device with given uid to be added to association list
     */
public boolean addDeviceToAssociationList(java.lang.String request) throws android.os.RemoteException;
/**
     * check if device with given device uid features function name
     */
public boolean hasDeviceFunction(java.lang.String deviceUid, java.lang.String function) throws android.os.RemoteException;
/**
     * check if device with given device uid features property name for given function name
     */
public boolean hasDeviceProperty(java.lang.String deviceUid, java.lang.String function, java.lang.String property) throws android.os.RemoteException;
/**
     * get device property object in json format
     */
public java.lang.String getDeviceProperty(java.lang.String deviceUid, java.lang.String function, java.lang.String property) throws android.os.RemoteException;
/**
     * push a value to a property according to JSON input request
     */
public boolean pushValue(java.lang.String request) throws android.os.RemoteException;
/**
     * pull a value from a proeprty according to JSON input request
     */
public boolean pullValue(java.lang.String request) throws android.os.RemoteException;
}
