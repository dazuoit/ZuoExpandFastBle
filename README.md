# ZuoExpandFastBle
## 可多种ble设备多连接,同时处理分发,在子类控制器只需处理特定分发数据

场景:当需求有多种ble设备可以同时连接并且操作,且数据的收发不一样时,页面展示又不在一起,这样一般的处理只能是一个蓝牙控制器里面做大量的逻辑判断,把数据一层层
分发下去

## 此库的核心用运用eventbus 对Jasonchenlijian/FastBle 进行拓展  

## 使用 : implementation 'com.github.dazuoit:ZuoExpandFastBle:v1.1'

## 步骤
1,每种设备都有一个控制器(读写数据不同),一个控制器可以多连接 (比如 有A,B两种ble, 都要求可多连接 ,可以同时连接多个A,并且同时连接多个B,此时建议用a,b个控制器)
  每种设备 base包下BaseBleDevice,BaseControllerTools类进行继承:入回调也不同 需实现BaseBleCallBack,因为界都都是default,所以需要  
  compileOptions {  
        targetCompatibility 1.8  
        sourceCompatibility 1.8  
    }  
 2, 子类 BaseControllerTools 需要重写checkEventTag(),此方法决定消息能不能分发特定的控制器,方法有详细描述  
 3,释放: MineBleManager.getInstance().release(); BleManager.getInstance().destroy();  
 
 ##此项目demo示例部分的代码,写的不是很规范,仅仅示例怎么用,如有代码洁癖的,请一步本人另一个项目懒人mvp




	
