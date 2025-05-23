package com.yichen.userhub.util;


import org.springframework.util.ObjectUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateTimeUtils {
    public DateTimeUtils() {
    }

    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String getCurrentDateStr() {
        return LocalDate.now().format(DateTimeUtils.Pattern.DATE_ALL_NO_FORMATTER.getPattern());
    }

    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(DateTimeUtils.Pattern.DATE_SHORT_NO_FORMATTER.getPattern());
    }

    public static String getCurrentMonthStr() {
        return LocalDate.now().format(DateTimeUtils.Pattern.MONTH_ALL_NO_FORMATTER.getPattern());
    }

    public static String getCurrentDateTimeStrAllFormat() {
        return LocalDateTime.now().format(DateTimeUtils.Pattern.DATETIME_ALL_FORMATTER.getPattern());
    }

    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DateTimeUtils.Pattern.DATETIME_ALL_NO_FORMATTER.getPattern());
    }

    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(DateTimeUtils.Pattern.DATETIME_SHORT_NO_FORMATTER.getPattern());
    }

    public static String getCurrentTimeStr() {
        return LocalTime.now().format(DateTimeUtils.Pattern.TIME_ALL_NO_FORMATTER.getPattern());
    }

    public static String getCurrentDateStr(Pattern pattern) {
        return LocalDate.now().format(pattern.getPattern());
    }

    public static String getCurrentDateTimeStr(Pattern pattern) {
        return LocalDateTime.now().format(pattern.getPattern());
    }

    public static String getCurrentTimeStr(Pattern pattern) {
        return LocalTime.now().format(pattern.getPattern());
    }

    public static LocalDate parseLocalDate(String dateStr, Pattern pattern) {
        return LocalDate.parse(dateStr, pattern.getPattern());
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, Pattern pattern) {
        return LocalDateTime.parse(dateTimeStr, pattern.getPattern());
    }

    public static LocalTime parseLocalTime(String timeStr, Pattern pattern) {
        return LocalTime.parse(timeStr, pattern.getPattern());
    }

    public static String formatLocalDate(LocalDate date, Pattern pattern) {
        return date.format(pattern.getPattern());
    }

    public static String formatLocalDateTime(LocalDateTime datetime, Pattern pattern) {
        return datetime.format(pattern.getPattern());
    }

    public static String formatLocalTime(LocalTime time, Pattern pattern) {
        return time.format(pattern.getPattern());
    }

    public static LocalDate parseLocalDateAllFormat(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeUtils.Pattern.DATETIME_ALL_FORMATTER.getPattern());
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeUtils.Pattern.DATE_ALL_NO_FORMATTER.getPattern());
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeUtils.Pattern.DATETIME_ALL_NO_FORMATTER.getPattern());
    }

    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, DateTimeUtils.Pattern.TIME_ALL_NO_FORMATTER.getPattern());
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(DateTimeUtils.Pattern.DATE_ALL_NO_FORMATTER.getPattern());
    }

    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DateTimeUtils.Pattern.DATETIME_ALL_NO_FORMATTER.getPattern());
    }

    public static String formatLocalTime(LocalTime time) {
        return time.format(DateTimeUtils.Pattern.TIME_ALL_NO_FORMATTER.getPattern());
    }

    public static long durationYearsToNow(LocalDate startDate) {
        return startDate.until(getCurrentLocalDate(), ChronoUnit.YEARS);
    }

    public static long durationYears(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return startDateInclusive.until(endDateExclusive, ChronoUnit.YEARS);
    }

    public static long durationDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return startDateInclusive.until(endDateExclusive, ChronoUnit.DAYS);
    }

    public static List<LocalDate> getPeriodDates(LocalDate startDate, LocalDate endDate) {
        long days = durationDays(startDate, endDate);
        if (days < 0L) {
            return Collections.emptyList();
        } else {
            IntStream var10000 = IntStream.iterate(0, (i) -> {
                return i + 1;
            }).limit(days + 1L);
            startDate.getClass();
            return (List)var10000.mapToObj(startDate::plusDays).collect(Collectors.toList());
        }
    }

    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Boolean isBefore(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(endDate);
    }

    public static Boolean isAfter(LocalDate startDate, LocalDate endDate) {
        return startDate.isAfter(endDate);
    }

    public static Boolean isSameDay(LocalDate startDate, LocalDate endDate) {
        return startDate.equals(endDate);
    }

    public static Boolean isEffectiveDate(LocalDate nowTime, LocalDate startTime, LocalDate endTime) {
        if (!nowTime.equals(endTime) && !nowTime.equals(startTime)) {
            return isBefore(nowTime, endTime) && isAfter(nowTime, startTime) ? true : false;
        } else {
            return true;
        }
    }

    public static int dateCompare(LocalDate startDate, LocalDate endDate) {
        return startDate.compareTo(endDate);
    }

    public static int dateCompare(String startDateStr, String endDateStr) {
        LocalDate startDate = parseLocalDate(startDateStr, DateTimeUtils.Pattern.DATE_ALL_FORMATTER);
        LocalDate endDate = parseLocalDate(endDateStr, DateTimeUtils.Pattern.DATE_ALL_FORMATTER);
        return startDate.compareTo(endDate);
    }

    public static int dateTimeCompare(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return startDateTime.compareTo(endDateTime);
    }

    public static int dateTimeCompare(String startDateTimeStr, String endDateTimeStr) {
        LocalDateTime dateTimeOne = parseLocalDateTime(startDateTimeStr, DateTimeUtils.Pattern.DATETIME_ALL_FORMATTER);
        LocalDateTime dateTimeTwo = parseLocalDateTime(endDateTimeStr, DateTimeUtils.Pattern.DATETIME_ALL_FORMATTER);
        return dateTimeOne.compareTo(dateTimeTwo);
    }

    public static LocalDateTime getTodayDayStart() {
        return getDayStart(getCurrentLocalDate());
    }

    public static LocalDateTime getDayStart(LocalDate date) {
        return null == date ? null : LocalDateTime.of(date, LocalTime.MIN);
    }

    public static LocalDateTime getDayEnd(LocalDate date) {
        return null == date ? null : LocalDateTime.of(date, LocalTime.MAX);
    }

    public static LocalDateTime getTodayDayEnd() {
        return getDayEnd(getCurrentLocalDate());
    }

    public static LocalDate getBeforDay(LocalDate date) {
        return date.minusDays(1L);
    }

    public static String getDateString(Pattern pattern, int i) {
        LocalDate localDate = getCurrentLocalDate().plusDays((long)i);
        return formatLocalDate(localDate, pattern);
    }

    public static String getDateString(LocalDate date, Pattern pattern, int i) {
        if (null == date) {
            date = getCurrentLocalDate();
        }

        LocalDate localDate = date.plusDays((long)i);
        return formatLocalDate(localDate, pattern);
    }

    public static boolean isLastDayOfMonth(LocalDate date) {
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        return 0 == lastDay.compareTo(date);
    }

    public static boolean isFirstDayOfMonth(LocalDate date) {
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        return 0 == firstDay.compareTo(date);
    }

    public static boolean isLastDayOfSeason(LocalDate date) {
        if (!isLastDayOfMonth(date)) {
            return false;
        } else {
            int month = date.getMonthValue();
            return month == 3 || month == 6 || month == 9 || month == 12;
        }
    }

    public static boolean isFirstDayOfSeason(LocalDate date) {
        if (!isFirstDayOfMonth(date)) {
            return false;
        } else {
            int month = date.getMonthValue();
            return month == 1 || month == 4 || month == 7 || month == 10;
        }
    }

    public static boolean isLastDayOfHalfYear(LocalDate date) {
        if (!isLastDayOfMonth(date)) {
            return false;
        } else {
            int month = date.getMonthValue();
            return month == 6 || month == 12;
        }
    }

    public static boolean isFirstDayOfHalfYear(LocalDate date) {
        if (!isFirstDayOfMonth(date)) {
            return false;
        } else {
            int month = date.getMonthValue();
            return month == 7 || month == 1;
        }
    }

    public static boolean isLastDayOfYear(LocalDate date) {
        if (isLastDayOfMonth(date)) {
            int month = date.getMonthValue();
            return month == 12;
        } else {
            return false;
        }
    }

    public static boolean isFirstDayOfYear(LocalDate date) {
        if (isFirstDayOfMonth(date)) {
            int month = date.getMonthValue();
            return month == 1;
        } else {
            return false;
        }
    }

    public static Integer getDayOfYear(LocalDate date) {
        return null == date ? null : date.getDayOfYear();
    }

    public static Integer getDayOfMonth(LocalDate date) {
        return null == date ? null : date.getDayOfMonth();
    }

    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
        return null == localDateTime ? null : localDateTime.toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        return null == localDate ? null : LocalDateTime.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), 0, 0);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        } else {
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = localDateTime.atZone(zoneId);
            return Date.from(zdt.toInstant());
        }
    }

    public static Date toDate(LocalDate localDate) {
        if (null == localDate) {
            return null;
        } else {
            ZoneId zone = ZoneId.systemDefault();
            ZonedDateTime zdt = localDate.atStartOfDay().atZone(zone);
            return Date.from(zdt.toInstant());
        }
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        } else {
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }
    }

    public static LocalDateTime parseToLocalDateTime(CharSequence text) {
        return parse(text, (DateTimeFormatter)null);
    }

    public static LocalDate parseToLocalDate(CharSequence text) {
        return parseDate(text, (DateTimeFormatter)null);
    }

    public static LocalDateTime of(TemporalAccessor temporalAccessor) {
        if (null == temporalAccessor) {
            return null;
        } else {
            return temporalAccessor instanceof LocalDate ? ((LocalDate)temporalAccessor).atStartOfDay() : LocalDateTime.of(get(temporalAccessor, ChronoField.YEAR), get(temporalAccessor, ChronoField.MONTH_OF_YEAR), get(temporalAccessor, ChronoField.DAY_OF_MONTH), get(temporalAccessor, ChronoField.HOUR_OF_DAY), get(temporalAccessor, ChronoField.MINUTE_OF_HOUR), get(temporalAccessor, ChronoField.SECOND_OF_MINUTE), get(temporalAccessor, ChronoField.NANO_OF_SECOND));
        }
    }

    public static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter) {
        if (null == text) {
            return null;
        } else {
            return null == formatter ? LocalDateTime.parse(text) : of(formatter.parse(text));
        }
    }

    public static LocalDate parseDate(CharSequence text, DateTimeFormatter formatter) {
        if (null == text) {
            return null;
        } else {
            return null == formatter ? LocalDate.parse(text) : ofDate(formatter.parse(text));
        }
    }

    public static LocalDate parseDate(CharSequence text, String format) {
        return null == text ? null : parseDate(text, DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate ofDate(TemporalAccessor temporalAccessor) {
        if (null == temporalAccessor) {
            return null;
        } else {
            return temporalAccessor instanceof LocalDateTime ? ((LocalDateTime)temporalAccessor).toLocalDate() : LocalDate.of(get(temporalAccessor, ChronoField.YEAR), get(temporalAccessor, ChronoField.MONTH_OF_YEAR), get(temporalAccessor, ChronoField.DAY_OF_MONTH));
        }
    }

    public static int get(TemporalAccessor temporalAccessor, TemporalField field) {
        return temporalAccessor.isSupported(field) ? temporalAccessor.get(field) : (int)field.range().getMinimum();
    }

    public static enum Pattern {
        DATETIME_ALL_FORMATTER("yyyy-MM-dd HH:mm:ss"),
        DATETIME_ALL_NO_FORMATTER("yyyyMMddHHmmss"),
        DATETIME_SHORT_NO_FORMATTER("yyMMddHHmmss"),
        DATE_ALL_FORMATTER("yyyy-MM-dd"),
        DATE_ALL_NO_FORMATTER("yyyyMMdd"),
        DATE_SHORT_NO_FORMATTER("yyMMdd"),
        MONTH_ALL_FORMATTER("yyyy-MM"),
        MONTH_ALL_NO_FORMATTER("yyyyMM"),
        TIME_ALL_FORMATTER("HH:mm:ss"),
        TIME_ALL_NO_FORMATTER("HHmmss");

        private DateTimeFormatter pattern;

        private Pattern(String pattern) {
            this.pattern = DateTimeFormatter.ofPattern(pattern);
        }

        public DateTimeFormatter getPattern() {
            return this.pattern;
        }

        public void setPattern(DateTimeFormatter pattern) {
            this.pattern = pattern;
        }
    }
}
