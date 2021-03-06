<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />"/>
</head>
<body>

<div id="customer_form">
    <h1>Hi! Are you hungry?</h1>
    <h2>
        <a href="/">Home</a>
    </h2>
    <form action="create" method="POST">
        <fieldset>
            <legend>Please enter your name</legend>
            <ul>
                <li>Name: <input type="input" name="name" id="name" /></li>
                <li>Date of Birth: <input type="input" name="dob" id="dob" /></li>
            </ul>
        </fieldset>
        <input type="submit"/>
    </form>
</div>

</body>
</html>