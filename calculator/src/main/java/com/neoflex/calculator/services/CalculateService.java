package com.neoflex.calculator.services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Service
public class CalculateService {
    public String calculateVacationPay(int salary,int days,String date){
        if(date!="") {
            String[] a = date.split("-");
            //Праздничные дни
            LocalDate JanuaryHolidaysStart  = LocalDate.of(2022,1,1);
            LocalDate JanuaryHolidaysEnd  = LocalDate.of(2022,1,9);

            LocalDate FebruaryHolidayDay  = LocalDate.of(2022,2,23);

            LocalDate MarchHolidaysStart  = LocalDate.of(2022,3,6);
            LocalDate MarchHolidaysEnd  = LocalDate.of(2022,3,8);

            LocalDate AprilHolidayDay = LocalDate.of(2022,4,30);

            LocalDate MayHolidaysStart  = LocalDate.of(2022,5,1);
            LocalDate MayHolidaysEnd = LocalDate.of(2022,5,3);
            LocalDate MayHolidaysStart1  = LocalDate.of(2022,5,7);
            LocalDate MayHolidaysEnd1  = LocalDate.of(2022,5,10);

            LocalDate JuneHolidaysStart  = LocalDate.of(2022,6,11);
            LocalDate JuneHolidaysEnd  = LocalDate.of(2022,6,13);

            LocalDate NovemberHolidaysStart  = LocalDate.of(2022,11,4);
            LocalDate NovemberHolidaysEnd  = LocalDate.of(2022,11,6);

            int year = Integer.parseInt(a[0]);
            int day = Integer.parseInt(a[2]);
            int month = Integer.parseInt(a[1]);
            LocalDate d = LocalDate.of(year, month, day);
            int count = 0; //Количество праздничных дней выпавших на отпуск
            for (int i = days; i > 0; i--) {
                if(d.getMonthValue()==JanuaryHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=JanuaryHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=JanuaryHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==FebruaryHolidayDay.getMonthValue()){
                    if(d.getDayOfMonth()==FebruaryHolidayDay.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==AprilHolidayDay.getMonthValue()){
                    if(d.getDayOfMonth()==AprilHolidayDay.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==MarchHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=MarchHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=MarchHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==MayHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=MayHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=MayHolidaysEnd.getDayOfMonth() ||
                            d.getDayOfMonth()>=MayHolidaysStart1.getDayOfMonth() && d.getDayOfMonth()<=MayHolidaysEnd1.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==JuneHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=JuneHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=JuneHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==NovemberHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=NovemberHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=NovemberHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                d = d.plusDays(1);
            }
            days=days-count;
        }
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        double vacPay = (salary*12)/12/29.3 * days;
        return decimalFormat.format(vacPay);
    }
}
