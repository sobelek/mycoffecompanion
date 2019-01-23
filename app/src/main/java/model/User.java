package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class User {

        @SerializedName("points")
        @Expose
        private String points;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("isActive")
        @Expose
        private String isActive;
        @SerializedName("cardId")
        @Expose
        private String cardId;

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
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
        public String getCardId(){
            return cardId;
        }
        public void setCardId(String cardId){
            this.cardId = cardId;
        }

    }



























/*    public User(String cardId, String password){
        this.cardId = cardId;
        this.password = password;


    }

    public User(String cardId, String password, int isActive){
        this.cardId = cardId;
        this.password = password;
        this.isActive = isActive;

    }

    public User(String cardId){
        this.cardId = cardId;
    }

    public String getCardId(){
        return cardId;

    }
    public String getPassword(){
        return password;

    }
    public int getIsActive(){
        return isActive;
    }



}*/
