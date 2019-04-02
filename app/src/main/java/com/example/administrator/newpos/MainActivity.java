package com.example.administrator.newpos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kongqw.serialportlibrary.listener.OnSerialPortDataListener;

public class MainActivity extends AppCompatActivity {
    private Button btn_yushouquan,btn_send,btn_revert,ben_yushouquan_complete,btn_complete_revert,btn_all_money,btn_sign;

    private Utils mUtils = new Utils();
    private StringBuilder mSb;
    private StringBuilder mByteSb = new StringBuilder();

    private boolean isFirst;
    private int mResultLength;

    private String topData;
    private String JsonData;



    private boolean isFUSHOUQUAN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_yushouquan = findViewById(R.id.btn_yushouquan);
        btn_send = findViewById(R.id.btn_send);
        btn_revert = findViewById(R.id.btn_revert);
        ben_yushouquan_complete = findViewById(R.id.ben_yushouquan_complete);
        btn_complete_revert = findViewById(R.id.btn_complete_revert);
        btn_all_money = findViewById(R.id.btn_all_money);
        btn_sign = findViewById(R.id.btn_sign);

        String hex = "0000000313130";
        String change_hex = Integer.valueOf(hex)+"";
        String result =  HexUtils.convertHexToString(change_hex);
        Log.e("CTASPPPPP","当前的结果 = " + result);



        btn_yushouquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mByteSb = new StringBuilder();
                    isFUSHOUQUAN = true;

                    String hh = "81002706000000000001";
//        String hh = "800000";
                    mSb = new StringBuilder();
//        String hh = "81000B0001000000000001000048";
                    mSb.append(hh);
                    String netOrder ="110";
                    String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
                    Log.e("111CTAS111", "当前的订单 =" + order);
                    mSb.append(order);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                    Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                    byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                    mSb.append(HexUtils.bytesToHexString(data));
                    Log.e("111CTAS111", "当前的数据 =" + HexUtils.bytesToHexString(data));


                    mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                String hh = "800000";
                sb.append(hh);
                byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(hh));
                sb.append(HexUtils.bytesToHexString(data));
                Log.e("QWQWQWQW","当前签到发送的数据 = " +sb.toString());
                mUtils.sendData(HexUtils.hexStringToByte(sb.toString()));
            }
        });




        btn_all_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mByteSb = new StringBuilder();
                String top = "81";
                String after = "000711000000000000";
//                String hh = "81002708000000000001";
//        String hh = "800000";
                mSb = new StringBuilder();
//                String tt = HexUtils.addHeadZero(Integer.toHexString((JsonData.toCharArray().length+64+12+2)/2),4);
//                Log.e("111CTAS111", "当前的长度 =" + tt);
                mSb.append(top);
//                mSb.append(tt);
                mSb.append(after);
//        String hh = "81000B0001000000000001000048";
//                mSb.append(hh);
//                String netOrder ="110";
//                String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
//                Log.e("111CTAS111", "当前的订单 =" + order);
//                mSb.append(order);
//                mSb.append(JsonData);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                mSb.append(HexUtils.bytesToHexString(data));
                Log.e("111CTAS111", "当前所有数据 =" +mSb.toString());

                mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));

            }
        });


        btn_complete_revert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mByteSb = new StringBuilder();
                String top = "81";
                String after = "09000000000002";
//                String hh = "81002708000000000001";
//        String hh = "800000";
                mSb = new StringBuilder();
                String tt = HexUtils.addHeadZero(Integer.toHexString((JsonData.toCharArray().length+64+12+2)/2),4);
                Log.e("111CTAS111", "当前的长度 =" + tt);
                mSb.append(top);
                mSb.append(tt);
                mSb.append(after);
//        String hh = "81000B0001000000000001000048";
//                mSb.append(hh);
                String netOrder ="110";
                String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
                Log.e("111CTAS111", "当前的订单 =" + order);
                mSb.append(order);
                mSb.append(JsonData);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                mSb.append(HexUtils.bytesToHexString(data));
                Log.e("111CTAS111", "当前所有数据 =" +mSb.toString());

                mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));
            }
        });


        ben_yushouquan_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mByteSb = new StringBuilder();
                String top = "81";
                String after = "07000000000002";
//                String hh = "81002708000000000001";
//        String hh = "800000";
                mSb = new StringBuilder();
                String tt = HexUtils.addHeadZero(Integer.toHexString((JsonData.toCharArray().length+64+12+2)/2),4);
                Log.e("111CTAS111", "当前的长度 =" + tt);
                mSb.append(top);
                mSb.append(tt);
                mSb.append(after);
//        String hh = "81000B0001000000000001000048";
//                mSb.append(hh);
                String netOrder ="110";
                String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
                Log.e("111CTAS111", "当前的订单 =" + order);
                mSb.append(order);
                mSb.append(JsonData);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                mSb.append(HexUtils.bytesToHexString(data));
                Log.e("111CTAS111", "当前所有数据 =" +mSb.toString());

                mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));
            }
        });


        btn_revert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mByteSb = new StringBuilder();
                int length;
                String top = "81";
                String after = "08000000000001";
