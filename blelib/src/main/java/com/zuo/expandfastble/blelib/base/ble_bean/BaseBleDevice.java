package com.zuo.expandfastble.blelib.base.ble_bean;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;

import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleDevice;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuo.
 * @date 2019/3/277.
 * @describe .ble 基础bean
 */

public abstract class BaseBleDevice {
	protected BleDevice mBleDevice; // 蓝牙对象

	protected Map<String, BluetoothGattService> mBluetoothGattServiceList = new HashMap<>(); // 所有服务

	protected String wirteServiceUuid;// 写入服务

	protected String wirteGattCharacteristicUuid;// 写入特征

	protected String readServiceUuid; // 读取服务

	protected String readGattCharacteristicUuid; // 读取特征

	protected MyHandler handler = new MyHandler(this); // handler

	protected static class MyHandler extends Handler {
		private final WeakReference<BaseBleDevice> mBean;

		public MyHandler(BaseBleDevice bean) {
			mBean = new WeakReference<BaseBleDevice>(bean);
		}
	}

	protected String mac;// mac
	protected String name;// 设备名
	protected int mRssi;// 信号值


	public BaseBleDevice(BleDevice bleDevice) {
		this.mBleDevice = bleDevice;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		if (mBleDevice == null) {
			return;
		}
		this.mac = mBleDevice.getMac();
		this.name = mBleDevice.getName();
		BleManager.getInstance().clearCharacterCallback(mBleDevice);
		BluetoothGatt gatt = BleManager.getInstance().getBluetoothGatt(mBleDevice);
		if (gatt == null) {
			return;
		}
		List<BluetoothGattService> serviceList = gatt.getServices();
		for (BluetoothGattService service : serviceList) {
			String uuid_service = service.getUuid().toString();
			mBluetoothGattServiceList.put(uuid_service, service);

			List<BluetoothGattCharacteristic> characteristicList = service.getCharacteristics();
			for (BluetoothGattCharacteristic characteristic : characteristicList) {
				int charaProp = characteristic.getProperties();
				if ((charaProp & BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) > 0) {
					wirteServiceUuid = uuid_service;
					wirteGattCharacteristicUuid = characteristic.getUuid().toString();


				} else if ((charaProp & BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
					readServiceUuid = uuid_service;
					readGattCharacteristicUuid = characteristic.getUuid().toString();
					afterOpenNotify();
				}
			}
		}
	}

	protected abstract void afterOpenNotify();


	public String getMac() {
		return mac;
	}

	public String getName() {
		return name;
	}

	// 获取设备
	public BleDevice getBleDevice() {
		return mBleDevice;
	}

	// 获取信号强度
	public int getBleDeviceRssi() {
		return mBleDevice.getRssi();
	}

	public String getWirteServiceUuid() {
		return wirteServiceUuid;
	}

	public void setWirteServiceUuid(String wirteServiceUuid) {
		this.wirteServiceUuid = wirteServiceUuid;
	}

	public String getWirteGattCharacteristicUuid() {
		return wirteGattCharacteristicUuid;
	}

	public void setWirteGattCharacteristicUuid(String wirteGattCharacteristicUuid) {
		this.wirteGattCharacteristicUuid = wirteGattCharacteristicUuid;
	}

	public String getReadServiceUuid() {
		return readServiceUuid;
	}

	public void setReadServiceUuid(String readServiceUuid) {
		this.readServiceUuid = readServiceUuid;
	}

	public String getReadGattCharacteristicUuid() {
		return readGattCharacteristicUuid;
	}

	public void setReadGattCharacteristicUuid(String readGattCharacteristicUuid) {
		this.readGattCharacteristicUuid = readGattCharacteristicUuid;
	}

	public void setmRssi(int mRssi) {
		this.mRssi = mRssi;
	}

    public void release() {
        handler.removeCallbacksAndMessages(null);
        mBluetoothGattServiceList.clear();
    }
}
