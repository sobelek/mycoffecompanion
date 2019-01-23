package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result{

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("points")
    @Expose
    private String points;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("isActive")
    @Expose
    private String isActive;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    public void setMessage(String message){
        this.message= message;
    }
    public String getMessage(){
        return message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}























/*
public class Result {
    @SerializedName("success")
    @Expose
    private int success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private List<User> user = null;


    public Result(int success, String message, List<User> user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<User> getUser() {
        return user;
    }
}
*/
