<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sorry ! Something Went Wrong..</title>
    <!--css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css"  rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .banner-background{
            clip-path: polygon(0 0, 100% 0, 100% 79%, 0 95%);
            }
        </style>
</head>
<body>
    <div class="container text-center">
    <img src="img/error_icon.png" class="img-fluid" width="300" height="300">
    <h3 class="display-3">Sorry ! Something went wrong...</h3>
    <%= exception%>
    <a href="index.jsp" class="btn primary-background btn-lg text-white mt-3">Home</a>
    </div>
</body>
</html>