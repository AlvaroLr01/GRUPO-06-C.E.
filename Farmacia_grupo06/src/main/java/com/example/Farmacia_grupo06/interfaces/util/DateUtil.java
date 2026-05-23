package com.example.Farmacia_grupo06.interfaces.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtil {

    public static final String TIME_ZONE = "America/Bogota";

    public static LocalDateTime getCurrentLocalDateTime() {
        ZonedDateTime fecha = ZonedDateTime.now(ZoneId.systemDefault());
        return fecha.withZoneSameInstant(ZoneId.of(TIME_ZONE)).toLocalDateTime();
    }
}
