package com.blogspot.logarifm6.client.game_component;

import com.blogspot.logarifm6.client.gin.anotation.MaxAmountColumn;
import com.blogspot.logarifm6.client.gin.anotation.MaxAmountRow;
import com.blogspot.logarifm6.client.gin.anotation.MinAmountColumn;
import com.blogspot.logarifm6.client.gin.anotation.MinAmountRow;
import com.blogspot.logarifm6.client.gin.anotation.AmountColumn;
import com.blogspot.logarifm6.client.gin.anotation.AmountRow;
import com.blogspot.logarifm6.client.gin.anotation.AmountFlash;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Andrienko Alexander on 14.09.2014.
 *
 */
@Singleton
public class Settings {
  
  private int maxAmountColumn;

  private int maxAmountRow; 
  
  private int minAmountColumn;

  private int minAmountRow; 
  
  private int amountColumn;
  
  private int amountRow;
  
  private int amountFlash;
  
  @Inject
  public Settings(@MaxAmountColumn int maxAmountColumn,
                  @MaxAmountRow int maxAmountRow,
                  @MinAmountColumn int minAmountColumn,
                  @MinAmountRow int minAmountRow,
                  @AmountColumn int amountColumn,
                  @AmountRow int amountRow,
                  @AmountFlash int amountFlash) {
    
    this.maxAmountColumn = maxAmountColumn;
    this.maxAmountRow = maxAmountRow;
    
    this.minAmountColumn = minAmountColumn;
    this.minAmountRow = minAmountRow;
    
    this.amountColumn = amountColumn; 
    this.amountRow = amountRow;
    
    this.amountFlash = amountFlash;
  }
  
  public int getMaxAmountColumn() {
    return maxAmountColumn;
  }
  
  public int getMaxAmountRow() {
    return maxAmountRow;
  }
  
  public int getMinAmountColumn() {
    return minAmountColumn;
  }
  
  public int getMinAmountRow() {
    return minAmountRow;
  }
  
  public int getAmountColumn() {
    return amountColumn;
  }
  
  public int getAmountRow() {
    return amountRow;
  }
  
  public int getAmountFlash() {
    return amountFlash;
  }
  
  public void setMaxAmountRow(int maxAmountRow) {
    this.maxAmountRow = maxAmountRow; 
  }
  
  public void setMaxAmountColumn(int maxAmountColumn) {
    this.maxAmountColumn = maxAmountColumn; 
  }
  
  public void setMinAmountRow(int minAmountRow) {
    this.minAmountRow = minAmountRow; 
  }
  
  public void setMinAmountColumn(int minAmountColumn) {
    this.minAmountColumn = minAmountColumn; 
  }
  
  public void setAmountColumn(int amountColumn) {
    this.amountColumn = amountColumn; 
  }
  
   public void setAmountRow(int amountRow) {
    this.amountRow = amountRow; 
  }
  
  public void setAmountFlash(int amountFlash) {
    this.amountFlash = amountFlash; 
  }
}
