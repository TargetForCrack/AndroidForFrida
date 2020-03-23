package com.my.fridademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView show_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_board = (TextView) findViewById(R.id.show_board_id);
    }

    //util 里的 普通方法
    public void ordinaryFunc(View view) {
        Util util = new Util();
        String result = util.ordinaryFunc("Dio", "wonam", 20);
        show_board.setText(result);
    }

    //util 里的 重载方法
    public void override_function(View view) {
        Util util = new Util();
        String result = util.judgeByAge(14);
        show_board.setText(result);
    }

    //Student 里的 构造方法
    public void construction_func(View view) {
        Student stu = new Student("Leo", "man", 18, 58.5, false);
        show_board.setText(stu.toString());
    }


    //调用函数
    public void load_func(View view) {
//        Util util = new Util();
//        int result = util.func1(10);
        int result = func1(33);
        show_board.setText("hooked : " + result);
    }

    public int func1(int num) {
        return num + 10;
    }

    public int func() {
        return 66;
    }

    //util 里的静态方法
    public void staic_func(View view) {
        String result = Util.myInfo("Lily", 98);
        show_board.setText(result);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    //仅hook外面这个java方法
    public native String getString();

    public void ndk_func(View view) {
        String result = getString();
        show_board.setText(result);
    }

    //hook native里面的so方法
    public native String hookSO(String name, int age, int grade);

    public void ndk_so(View view) {
        String result = hookSO("Tom", 17, 99);
        show_board.setText(result);
    }

    //返回个int
    public native int hookSO2(int num1, int num2);

    public void ndk_so2(View view) {
        int result = hookSO2(4, 5);
        show_board.setText("native 返回值: " + result);
    }

}
