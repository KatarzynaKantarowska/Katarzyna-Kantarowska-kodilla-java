package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private final String bun;
    private final int burgersAmount;
    private final String sauce;
    private List<String> ingredients = new ArrayList<String>();

    public static class BigMacBuilder{
      private String bun;
      private int burgersAmount;
        private String sauce;
      private List<String> ingredients = new ArrayList<String>();

      public BigMacBuilder bun(String bun){
          this.bun = bun;
          return this;
      }
      public BigMacBuilder burgersAmount(int burgersAmount){
          this.burgersAmount = burgersAmount;
          return this;
      }
      public BigMacBuilder sauce(String sauce){
          this.sauce = sauce;
          return this;
      }
      public BigMacBuilder ingredient(String ingredient){
          this.ingredients.add(ingredient);
          return this;
      }
      public BigMac build(){
          return new BigMac(bun, burgersAmount, sauce, ingredients);
      }
    }

    private BigMac(String bun, int burgersAmount, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgersAmount = burgersAmount;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgersAmount() {
        return burgersAmount;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", burgersAmount=" + burgersAmount +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
