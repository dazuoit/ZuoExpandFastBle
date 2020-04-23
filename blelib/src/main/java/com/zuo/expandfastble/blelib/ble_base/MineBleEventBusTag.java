package com.zuo.expandfastble.blelib.ble_base;

/**
 * @author zuo
 * @filename: MineBleEventBusTag
 * @date: 2020/3/23
 * @description: eventbusTag
 * @version: 5.0.7
 */
public class MineBleEventBusTag {
    /**
     * scan
     */
    public static final String onScanStarted = "onScanStarted";// boolean success ***非继承 BleDeviceBean!!!

    public static final String onLeScan = "onLeScan";// new BleDeviceBean(bleDevice)

    public static final String onScanning = "onScanning";// new BleDeviceBean(bleDevice)

    public static final String onScanFinished = "onScanFinished";// List<BleDevice> scanResultList ***非继承
                                                                 // BleDeviceBean!!!

    /**
     * connect
     */
    public static final String onStartConnect = "onStartConnect";// new BleDeviceBean(bleDevice)

    public static final String onConnectFail = "onConnectFail";// new BleExceptionBean(exception,bleDevice)

    public static final String onConnectSuccess = "onConnectSuccess";// new OnConnectSuccessBean(bleDevice, gatt,
                                                                     // status)

    public static final String onDisConnected = "onDisConnected";// new OnDisConnectedBean(isActiveDisConnected, device,
                                                                 // gatt, status)

    /**
     * read
     */
    public static final String onReadSuccess = "onReadSuccess";// new BleReturnData(data, bleDevice)

    public static final String onReadFailure = "onReadFailure";// new BleExceptionBean(exception, bleDevice)

    /**
     * write
     */
    public static final String onWriteSuccess = "onWriteSuccess";// new OnWriteSuccessBean(current, total, justWrite,
                                                                 // bleDevice)

    public static final String onWriteFailure = "onWriteFailure";// new BleExceptionBean(exception, bleDevice)


    /**
     * notifyOpen
     */
    public static final String onNotifySuccess = "onNotifySuccess";// new BleDeviceBean(bleDevice)

    public static final String onNotifyFailure = "onNotifyFailure";// new BleExceptionBean(exception, bleDevice)

    public static final String onCharacteristicChanged = "onCharacteristicChanged";// new BleReturnData(data, bleDevice)

    /**
     * indicate
     */
    public static final String onIndicateSuccess = "onIndicateSuccess";// new BleDeviceBean(bleDevice)

    public static final String onIndicateFailure = "onIndicateFailure";// new BleExceptionBean(exception,bleDevice)

    public static final String indicate_onCharacteristicChanged = "indicate_onCharacteristicChanged";// new
                                                                                                     // BleReturnData(data,
                                                                                                     // bleDevice)

    /**
     * readRssi
     */
    public static final String onRssiFailure = "onRssiFailure";// new BleExceptionBean(exception,bleDevice)

    public static final String onRssiSuccess = "onRssiSuccess";// new OnRssiSuccessBean(rssi,bleDevice)

    // 释放
    public static final String release = "release";

}
