/*
 * Copyright 2016 czy1121
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ezy.boost.update;


import android.content.Context;
import android.util.SparseArray;

public class UpdateError extends Throwable {
    private int code;
    private static Context context;
    private String message = "";
    public UpdateError(Context context, int code){
        messages.append(UPDATE_IGNORED, context.getString(R.string.update_error_1001));
        messages.append(UPDATE_NO_NEWER, context.getString(R.string.update_error_1002));

        messages.append(CHECK_UNKNOWN, context.getString(R.string.update_error_2001));
        messages.append(CHECK_NO_WIFI, context.getString(R.string.update_error_2002));
        messages.append(CHECK_NO_NETWORK, context.getString(R.string.update_error_2003));
        messages.append(CHECK_NETWORK_IO, context.getString(R.string.update_error_2004));
        messages.append(CHECK_HTTP_STATUS, context.getString(R.string.update_error_2005));
        messages.append(CHECK_PARSE, context.getString(R.string.update_error_2006));

        messages.append(DOWNLOAD_UNKNOWN, context.getString(R.string.update_error_3001));
        messages.append(DOWNLOAD_CANCELLED, context.getString(R.string.update_error_3002));
        messages.append(DOWNLOAD_DISK_NO_SPACE, context.getString(R.string.update_error_3003));
        messages.append(DOWNLOAD_DISK_IO, context.getString(R.string.update_error_3004));
        messages.append(DOWNLOAD_NETWORK_IO, context.getString(R.string.update_error_3005));
        messages.append(DOWNLOAD_NETWORK_BLOCKED, context.getString(R.string.update_error_3006));
        messages.append(DOWNLOAD_NETWORK_TIMEOUT, context.getString(R.string.update_error_3007));
        messages.append(DOWNLOAD_HTTP_STATUS, context.getString(R.string.update_error_3008));
        messages.append(DOWNLOAD_INCOMPLETE, context.getString(R.string.update_error_3009));
        messages.append(DOWNLOAD_VERIFY, context.getString(R.string.update_error_3010));

        message = make(code, "");
        this.code = code;
    }

    public boolean isError() {
        return code >= 2000;
    }

    @Override
    public String toString() {
        if (isError()) {
            return "[" + code + "] " + message;
        }
        return message;
    }

    private static String make(int code, String message) {
        String m = messages.get(code);
        if(m == null)
            m = message;
        return m;
    }

    public static final int UPDATE_IGNORED = 1001;
    public static final int UPDATE_NO_NEWER = 1002;

    public static final int CHECK_UNKNOWN = 2001;
    public static final int CHECK_NO_WIFI = 2002;
    public static final int CHECK_NO_NETWORK = 2003;
    public static final int CHECK_NETWORK_IO = 2004;
    public static final int CHECK_HTTP_STATUS = 2005;
    public static final int CHECK_PARSE = 2006;

    public static final int DOWNLOAD_UNKNOWN = 3001;
    public static final int DOWNLOAD_CANCELLED = 3002;
    public static final int DOWNLOAD_DISK_NO_SPACE = 3003;
    public static final int DOWNLOAD_DISK_IO = 3004;
    public static final int DOWNLOAD_NETWORK_IO = 3005;
    public static final int DOWNLOAD_NETWORK_BLOCKED = 3006;
    public static final int DOWNLOAD_NETWORK_TIMEOUT = 3007;
    public static final int DOWNLOAD_HTTP_STATUS = 3008;
    public static final int DOWNLOAD_INCOMPLETE = 3009;
    public static final int DOWNLOAD_VERIFY = 3010;

    public static final SparseArray<String> messages = new SparseArray<>();
}
