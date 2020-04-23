package com.zuo.expandfastble.zuoexpandfastble.controller;

import android.bluetooth.BluetoothGatt;

import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;
import com.zuo.expandfastble.blelib.base.controller.BaseControllerTools;
import com.zuo.expandfastble.blelib.evnetbus_bean.BleDeviceBean;
import com.zuo.expandfastble.zuoexpandfastble.device.Adevice;
import com.zuo.expandfastble.zuoexpandfastble.device.Bdevice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zuo
 * @filename: AbleController
 * @date: 2020/4/23
 * @description: 描述
 * @version: 版本号
 */
public class BbleController extends BaseControllerTools {
	private Map<String, Bdevice> mADevicesList = new ConcurrentHashMap<>();

	public boolean isBdevice(BleDevice bleDeviceBean){
		return "B00".equals(bleDeviceBean.getName());
	}
	@Override
	public boolean checkEventTag(BleDeviceBean bleDeviceBean) {
		//例如,每种设备的名称一致, A设备都叫A00,B设备都叫B00,B01  只要定义了这个,所有回调 除onScanStarted ()无需做判断了设备类型了
		return isBdevice(bleDeviceBean.bleDevice);
	}

	@Override
	public void onScanStarted(boolean success) {

	}

	@Override
	public void onScanFinished(List<BleDevice> scanResultList) {

	}

	@Override
	public void onScanning(BleDevice bleDevice) {

	}

	@Override
	public void onLeScan(BleDevice bleDevice) {

	}
	@Override
	public void release() {

	}

	@Override
	public void onRssiSuccess(int rssi, BleDevice bleDevice) {

	}

	@Override
	public void onRssiFailure(BleException exception, BleDevice bleDevice) {

	}

	@Override
	public void onIndicateCharacteristicChanged(byte[] data, BleDevice bleDevice) {

	}

	@Override
	public void onIndicateFailure(BleException exception, BleDevice bleDevice) {

	}

	@Override
	public void onIndicateSuccess(BleDevice bleDevice) {

	}

	@Override
	public void onCharacteristicChanged(byte[] data, BleDevice bleDevice) {

	}

	@Override
	public void onNotifyFailure(BleException exception, BleDevice bleDevice) {

	}

	@Override
	public void onNotifySuccess(BleDevice bleDevice) {

	}

	@Override
	public void onWriteFailure(BleException exception, BleDevice bleDevice) {

	}

	@Override
	public void onWriteSuccess(int current, int total, byte[] justWrite, BleDevice bleDevice) {

	}

	@Override
	public void onReadFailure(BleException exception, BleDevice bleDevice) {

	}

	@Override
	public void onReadSuccess(byte[] data, BleDevice bleDevice) {

	}

	@Override
	public void onDisConnected(boolean isActiveDisConnected, BleDevice device, BluetoothGatt gatt, int status) {
		mADevicesList.remove(device.getMac());
	}

	@Override
	public void onConnectSuccess(BleDevice bleDevice, BluetoothGatt gatt, int status) {
		mADevicesList.put(bleDevice.getMac(),new Bdevice(bleDevice));
	}

	@Override
	public void onConnectFail(BleDevice bleDevice, BleException exception) {

	}

	@Override
	public void onStartConnect(BleDevice bleDevice) {

	}


}
