package com.java4all.util;

/**
 * description:
 *
 * @author IT云清
 * @date 2019/2/2 22:22
 */
public final class AssertUtils {

    private AssertUtils() {

    }

    public static void notNull(final Object obj) {
        if (obj == null) {
            throw new RuntimeException("argument invalid,Please check");
        }
    }

}
