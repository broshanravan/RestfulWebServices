package mehr.rest.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Description;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = " All information on the user")
public class UserBean {

    private Integer userId;

    @Size(min=3,message =" First name should have at least three characters")
    @ApiModelProperty(notes = "The length for first name should be at least 2 characters")
    private String firstName;

    @Size(min=3, message ="Surname should have at least three characters")
    @Size(max=15, message ="Surname can not be more than 15 Characters")
    @ApiModelProperty(notes = "The length for surname should be between 3 and 15 characters")
    private String surname;

    @Past(message ="Date of Birth should be in the past")
    @ApiModelProperty(notes = "Date of Birth should be in the past")
    private Date dateOfBirth;

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dateOfBirth +
                '}';
    }

    public UserBean(){

    }

    public UserBean(Integer userIdIn, String firstNameIn, String surnameIn, Date dateOfBirthIn){
        userId = userIdIn;
        firstName = firstNameIn;
        surname = surnameIn;
        dateOfBirth = dateOfBirthIn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirthIn) {
        dateOfBirth = dateOfBirthIn;
    }
}
