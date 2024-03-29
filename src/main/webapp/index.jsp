<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map.Entry"%>
<html
<head>
    <!--css-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/mystyles.css"  rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
    .banner-background{
    clip-path: polygon(0 0, 100% 0, 100% 79%, 0 95%);
    }
    .marquee-container {
        overflow: hidden;
        background-color: #F98866;
        white-space: nowrap;
    }

    .marquee-container p {
        display: inline-block;
        animation: marquee 15s linear infinite; /* Adjust duration as needed */
        transform: translateX(100%);
         color: white; /* Set text color to white */
            font-size: 20px; /* Set font size to 20 pixels */
    }

    @keyframes marquee {
        0% { transform: translateX(100%); }
        100% { transform: translateX(-100%); }
    }
    h3.display-3 {
            font-family: 'Times New Roman', Times, serif; /* Apply Times New Roman font to h3 elements with the class display-3 */
        }

</style>
</head>
<body>

<!--navbar-->
<%@include file="normal_navbar.jsp" %>

<!--banner-->
<div class="container-fluid p-0 m-0">
        <div class="marquee-container">
            <p>Stay updated with the latest in technology!</p>
        </div>

            <div class="jumbotron primary-background text-white banner-background">

                <div class="container">
                    <h3 class="display-3">Welcome to TechBlog </h3>

                    <p>Welcome to technical blog, world of technology
                        A programming language is a formal language, which comprises a set of instructions that produce various kinds of output. Programming languages are used in computer programming to implement algorithms.
                    </p>
                    <p>
                        Most programming languages consist of instructions for computers. There are programmable machines that use a set of specific instructions, rather than general programming languages.
                    </p>

                    <button class="btn btn-outline-light btn-lg"> <span class="fa 	fa fa-user-plus"></span>  Start ! its Free</button>
                    <a href="login_page.jsp" class="btn btn-outline-light btn-lg"> <span class="fa fa-user-circle fa-spin"></span>  Login</a>

                </div>
            </div>


        </div>

        <!--//card-->
        <div class="container">
            <div class="row mb-2">
                <div class="col-md-4">
                    <div class="card" "> <div class="card-body">
                        <h5 class="card-title">What is Collection Framework.</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn primary-background text-white">Read more</a>
                      </div>
                    </div>
                </div>

                 <div class="col-md-4">
                            <div class="card" "> <div class="card-body">
                                <h5 class="card-title">What is array in java?</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <a href="#" class="btn primary-background text-white">Read more</a>
                              </div>
                            </div>
                        </div>

                 <div class="col-md-4">
                                     <div class="card" "> <div class="card-body">
                                         <h5 class="card-title">What is Bit Manipulation?</h5>
                                         <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                         <a href="#" class="btn primary-background text-white">Read more</a>
                                       </div>
                                     </div>
                                 </div>



            </div>
            <div class="row">
                            <div class="col-md-4">
                                <div class="card" "> <div class="card-body">
                                    <h5 class="card-title">What is Programming?</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="btn primary-background text-white">Read more</a>
                                  </div>
                                </div>
                            </div>

                             <div class="col-md-4">
                                        <div class="card" "> <div class="card-body">
                                            <h5 class="card-title">What is Pyhton Programming?</h5>
                                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                            <a href="#" class="btn primary-background text-white">Read more</a>
                                          </div>
                                        </div>
                                    </div>

                             <div class="col-md-4">
                                                 <div class="card" "> <div class="card-body">
                                                     <h5 class="card-title">What is Java Programming?</h5>
                                                     <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                     <a href="#" class="btn primary-background text-white">Read more</a>
                                                   </div>
                                                 </div>
                                             </div>



             </div>
        </div>

<!--javascript-->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- <script src="js/myjs.js" type="text/javascript"></script> -->
<script>

</script>
</body>

</html>
