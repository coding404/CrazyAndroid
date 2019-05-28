package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.liushu.crazyandroid.R
import java.util.*

class Demo020700Activity : AppCompatActivity() {

    @BindView(R.id.vs_test01)
    internal var mVsTest01: ViewSwitcher? = null
    @BindView(R.id.btn_prev)
    internal var mBtnPrev: Button? = null
    @BindView(R.id.btn_next)
    internal var mBtnNext: Button? = null
    @BindView(R.id.rl_test01)
    internal var mRlTest01: RelativeLayout? = null
    @BindView(R.id.is_test)
    internal var mIsTest: ImageSwitcher? = null
    @BindView(R.id.ll_test02)
    internal var mLlTest02: LinearLayout? = null
    @BindView(R.id.gl_test)
    internal var mGlTest: GridView? = null
    @BindView(R.id.vf_test)
    internal var mVfTest: ViewFlipper? = null
    @BindView(R.id.btn_pre02)
    internal var mBtnPre02: Button? = null
    @BindView(R.id.btn_auto02)
    internal var mBtnAuto02: Button? = null
    @BindView(R.id.btn_next02)
    internal var mBtnNext02: Button? = null
    @BindView(R.id.rv_test03)
    internal var mRvTest03: RelativeLayout? = null
    private var mGroupPosition: Int = 0
    private var mChildPosition: Int = 0

    private val mItems = ArrayList<DataItem>()
    private var screenNo = -1
    private var screenCount: Int = 0
    private var mInflater: LayoutInflater? = null
    private val mInts = intArrayOf(R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16)

    private val mAdapter = object : BaseAdapter() {
        override fun getCount(): Int {
            return if (screenNo == screenCount - 1 && mItems.size % NUMBER_PER_SCREEN != 0) {
                mItems.size % NUMBER_PER_SCREEN
            } else NUMBER_PER_SCREEN
        }

        override fun getItem(position: Int): Any {
            return mItems[screenNo * NUMBER_PER_SCREEN + position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            var view = convertView
            if (convertView == null) {
                view = mInflater!!.inflate(R.layout.labelicon, null)
            }
            val imageView = view!!.findViewById<View>(R.id.iv_item) as ImageView
            imageView.setImageDrawable(mItems[position].dataDrawable)
            val textView = view.findViewById<View>(R.id.tv_item) as TextView
            textView.text = mItems[position].dataString
            return view
        }
    }

    @OnClick(R.id.btn_prev, R.id.btn_next, R.id.btn_pre02, R.id.btn_auto02, R.id.btn_next02)
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_prev -> prov()
            R.id.btn_next -> next()
            R.id.btn_pre02 -> {
                mVfTest!!.setInAnimation(this, R.anim.slide_in_right)
                mVfTest!!.setOutAnimation(this, R.anim.slide_out_left)
                mVfTest!!.showPrevious()
                mVfTest!!.stopFlipping()
            }
            R.id.btn_auto02 -> {
                mVfTest!!.setInAnimation(this, R.anim.slide_in_left)
                mVfTest!!.setOutAnimation(this, R.anim.slide_out_right)
                mVfTest!!.startFlipping()
            }
            R.id.btn_next02 -> {
                mVfTest!!.setInAnimation(this, R.anim.slide_in_left)
                mVfTest!!.setOutAnimation(this, R.anim.slide_out_right)
                mVfTest!!.showNext()
                mVfTest!!.stopFlipping()
            }
        }
    }

    class DataItem {
         var dataString: String? = null
         var dataDrawable: Drawable? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo020700)
        ButterKnife.bind(this)
        mGroupPosition = intent.getIntExtra("groupPosition", -1)
        mChildPosition = intent.getIntExtra("childPosition", -1)
        initView(mChildPosition)
    }

    private fun initView(childPosition: Int) {
        when (childPosition) {
            0 -> {
                mRlTest01!!.visibility = View.VISIBLE
                initData0()
            }
            1 -> {
                mLlTest02!!.visibility = View.VISIBLE
                Log.e("111111", "1111")
                initData1()
            }
            2 -> {
                mRvTest03!!.visibility = View.VISIBLE
                initData2()
            }
            else -> {
            }
        }


    }

    private fun initData0() {
        mInflater = LayoutInflater.from(this@Demo020700Activity)
        for (i in 0..39) {
            val label = "" + i
            val drawable = resources.getDrawable(R.mipmap.ic_launcher)
            var dataItem = DataItem()
            dataItem.dataString = label
            dataItem.dataDrawable = drawable
            mItems.add(dataItem)
        }
        screenCount = if (mItems.size % NUMBER_PER_SCREEN == 0) mItems.size / NUMBER_PER_SCREEN else mItems.size / NUMBER_PER_SCREEN + 1
        mVsTest01!!.setFactory { mInflater!!.inflate(R.layout.slidelistview, null) }
        next()
    }

    private fun prov() {
        if (screenNo > 0) {
            screenNo--
            mVsTest01!!.setInAnimation(this, R.anim.slide_in_right)
            mVsTest01!!.setOutAnimation(this, R.anim.slide_out_left)
            (mVsTest01!!.nextView as GridView).adapter = mAdapter
            mVsTest01!!.showPrevious()
        }
    }

    private operator fun next() {
        Log.e("screenCount", screenCount.toString() + "")
        Log.e("screenNo", screenNo.toString() + "")
        if (screenNo < screenCount - 1) {
            screenNo++
            mVsTest01!!.setInAnimation(this, R.anim.slide_in_left)
            mVsTest01!!.setOutAnimation(this, R.anim.slide_out_right)
            (mVsTest01!!.nextView as GridView).adapter = mAdapter
            mVsTest01!!.showNext()
        }
    }

    private fun initData1() {
        val mapList = ArrayList<Map<String, Any>>()

        for (i in mInts.indices) {
            val map = HashMap<String, Any>()
            map["image"] = mInts[i]
            mapList.add(map)
        }
        mIsTest!!.setFactory {
            val imageView = ImageView(this@Demo020700Activity)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER

            //todo
          //  imageView.layoutParams = ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            imageView
        }
        val simpleAdapter = SimpleAdapter(this, mapList, R.layout.cell, arrayOf("image"), intArrayOf(R.id.iv))
        mGlTest!!.adapter = simpleAdapter
        mGlTest!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> mIsTest!!.setImageResource(mInts[position]) }
    }

    private fun initData2() {


    }

    companion object {
        private val NUMBER_PER_SCREEN = 12
    }

}
