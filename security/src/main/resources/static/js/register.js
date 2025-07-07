function validateForm() {
    console.log()
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    // Check if passwords match
    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }

    // Check password length and special character
    if (password.length < 8 || !password.match(/[!@#$%^&*()_+{}\[\]:;<>,.?~\/\\`|\-=]/)) {
        alert("Password should be at least 8 characters long and contain at least one special character.");
        return false;
    }

    alert("User registered!");

    return true; // Allow form submission
}

function checkPasswordStrength(password) {
    var passwordStrengthElement = document.getElementById("passwordStrength");
    var strengthBar = document.getElementById("strengthBar");
    var strength = 0;

    // Show the password strength bar if the password is not empty
    if (password.length > 0) {
        passwordStrengthElement.style.display = "inline-block";
    } else {
        passwordStrengthElement.style.display = "none";
    }

    if (password.length >= 8) {
        strength += 1;
    }

    if (password.match(/[!@#$%^&*()_+{}\[\]:;<>,.?~\/\\`|\-=]/)) {
        strength += 1;
    }

    var strengthPercentage = strength * 50; // Assuming 2 criteria (50% each)

    // Update the strength bar width and color
    strengthBar.style.width = strengthPercentage + "%";
    strengthBar.style.backgroundColor = strength === 0 ? "red" : strength === 1 ? "yellow" : "green";
}
