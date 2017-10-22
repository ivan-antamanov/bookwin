<%--
  Created by IntelliJ IDEA.
  User: iantaman
  Date: 21.10.2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Uploading Form</title>
</head>
<body>

<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    Name: <input type="text" name="name"><br /> <br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</body>
</html>
