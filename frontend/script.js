const API_URL =
    "http://localhost:8081/auth";

// =========================
// REGISTER
// =========================

async function register() {

    const name =
        document.getElementById(
            "name"
        ).value;

    const email =
        document.getElementById(
            "email"
        ).value;

    const password =
        document.getElementById(
            "password"
        ).value;

    const message =
        document.getElementById(
            "message"
        );

    // VALIDATION

    if(
        name === "" ||
        email === "" ||
        password === ""
    ){

        message.style.color =
            "red";

        message.innerText =
            "Please fill all fields";

        return;

    }

    try{

        const response =
            await fetch(

                `${API_URL}/register`,

                {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/json"
                    },

                    body: JSON.stringify({

                        name,
                        email,
                        password

                    })

                }

            );

        const data =
            await response.text();

        message.style.color =
            "green";

        message.innerText =
            data;

    }

    catch(error){

        message.style.color =
            "red";

        message.innerText =
            "Server Error";

    }

}

// =========================
// LOGIN
// =========================

async function login() {

    const name =
        document.getElementById(
            "name"
        ).value;

    const email =
        document.getElementById(
            "email"
        ).value;

    const password =
        document.getElementById(
            "password"
        ).value;

    const message =
        document.getElementById(
            "message"
        );

    // VALIDATION

    if(
        email === "" ||
        password === ""
    ){

        message.style.color =
            "red";

        message.innerText =
            "Please fill all fields";

        return;

    }

    try{

        const response =
            await fetch(

                `${API_URL}/login`,

                {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/json"
                    },

                    body: JSON.stringify({

                        email,
                        password

                    })

                }

            );

        // SUCCESS

        if(response.ok){

            const user =
                await response.json();
            console.log(user);

            const userName =
                user.name || name;

            localStorage.setItem(
                "userId",
                user.id
            );
            localStorage.setItem(
                "userEmail",
                email
            );

            localStorage.setItem(
                "userName",
                userName || ""
            );

            message.style.color =
                "green";

            message.innerText =
                "Login Successful";

            // REDIRECT WITH EMAIL + NAME

            setTimeout(() => {

                window.location.href =

                `features.html?userEmail=${encodeURIComponent(email)}&userName=${encodeURIComponent(userName || "")}`;

            },1000);

        }

        // FAILED

        else{

            message.style.color =
                "red";

            message.innerText =
                "Invalid Email or Password";

        }

    }

    catch(error){

        message.style.color =
            "red";

        message.innerText =
            "Server Error";

    }

}
