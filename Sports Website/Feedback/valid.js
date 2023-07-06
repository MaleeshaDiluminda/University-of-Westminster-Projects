/* Validation Javascript Part */

function validate(){

/*This is where the user enters his or her details and feedback*/

  var name = document.getElementById("username").value;
  var subject = document.getElementById("subject").value;
  var phone = document.getElementById("phone").value;
  var email = document.getElementById("email").value;
  var message = document.getElementById("message").value;
  var errormessage = document.getElementById("errormessage");

  errormessage.style.padding = "10px";

  var text;

/*If the length of the text is less than 5, this displays an error.*/

  if(name.length < 5){

    text = "Please Enter valid Name";
    errormessage.innerHTML = text;
    return false;
  }
  
/*If the length of the subject is less than 5, this displays an error.*/

  if(subject.length < 5){

    text = "Please Enter Correct Subject";
    errormessage.innerHTML = text;
    return false;
  }
  
/*If the length of the phone number is less than 10 and if it not a number, this displays an error.*/

  if(isNaN(phone) || phone.length != 10){

    text = "Please Enter valid Phone Number";
    errormessage.innerHTML = text;
    return false;
  }
  
/*If the email is invalid, this displays an error.*/

  if(email.indexOf("@") == -1 || email.length < 6){

    text = "Please Enter valid Email";
    errormessage.innerHTML = text;
    return false;
  }
  
/*If the user's massage is less than 15, this displays an error.*/

  if(message.length <= 15){

    text = "Please Enter More Than 15 Characters";
    errormessage.innerHTML = text;
    return false;
  }
  
/*This send a massage to the user when the feedback is done*/

  alert("Thank you we appreciate your feedback");
  return true;
} 


