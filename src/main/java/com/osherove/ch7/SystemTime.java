package com.osherove.ch7;

import java.time.LocalDateTime;

public class SystemTime {

    private static LocalDateTime localDateTime;

    // 允許修改目前時間
    public static void setLocalDateTime(LocalDateTime custom) {
        SystemTime.localDateTime = custom;
    }

    // 也可以重置目前時間
    public static void reset() {
        localDateTime = LocalDateTime.MIN;
    }

    public static LocalDateTime now() {
        // 如果有設定時間，SystemTime 就回傳假時間；如果沒有設定，就回傳真實時間
        if (localDateTime != null && !localDateTime.isEqual(LocalDateTime.MIN)) {
            return localDateTime;
        }
        return LocalDateTime.now();
    }

}
