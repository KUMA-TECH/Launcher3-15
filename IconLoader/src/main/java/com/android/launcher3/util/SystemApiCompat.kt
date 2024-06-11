package com.android.launcher3.util

import android.content.pm.ApplicationInfo
import android.os.UserHandle

/**
 * todo: retrieve the exactly user
 */
fun getUserIdentifier(user: UserHandle): Int {
    return 0
}

/**
 * todo: compat instant app from application store
 */
fun isInstantApp(info: ApplicationInfo): Boolean {
    return false
}

object ShellFlags {
    @JvmStatic
    fun enableLeftRightSplitInPortrait(): Boolean {
        return false
    }

    @JvmStatic
    fun enableTaskbarNavbarUnification(): Boolean {
        return false
    }

    @JvmStatic
    fun enableAppPairs(): Boolean {
        return false
    }

    @JvmStatic
    fun enableSplitContextual(): Boolean {
        return false
    }

    @JvmStatic
    fun enableDesktopWindowing(): Boolean {
        return false
    }
}


object SysUiStatsLog {
    // Values for LauncherUIChanged.user_type
    const val LAUNCHER_UICHANGED__USER_TYPE__TYPE_UNKNOWN: Int = 0
    const val LAUNCHER_UICHANGED__USER_TYPE__TYPE_MAIN: Int = 1
    const val LAUNCHER_UICHANGED__USER_TYPE__TYPE_WORK: Int = 2
    const val LAUNCHER_UICHANGED__USER_TYPE__TYPE_CLONED: Int = 3
    const val LAUNCHER_UICHANGED__USER_TYPE__TYPE_PRIVATE: Int = 4
}