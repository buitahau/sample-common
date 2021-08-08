package com.haubui.sample.common.utils;

import com.haubui.sample.common.utils.string.CharPool;

public class ValidatorUtil {

    public static boolean isNull(Long l) {
        if ((l == null) || (l.longValue() == 0)) {
            return true;
        }

        return false;
    }

    /**
     * Returns <code>true</code> if the object is <code>null</code>, using the
     * rules from {@link #isNull(Long)} or {@link #isNull(String)} if the object
     * is one of these types.
     *
     * @param  object the object to check
     * @return <code>true</code> if the object is <code>null</code>;
     *         <code>false</code> otherwise
     */
    public static boolean isNull(Object object) {
        if (object instanceof Long) {
            return isNull((Long)object);
        }
        else if (object instanceof String) {
            return isNull((String)object);
        }
        else if (object == null) {
            return true;
        }

        return false;
    }

    /**
     * Returns <code>true</code> if the string is <code>null</code>, meaning it
     * is a <code>null</code> reference, an empty string, whitespace, or the
     * string "<code>null</code>", with or without leading or trailing
     * whitespace.
     *
     * @param  s the string to check
     * @return <code>true</code> if the string is <code>null</code>;
     *         <code>false</code> otherwise
     */
    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == CharPool.SPACE) {
                continue;
            }
            else if (counter > 3) {
                return false;
            }

            if (counter == 0) {
                if (c != CharPool.LOWER_CASE_N) {
                    return false;
                }
            }
            else if (counter == 1) {
                if (c != CharPool.LOWER_CASE_U) {
                    return false;
                }
            }
            else if ((counter == 2) || (counter == 3)) {
                if (c != CharPool.LOWER_CASE_L) {
                    return false;
                }
            }

            counter++;
        }

        if ((counter == 0) || (counter == 4)) {
            return true;
        }

        return false;
    }
}
