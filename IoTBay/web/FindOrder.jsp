<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Order</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
        <form action="FindOrderServlet" method="post">
            <table id="form_table">
                <tr>
                    <td>Please enter your OrderID</td>
                    <td><input type="text" placeholder="Enter OrderID" name="OrderID" required/></td>
                </tr>
                <tr>
                    <td>Please enter your Date</td>
                    <td><input type="text" placeholder="Enter Date" name="Date" required/></td>
                </tr>
            </table>
        </form>
        <jsp:include page="/FindOrderServlet" flush="true" />
    </body>
</html>
