/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dns_shop.pages.utils;

/**
 *
 * @author vadim
 */
public enum WarrantyEnum {

   WARRANTY_NO(0),
   WARRANTY_ONE_YEAR(12),
   WARRANTY_TWO_YEAR(24);

   private int numMounts;

   WarrantyEnum(int num) {
       this.numMounts = num;
   }

   public int geWarranty() {
       return numMounts;
   } 
}
