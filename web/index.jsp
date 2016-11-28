<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>login</title>
</head>
<body>
<head>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
  <link rel="stylesheet" href="css/custom.css">
</head>
<body>
<div class="section"></div>
<main>
  <center>
    <img class="responsive-img" style="width: 400px;" src="images/dwitLogo.png"/>
    <div class="container">
      <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
        <h5 class="indigo-text">Welcome to DWIT Quiz,<br> Login into your account</h5>
        <div class="section"></div>
        <form class="col s12" method="post" action="login">
          <input type="hidden" name="page" value="login">
          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='text' name='username' id='username' />
              <label for='username'>Username</label>
            </div>
          </div>
          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='password' name='password' id='password' />
              <label for='password'>Password</label>
            </div>
            <label style='float: right;'>
              <a class='pink-text' href='#!'><b>Forgot Password?</b></a>
            </label>
          </div>

          <br/>
            <div class='row'>
              <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>
            </div>
        </form>
      </div>
    </div>
  </center>
</main>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</body>
</html>