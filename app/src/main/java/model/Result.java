package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("success")
    @Expose
    private int success;
    @SerializedName("user")
    @Expose
    private List<User> user = null;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
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
