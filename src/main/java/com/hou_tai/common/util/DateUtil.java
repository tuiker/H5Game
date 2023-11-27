package com.hou_tai.common.util;

import com.hou_tai.common.constant.CommonNum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DateUtil
 * @Description: 日期处理
 * @Author: Sam
 * @Date: 2023-10-27 10:14
 * @Version: 1.0
 **/
public class DateUtil {

    /**
     * 获取截止本月前12个月
     * @return
     */
    public static List<String> getLast12Months() {
        List<String> months = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (int i = 0; i < 12; i++) {
            LocalDateTime dateTime = currentDateTime.minusMonths(i);
            String formattedMonth = dateTime.format(formatter);
            months.add(formattedMonth);
        }

        return months;
    }

    /**
     * @Author Sam
     * @Description 获取今天往前推
     * @Date 10:28 2023/10/30
     * @Param  * @param dateType 1天 2月 3年
     * @param num 天数/月数/年数
     * @return List<String>
     **/
    public static List<String> getTodayBefore(int dateType,int num){
        List<String> datas = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = dateType==CommonNum.THREE?DateTimeFormatter.ofPattern("yyyy")
                :dateType==CommonNum.TWO?DateTimeFormatter.ofPattern("yyyy-MM"):DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < num; i++) {
            LocalDateTime previousDateTime =null;
            if(dateType== CommonNum.ONE){
                previousDateTime = currentDateTime.minusDays(i);
            }
            if(dateType== CommonNum.TWO){
                previousDateTime = currentDateTime.minusMonths(i);
            }
            if(dateType== CommonNum.THREE){
                previousDateTime = currentDateTime.minusYears(i);
            }
            String formatted = previousDateTime.format(formatter);
            datas.add(formatted);
        }
        return datas;
    }

    /**
     * @Author Sam
     * @Description 日期间数据
     * @Date 14:38 2023/10/30
     *  @param startDate
     *  @param endDate
     * @return List<String>
     **/
    public static List<String> getDatesBetween(LocalDate startDate, LocalDate endDate,boolean monthCheck) {
        List<String> dates = new ArrayList<>();
        DateTimeFormatter formatter = monthCheck?DateTimeFormatter.ofPattern("yyyy-MM"):DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long between =0l;
        if(monthCheck){
            between = ChronoUnit.MONTHS.between(startDate, endDate);
        }else{
            between = ChronoUnit.DAYS.between(startDate, endDate);
        }

        for (int i = 0; i <= between; i++) {
            LocalDate currentDate=null;
            if(monthCheck){
                currentDate = startDate.plusMonths(i);
            }else{
                currentDate = startDate.plusDays(i);
            }
            dates.add(currentDate.format(formatter));
        }
        return dates;
    }

    public static void main(String[] args) {
        LocalDate s=LocalDate.of(2023,1,30);
        LocalDate e=LocalDate.now();
        System.out.println(getDatesBetween(s,e,false));

    }
}
