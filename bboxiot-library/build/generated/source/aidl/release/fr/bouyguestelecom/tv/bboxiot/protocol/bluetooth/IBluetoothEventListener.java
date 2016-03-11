/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/akinaru/bboxiot/bboxiot-library/bboxiot-library/src/main/aidl/fr/bouyguestelecom/tv/bboxiot/protocol/bluetooth/IBluetoothEventListener.aidl
 */
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth;
/**
 * Bluetooth event listener used to receive incoming event from bluetooth IOT service
 *
 * @author Bertrand Martel
 */
public interface IBluetoothEventListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener
{
private static final java.lang.String DESCRIPTOR = "fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener interface,
 * generating a proxy if needed.
 */
public static fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener))) {
return ((fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener)iin);
}
return new fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener.Stub.Proxy(obj);
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
case TRANSACTION_onEventReceived:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.onEventReceived(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothEventListener
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
     * called when an event has been received
     *
     * @type
     *      event type
     * @topic
     *      event topic
     * @event
     *      json string event data
     */
@Override public void onEventReceived(java.lang.String type, java.lang.String topic, java.lang.String event) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(type);
_data.writeString(topic);
_data.writeString(event);
mRemote.transact(Stub.TRANSACTION_onEventReceived, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onEventReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * called when an event has been received
     *
     * @type
     *      event type
     * @topic
     *      event topic
     * @event
     *      json string event data
     */
public void onEventReceived(java.lang.String type, java.lang.String topic, java.lang.String event) throws android.os.RemoteException;
}