//                String hh = "81002708000000000001";
//        String hh = "800000";
                mSb = new StringBuilder();
                String tt = HexUtils.addHeadZero(Integer.toHexString((JsonData.toCharArray().length+64+12+2)/2),4);
                Log.e("111CTAS111", "当前的长度 =" + tt);
                mSb.append(top);
                mSb.append(tt);
                mSb.append(after);
//        String hh = "81000B0001000000000001000048";
//                mSb.append(hh);
                String netOrder ="110";
                String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
                Log.e("111CTAS111", "当前的订单 =" + order);
                mSb.append(order);
                mSb.append(JsonData);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                mSb.append(HexUtils.bytesToHexString(data));
                Log.e("111CTAS111", "当前所有数据 =" +mSb.toString());

                mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mByteSb = new StringBuilder();
                    isFUSHOUQUAN = true;

                    String hh = "81002701000000000001";
//        String hh = "800000";
                    mSb = new StringBuilder();
//        String hh = "81000B0001000000000001000048";
                    mSb.append(hh);
                    String netOrder ="110";
                    String order = HexUtils.patchHexString(HexUtils.convertStringToHex(netOrder), 64);
                    Log.e("111CTAS111", "当前的订单 =" + order);
                    mSb.append(order);

//        String order = "20190327171649158";
//        String changeOrder = HexUtils.patchHexString(HexUtils.convertStringToHex(order), 64);
//        Log.e("111CTAS111", "当前的订单号 = " + changeOrder);
//        Log.e("111CTAS111", "当前的byte = " + new String(HexUtils.hexStringToByte(hh)).length());
//        mSb.append(changeOrder);
                    Log.e("111CTAS111", "当前的订单总数据 =" + mSb.toString());
                    byte[] data = DataUtils.getCrc32(HexUtils.hexStringToByte(mSb.toString()));
                    mSb.append(HexUtils.bytesToHexString(data));
                    Log.e("111CTAS111", "当前的数据 =" + HexUtils.bytesToHexString(data));


                    mUtils.sendData(HexUtils.hexStringToByte(mSb.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        boolean isopen = mUtils.openSerialPort();
        Log.e("CTAS", "是否打开了android串口 =" + isopen);
        if (isopen) {
            Toast.makeText(MainActivity.this, "串口打开", Toast.LENGTH_LONG).show();
            mUtils.setListener(new OnSerialPortDataListener() {
                @Override
                public void onDataReceived(byte[] bytes) {
                    Log.e("QWERCTAS", "当前有数据反悔");
                    String finalResult = "015581009400010000000000010001357B22636172644E6F223A2236323137393933303030313739393535323335222C2264617465223A2230333239222C2265787044617465223A2232353035222C227265664E6F223A22313130313532343234383338222C2272657370436F6465223A223030222C2274696D65223A22313130313532222C2274726163654E6F223A22303030313335227D8C8C1643";

                    try {
                        String result = HexUtils.toHex(bytes);
                        mByteSb.append(result);
                        topData = mByteSb.toString().substring(0,4);
                        Log.e("QWERCTAS","当前截取的头部字节 = " +topData);
                        Log.e("QWERCTAS","当前所有的总长度 = " +Integer.parseInt(topData)*2);



                        Log.e("QWERCTAS", "当前拿到的数据 = " + result);
                        Log.e("QWERCTAS", "当前拿到的总数据 = " + mByteSb.toString());

                        if(mByteSb.toString().substring(4).toCharArray().length==Integer.parseInt(topData)*2){

                            Log.e("QWERCTAS", "数据分发已经完成");
                            Log.e("QWERCTAS", "当前的数据 = "+mByteSb.toString().substring(4));
                            String receiveData = mByteSb.toString().substring(4);
                            int beginJson = 2+4+2+2+12+6+64;
                            String jsonData = receiveData.substring(beginJson,receiveData.toCharArray().length-8);

                            JsonData = jsonData;
                            Log.e("QWERCTAS", "当前的json部分 = "+jsonData);
                            String finalJsonData = new String(HexUtils.hexStringToByte(jsonData));
                            Log.e("QWERCTAS", "解析出来的json = "+finalJsonData);
                            mByteSb = new StringBuilder();
                        }

                    } catch (Exception e) {

                    }


                    // 交易撤销


                }

                @Override
                public void onDataSent(byte[] bytes) {

                }
            });
        }

    }


    private void initManager() {
//        manager = DLCSerialPortUtil.getInstance().open(serialpot, serialData);
//        if (manager != null && manager.isOpenSuccess()) {
//            Toast.makeText(MainActivity.this, "串口打开成功", Toast.LENGTH_LONG).show();
//            Log.e("CTAS", "串口打开成功");
//            manager.setReceiveCallback(this);
//        } else {
//            Toast.makeText(MainActivity.this, "串口打开失败", Toast.LENGTH_LONG).show();
//            Log.e("CTAS", "串口打开成功");
//        }
    }
}
