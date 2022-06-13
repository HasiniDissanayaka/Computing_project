package com.example.computingproject.UniqueUserHelperClass;

public class  UniqueUserHelperClass {

    String userNIC, userEmail;

    public UniqueUserHelperClass ( ) {
    }


    public UniqueUserHelperClass ( String userNIC , String userEmail ) {
        this.userNIC = userNIC;
        this.userEmail = userEmail;
    }

    public String getUserNIC ( ) {
        return userNIC;
    }

    public void setUserNIC ( String userNIC ) {
        this.userNIC = userNIC;
    }

    public String getUserEmail ( ) {
        return userEmail;
    }

    public void setUserEmail ( String userEmail ) {
        this.userEmail = userEmail;
    }
}
