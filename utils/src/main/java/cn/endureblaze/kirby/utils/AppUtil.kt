package cn.endureblaze.kirby.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle

val context: Context = ActManager.currentActivity as Context
val packageManager: PackageManager = context.packageManager
val packageInfo: PackageInfo = packageManager.getPackageInfo(context.packageName, 0)
val labelRes: Int = packageInfo.applicationInfo.labelRes
val applicationInfo: ApplicationInfo = packageManager.getApplicationInfo(context.packageName, 0)
val metaData: Bundle = packageInfo.applicationInfo.metaData

object AppUtil {
    /**
     * 获取应用程序名称
     */
    val appName: String get() = context.resources.getString(labelRes)

    /**
     * 获取程序版本信息
     */
    val versionCode: Int get() = packageInfo.versionCode

    /**
     * 获取图标
     */
    val iconBitmap: Bitmap get() = (packageManager.getApplicationIcon(applicationInfo) as BitmapDrawable).bitmap

    /**
     * 获取渠道名称
     */
    val channel: String? get() = metaData.getString("CHANNEL")
}