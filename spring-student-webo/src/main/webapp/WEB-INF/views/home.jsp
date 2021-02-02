<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="students-by-city">
Enter City<input type="text" name="city"><br>
<input type="submit" value="ByCity"><br>
</form>
<form action="students-by-courses">
Enter City<input type="text" name="courseName"><br>
<input type="submit" value="ByCourses"><br>
</form>
${studentsList }
${error}
</body>
</html>