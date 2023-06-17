package com.simple.crud.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "first name not blank")
    @Length(min = 5,max = 30,message = "Human name between 5 - 30")
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private float weigth;
    private float heigth;
    private String sexe;
    private String food;
    private String tasks;
    private String date;

    public Human(){
        super();
    }

    
    public Human(Integer id,
            @NotBlank(message = "first name not blank") @Length(min = 5, max = 30, message = "Human name between 5 - 30") String firstName,
            String lastName, String email, String mobile, float weigth, float heigth, String sexe, String food,
            String tasks, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.weigth = weigth;
        this.heigth = heigth;
        this.sexe = sexe;
        this.food = food;
        this.tasks = tasks;
        this.date = date;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Human [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", mobile=" + mobile + ", weigth=" + weigth + ", heigth=" + heigth + ", sexe=" + sexe + ", food="
                + food + ", tasks=" + tasks + ", date=" + date + "]";
    }

    
    
}
