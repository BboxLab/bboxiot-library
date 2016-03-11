/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/akinaru/bboxiot/bboxiot-library/bboxiot-library/src/main/aidl/fr/bouyguestelecom/tv/bboxiot/IBboxIotService.aidl
 */
package fr.bouyguestelecom.tv.bboxiot;
/**
 * Features all apis exposed by bbox iot service
 *
 * @author Bertrand Martel
 */
public interface IBboxIotService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements fr.bouyguestelecom.tv.bboxiot.IBboxIotService
{
private static final java.lang.String DESCRIPTOR = "fr.bouyguestelecom.tv.bboxiot.IBboxIotService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an fr.bouyguestelecom.tv.bboxiot.IBboxIotService interface,
 * generating a proxy if needed.
 */
public static fr.bouyguestelecom.tv.bboxiot.IBboxIotService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof fr.bouyguestelecom.tv.bboxiot.IBboxIotService))) {
return ((fr.bouyguestelecom.tv.bboxiot.IBboxIotService)iin);
}
return new fr.bouyguestelecom.tv.bboxiot.IBboxIotService.Stub.Proxy(obj);
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
case TRANSACTION_getBluetoothManager:
{
data.enforceInterface(DESCRIPTOR);
fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager _result = this.getBluetoothManager();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements fr.bouyguestelecom.tv.bboxiot.IBboxIotService
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
     * Retrieve Bluetooth protocol manager
     *
     * @return
     */
@Override public fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager getBluetoothManager() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBluetoothManager, _data, _reply, 0);
_reply.readException();
_result = fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getBluetoothManager = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Retrieve Bluetooth protocol manager
     *
     * @return
     */
public fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.IBluetoothManager getBluetoothManager() throws android.os.RemoteException;
}
