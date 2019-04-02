package com.example.administrator.newpos;


import com.kongqw.serialportlibrary.SerialPortManager;
import com.kongqw.serialportlibrary.listener.OnSerialPortDataListener;

import java.io.File;

public class Utils {
    String serialpot = "/dev/ttyS8";
    String serialData = "115200";
    private SerialPortManager mSerialPortManager = new SerialPortManager();

    public boolean openSerialPort() {
        return mSerialPortManager.openSerialPort(new File(serialpot), 115200);
    }

    public boolean sendData(byte[] data) {
        return mSerialPortManager.sendBytes(data);
    }

    public void setListener(OnSerialPortDataListener listener){
        mSerialPortManager.setOnSerialPortDataListener(listener);
    }
}
