package com.neoflex.calculator.services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CalculateService {
    public String calculateVacationPay(int salary,int days,String date){
        if(date!="") {
            String[] a = date.split("-");

            int year = Integer.parseInt(a[0]);
            int day = Integer.parseInt(a[2]);
            int month = Integer.parseInt(a[1]);
            LocalDate d = LocalDate.of(year, month, day);
            int count = 0; // количество выходных
            for (int i = days; i > 0; i--) {
                if (d.getDayOfWeek() == DayOfWeek.SUNDAY || d.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    count++;
                }
                d = d.plusDays(1);
            }
            days = days - count;
        }
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        double vacPay = (salary*12)/12/29.3 * days;
        String result = decimalFormat.format(vacPay);
        return result;
    }
}