package com.liushu.crazyandroid.ui.main.activity

import android.content.Intent
import android.view.View
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.adapter.TextTagsAdapter
import com.liushu.crazyandroid.adapter.VectorTagsAdapter
import com.liushu.crazyandroid.adapter.ViewTagsAdapter
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : BaseActivity() {

    private var textTagsAdapter: TextTagsAdapter? = null
    private var viewTagsAdapter: ViewTagsAdapter? = null
    private var vectorTagsAdapter: VectorTagsAdapter? = null

    private var mStrings: MutableList<String>? = null

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun initView() {
        mStrings = ArrayList()
        for (i in 1..16) {
            mStrings!!.add("第" + i + "章")
        }
        textTagsAdapter = TextTagsAdapter(mStrings)
        textTagsAdapter!!.setListener { v ->
            if (v.tag is Int) {
                val position = v.tag as Int
                val intent = Intent(mContext, MainActivity::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
                finish()
            }
        }
        viewTagsAdapter = ViewTagsAdapter()
        vectorTagsAdapter = VectorTagsAdapter()

        tag_cloud!!.setAdapter(textTagsAdapter)
    }

    @OnClick(R.id.tag_text, R.id.tag_view, R.id.tag_vector)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.tag_text -> tag_cloud!!.setAdapter(textTagsAdapter)
            R.id.tag_view -> tag_cloud!!.setAdapter(viewTagsAdapter)
            R.id.tag_vector -> tag_cloud!!.setAdapter(vectorTagsAdapter)
        }
    }
}
