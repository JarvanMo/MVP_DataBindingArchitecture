package com.jarvanmo.mframework.app.system;

import android.util.Log;

import com.jarvanmo.mframework.R;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mo
 */
public final class SystemSetting {


    private SystemSetting() {
        throw new AssertionError("No instances.");
    }

    public final static class MLogConfig {

        public static String unknownTag = "JLog";
        public static boolean isLoggable = true;
        public static int logLevel = Log.VERBOSE;

        private MLogConfig() {
            throw new AssertionError("No instances.");
        }
    }

    public final static class CrashHandlerConfig {
        public static boolean isDefaultHandle = true;

        private CrashHandlerConfig() {
            throw new AssertionError("No instances.");
        }

    }

    public final static class SystemExitConfig {
        public static Set<String> exitNames = new HashSet<>();
        public static String defaultExitName = "MainActivity";
        public static int exitNotice = R.string.system_exit_notice;
        public static Set<Runnable> doTheseBeforeExit = new HashSet<>();

        private SystemExitConfig() {
            throw new AssertionError("No instances.");
        }

    }

}
