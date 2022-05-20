<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <link rel="stylesheet" href="./css/style.css" />
            <title>Logout Success</title>
        </head>
        <body>
            
            <header class="main-header">
                <nav>
                    <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                    <ul>
                        <li><a href="./register.jsp">Register</a></li>
                        <li><a href="./login.jsp">Login</a></li>
                        <li><a href="./Order.jsp">Order</a></li>
                        <li><a href="./Shipping.jsp">Shipping</a></li>
                    </ul>
                </nav>
            </header>
            <main>
                <section id="logout-success">
                    <header class="header-wrapper">
                        <h2>You have successfully been logged out.</h2>
                    </header>
                    <div class="content">
                        <p><a href="./index.jsp">Go back to home page.</a></p>
                    </div>
                </section>
            </main>
        </body>
    </html>
