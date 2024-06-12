package com.example.demo;

 class Phrases {
     protected String phrase;

     public String getPhrase() {
         return phrase;
     }

     public void setPhrase(String phrase) {
         this.phrase = phrase;
     }

     @Override
     public String toString() {
         return phrase;
     }
 }
