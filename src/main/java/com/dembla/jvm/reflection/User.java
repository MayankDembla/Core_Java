package com.dembla.jvm.reflection;

public class User {

      private int id ;
      private String name ;
      private String email ;
      private String gender ;
      private String userType ;

      User(){
      }

    public User(int id, String name, String email, String gender, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.userType = userType;
    }

    public boolean saveWebLink(String url, String title){
          System.out.println("\n Saving Web Link ... ") ;
          System.out.println("WebLink URL : " + url) ;
          System.out.println("Title : " + title) ;
          return  true ;
    }

    public void postBookMarkReview(int bookmarkId, String bookmarkType, String review) {
          System.out.println("\n Posting bookmark Review") ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
