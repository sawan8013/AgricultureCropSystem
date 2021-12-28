<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/style.css}"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form action="/pgredirect" method = "post">
    <div class="container register">
        <div class="row">
            <div class="col-md-3 register-left">
            </div>
            <div class="col-md-9 register-right">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3 class="register-heading">Welcome to Paytm Payment</h3>
                        <div class="row register-form">
                            <div class="col-md-10">
                            </div>
                                
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Customer ID" value=""
                                           name="CUST_ID"/>
                                           </div>
                                           <br>
                                           
                                      <div class="form-group">      
                                    <input id="ORDER_ID" class="form-control"  placeholder="ORDER ID"
                                           name="ORDER_ID"  >
                                           </div>
                                           
                                           
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Enter Your Name" value=""
                                           name="NAME"/>
                                            <br>
                          
                                           <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter Your No" value=""
                                           name="Phone no"/>
                                            <br>
                                            
                                            
                                            <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter your bank a/c no" value=""
                                           name="Account no"/>
                                            <br>
                                             <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter your bank IFSC code" value=""
                                           name="IFSC code"/>
                                            <br>
                               </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Amount" value=""
                                           name="TXN_AMOUNT"/>
                                            <br>
                                </div>
                                <button type="submit" class="btnRegister" style="align : center">Pay with Paytm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>