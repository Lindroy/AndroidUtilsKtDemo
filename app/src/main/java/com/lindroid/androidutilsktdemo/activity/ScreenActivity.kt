package com.lindroid.androidutilsktdemo.activity

import android.widget.SeekBar
import com.lindroid.androidutilskt.extension.*
import com.lindroid.androidutilsktdemo.R
import com.lindroid.androidutilsktdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_screen.*


/**
 * @author Lin
 * @date 2019/2/27
 * @function 屏幕相关工具类
 * @Description
 */
class ScreenActivity(override val contentViewId: Int = R.layout.activity_screen) : BaseActivity() {


    override fun initView() {
        super.initView()
        initToolBar(R.string.util_screen)
        //分辨率
        tvResolution.text = "${getScreenWidth()}x${getScreenHeight()}"
        //屏幕密度
        tvDensity.text = "屏幕密度:${getScreenDensity()}"
        //Dpi
        tvDpi.text = "屏幕Dpi:${getScreenDPI()}"
        //屏幕方向
        tvOrientation.text = when (isLandscape) {
            true -> "屏幕方向:横屏"
            false -> "屏幕方向:竖屏"
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setScreenBrightness(progress.toFloat() / 100F)
            }


            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }


            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    /*override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        tvOrientation.text = when (isLandscape) {
            true -> "屏幕方向:横屏"
            false -> "屏幕方向:竖屏"
        }
    }*/
}