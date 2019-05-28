package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.liushu.crazyandroid.R

class Demo021000Activity : AppCompatActivity() {
    private val mGroupPosition: Int = 0
    private val mChildPosition: Int = 0

    // 定义字体大小菜单项的标识
    internal val FONT_10 = 0x111
    internal val FONT_12 = 0x112
    internal val FONT_14 = 0x113
    internal val FONT_16 = 0x114
    internal val FONT_18 = 0x115
    // 定义普通菜单项的标识
    internal val PLAIN_ITEM = 0x11b
    // 定义字体颜色菜单项的标识
    internal val FONT_RED = 0x116
    internal val FONT_BLUE = 0x117
    internal val FONT_GREEN = 0x118
    private var edit: EditText? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo021000)
        edit = findViewById<View>(R.id.txt) as EditText
    }

    // 当用户单击MENU键时触发该方法
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // -------------向menu中添加字体大小的子菜单-------------
        val fontMenu = menu.addSubMenu("字体大小")
        // 设置菜单的图标
        fontMenu.setIcon(R.drawable.font)
        // 设置菜单头的图标
        fontMenu.setHeaderIcon(R.drawable.font)
        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小")
        fontMenu.add(0, FONT_10, 0, "10号字体")
        fontMenu.add(0, FONT_12, 0, "12号字体")
        fontMenu.add(0, FONT_14, 0, "14号字体")
        fontMenu.add(0, FONT_16, 0, "16号字体")
        fontMenu.add(0, FONT_18, 0, "18号字体")
        // -------------向menu中添加普通菜单项-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项")
        // -------------向menu中添加文字颜色的子菜单-------------
        val colorMenu = menu.addSubMenu("字体颜色")
        colorMenu.setIcon(R.drawable.color)
        // 设置菜单头的图标
        colorMenu.setHeaderIcon(R.drawable.color)
        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色")
        colorMenu.add(0, FONT_RED, 0, "红色")
        colorMenu.add(0, FONT_GREEN, 0, "绿色")
        colorMenu.add(0, FONT_BLUE, 0, "蓝色")
        return super.onCreateOptionsMenu(menu)
    }

    override// 选项菜单的菜单项被单击后的回调方法
    fun onOptionsItemSelected(mi: MenuItem): Boolean {
        //判断单击的是哪个菜单项，并有针对性地作出响应
        when (mi.itemId) {
            FONT_10 -> edit!!.textSize = (10 * 2).toFloat()
            FONT_12 -> edit!!.textSize = (12 * 2).toFloat()
            FONT_14 -> edit!!.textSize = (14 * 2).toFloat()
            FONT_16 -> edit!!.textSize = (16 * 2).toFloat()
            FONT_18 -> edit!!.textSize = (18 * 2).toFloat()
            FONT_RED -> edit!!.setTextColor(Color.RED)
            FONT_GREEN -> edit!!.setTextColor(Color.GREEN)
            FONT_BLUE -> edit!!.setTextColor(Color.BLUE)
            PLAIN_ITEM -> {
                val toast = Toast.makeText(this, "您单击了普通菜单项", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        return true
    }
}
