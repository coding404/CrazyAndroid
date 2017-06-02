package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.DrawPlantView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070102Activity extends BaseActivity implements DrawPlantView.Callback, Handler.Callback {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.palette)
    DrawPlantView mPalette;
    @Bind(R.id.undo)
    ImageView mUndo;
    @Bind(R.id.redo)
    ImageView mRedo;
    @Bind(R.id.pen)
    ImageView mPen;
    @Bind(R.id.eraser)
    ImageView mEraser;
    @Bind(R.id.clear)
    ImageView mClear;
    @Bind(R.id.iv_save)
    ImageView mIvSave;
    private View mUndoView;
    private View mRedoView;
    private View mPenView;
    private View mEraserView;
    private View mClearView;
    private DrawPlantView mPaletteView;
    private ProgressDialog mSaveProgressDlg;
    private static final int MSG_SAVE_SUCCESS = 1;
    private static final int MSG_SAVE_FAILED = 2;
    private Handler mHandler;
    private ImageView mViewSave;

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_SAVE_FAILED:
                mSaveProgressDlg.dismiss();
                Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
                break;
            case MSG_SAVE_SUCCESS:
                mSaveProgressDlg.dismiss();
                Toast.makeText(this, "画板已保存", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onUndoRedoStatusChanged() {
        mUndoView.setEnabled(mPaletteView.canUndo());
        mRedoView.setEnabled(mPaletteView.canRedo());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070102;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("采用双缓冲实现画图板");
        mPaletteView = (DrawPlantView) findViewById(R.id.palette);
        mPaletteView.setCallback(this);
        mUndoView.setEnabled(false);
        mRedoView.setEnabled(false);

        mHandler = new Handler(this);
    }


    @OnClick({R.id.iv_back, R.id.undo, R.id.redo, R.id.pen, R.id.eraser, R.id.clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.undo:
                mPaletteView.undo();
                break;
            case R.id.redo:
                mPaletteView.redo();
                break;
            case R.id.pen:
                mPen.setSelected(true);
                mEraserView.setSelected(false);
                mPaletteView.setMode(DrawPlantView.Mode.DRAW);
                break;
            case R.id.eraser:
                mEraser.setSelected(true);
                mPenView.setSelected(false);
                mPaletteView.setMode(DrawPlantView.Mode.ERASER);
                break;
            case R.id.clear:
                mPaletteView.clear();
                break;
            case R.id.iv_save:
                if (mSaveProgressDlg == null) {
                    initSaveProgressDlg();
                }
                mSaveProgressDlg.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bm = mPaletteView.buildBitmap();
                        String savedFile = saveImage(bm, 100);
                        if (savedFile != null) {
                            scanFile(Demo070102Activity.this, savedFile);
                            mHandler.obtainMessage(MSG_SAVE_SUCCESS).sendToTarget();
                        } else {
                            mHandler.obtainMessage(MSG_SAVE_FAILED).sendToTarget();
                        }
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    private static String saveImage(Bitmap bmp, int quality) {
        if (bmp == null) {
            return null;
        }
        File appDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (appDir == null) {
            return null;
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, quality, fos);
            fos.flush();
            return file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeMessages(MSG_SAVE_FAILED);
        mHandler.removeMessages(MSG_SAVE_SUCCESS);
    }

    private static void scanFile(Context context, String filePath) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(Uri.fromFile(new File(filePath)));
        context.sendBroadcast(scanIntent);
    }

    private void initSaveProgressDlg() {
        mSaveProgressDlg = new ProgressDialog(this);
        mSaveProgressDlg.setMessage("正在保存,请稍候...");
        mSaveProgressDlg.setCancelable(false);
    }
}
