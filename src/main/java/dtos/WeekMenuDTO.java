/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.WeekMenu;

/**
 *
 * @author Aske
 */
public class WeekMenuDTO {
    
       private Long id;
    private int weekNo;
    private int year;

    public WeekMenuDTO(Long id, int weekNo, int year) {
        this.id = id;
        this.weekNo = weekNo;
        this.year = year;
    }

    public WeekMenuDTO(int weekNo, int year) {
        this.weekNo = weekNo;
        this.year = year;
    }
    
    
    public WeekMenuDTO(WeekMenu wm) {
        this.id = wm.getId();
        this.weekNo = wm.getWeekNo();
        this.year = wm.getYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
