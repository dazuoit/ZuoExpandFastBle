package com.zuo.expandfastble.zuoexpandfastble.device;

import com.clj.fastble.data.BleDevice;
import com.zuo.expandfastble.blelib.base.ble_bean.BaseBleDevice;

/**
 * @author zuo
 * @filename: Adevice
 * @date: 2020/4/23
 * @description: 描述
 * @version: 版本号
 */
public class Adevice  extends BaseBleDevice{
	public Adevice(BleDevice bleDevice) {
		super(bleDevice);
	}

	@Override
	protected void afterOpenNotify() {

	}
}
